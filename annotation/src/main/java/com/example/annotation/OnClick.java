package com.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * Author: preqel
 * Created on: 2019-07-15.
 * Description:
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface OnClick {
    int value();
}
