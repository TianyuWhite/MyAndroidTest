package com.example.dell.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);  //findViewById()获得布局文件中定义的元素，返回的为一个View对象
        // 使用匿名类的方式来注册监听器
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        //使用实现接口的方式来注册
        button.setOnClickListener(this);
    }

    //使用实现接口的方式来注册
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                //...
                break;
            default:
                break;
        }
    }
}
