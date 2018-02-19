package com.example.dell.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //通过点击按钮来获取EditText中输入内容
    private EditText editText;

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

        //通过点击按钮来获取EditText中输入内容,findViewById()得到EditText的实例
        editText = (EditText) findViewById(R.id.edit_text);
        //使用实现接口的方式来注册
        button.setOnClickListener(this);
    }

    //使用实现接口的方式来注册
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                //通过点击按钮来获取EditText中输入内容
                String inputText = editText.getText().toString(); //getText()获取输入的内容，toString()转换成字符串，Toast显示作用
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
