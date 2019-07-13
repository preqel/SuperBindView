package com.example.stillaapt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import com.example.annotation.BindView;
import com.example.applib.BindViewTools;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView mTextView;
    @BindView(R.id.btn)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindViewTools.bind(this);
        if(mTextView!= null){
            mTextView.setText("hello ");
        }
    }
}
