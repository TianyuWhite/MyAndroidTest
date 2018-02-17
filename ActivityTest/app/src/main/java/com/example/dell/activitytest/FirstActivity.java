package com.example.dell.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", this.toString());
        setContentView(R.layout.first_layout);
        //点击按钮弹出Toast触发点
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
                //销毁活动
                //finish();
                //显示Intent的用法
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);
                //基本隐式Intent的用法
                // Intent intent = new Intent("com.example.dell.activitytest.ACTION_START");
                //intent.addCategory("com.example.dell.activitytest.MY_CATEGORY");
                //startActivity(intent);
                //更多隐式Intent用法，如弹出选择方式
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);
                //点击按钮出来拨号盘
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse( "tel:10086"));
                //startActivity(intent);
                //向下一个活动传递数据
                //String data = "Hello SecondActivity";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);   //显示调用Intent
                //intent.putExtra("extra_data", data);    //putExtra()中两个参数，第一个参数为键，用于后面从Intent中取值，
                                                                                      // 第二个参数为传递的数值
                //startActivity(intent);

                //返回数据给上一个活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);   //显示调用Intent
                //startActivityForResult(intent, 1); //1为请求码，用于在之后的回调中判断数据的来源

                //standard活动默认启动方式
                //Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                //startActivity(intent);

                //singleTop
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public FirstActivity() {
        super();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        //第一个参数requestCode，即在启动活动时传入请求码
        //第二个参数resultCode，返回数据时传入的处理结果
        //第三个参数data，携带返回数据的Intent
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_retrun");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

}
