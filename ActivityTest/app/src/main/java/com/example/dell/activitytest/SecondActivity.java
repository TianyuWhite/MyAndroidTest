package com.example.dell.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        //Intent intent = getIntent();   //getIntent()用于启动SA的Intent
        //String data = intent.getStringExtra("extra_data");      //getStringExtra()来获取由FA(即上一活动)传递来的数据
        //Log.d("SecondActivity", data);     //用于打印一些调试信息
        Button button2 = (Button) findViewById(R.id.button_2);  //findViewById(R.id.button_2);获取到在布局文件中定义的元素，项目中添加的任何资源都会R文件中生成一个相应的资源id
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent();   //Intent仅用于传递数据
                //intent.putExtra("data_return", "HelloFirstActivity");
                //setResult(RESULT_OK, intent);   //setResult()专门用于向上一活动返回数据，第一参数用于向上一个活动返回处理结果，第二参数把带有数据的Intent传递回去
                //finish();

                //singleTop
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    //若不重写这个方法，则在back键返回时就不打印日志，只有单单依靠按钮返回打印
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
