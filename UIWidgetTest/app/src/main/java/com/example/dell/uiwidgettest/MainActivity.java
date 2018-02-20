package com.example.dell.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //通过点击按钮来获取EditText中输入内容  文本框
    private EditText editText;
    //动态改变代码  图片
    private ImageView imageView;
    //设置进度条消失
    private ProgressBar progressBar;

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
        //动态改变图片
        imageView = (ImageView) findViewById(R.id.image_view);
        //设置进度条消失
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
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
                //动态改变图片，即用2替换1图
                imageView.setImageResource(R.drawable.img_2);//setImageResource();将显示的图片改成了img_2

                //使进度条在加载完成时消失,圆形进度条情况
                /*if(progressBar.getVisibility()==View.GONE){ //如果不可见就让他可见显示，如果可见就让其消失
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }*/

                //给进度条设置一个最大值，水平进度条
                /*int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                //弹出的对话框
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {//确认按钮点击事件
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {//取消按钮点击事件
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();*/

                //带进度条的对话框
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);//设置是否能通过Back键进行取消
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
