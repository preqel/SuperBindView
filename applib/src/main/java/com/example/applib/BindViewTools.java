package com.example.applib;

import android.app.Activity;
import android.view.View;

import com.example.annotation.OnClick;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.reflect.Modifier.PRIVATE;

/**
 * Author: preqel
 * Created on: 2019-07-13.
 * Description:
 */
public class BindViewTools {


    public static void bind(final Activity activity) {

        final Class clazz = activity.getClass();

        if((clazz.getModifiers() & PRIVATE )!=0){
            throw new IllegalArgumentException(clazz.getName() + " must not be private.");
        }


        try {
            Class bindViewClass = Class.forName(clazz.getName() + "_ViewBinding");
            Method method = bindViewClass.getMethod("bind", activity.getClass());
            method.invoke(bindViewClass.newInstance(), activity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for(final Method method:clazz.getDeclaredMethods()){
            final OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick == null) {
                continue;
        }
        int id = onClick.value();
            //绑定点击事件
        activity.findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        method.invoke(activity,null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
         });
        }
    }


}
