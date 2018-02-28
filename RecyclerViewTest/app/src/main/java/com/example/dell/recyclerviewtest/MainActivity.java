package com.example.dell.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();   //初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);//获得RecyclerView实例
        //为了设置瀑布布局
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //创建StaggeredGridLayoutManager实例，第一个参数用于指定布局的列数，第二个为布局的排列方向，此处为纵向排列

        //横向滚动
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //创建LinearLayoutManager对象，LinearLayoutManager为线性布局，LayoutManager用于指定RecyclerView的布局方式
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //调用LinearLayoutManager中setOrientation()方法设置布局排列方向，默认纵向，此处传入的参数为让布局横向排列

        recyclerView.setLayoutManager(layoutManager);//设置到RecyclerView中
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        //完成适配器设置，使得RecyclerView和数据之间的关联建立完成

    }

    private void initFruits() {
        for(int i=0;i<2;i++){
            //Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            //Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic);
            fruitList.add(banana);
            //Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic);
            fruitList.add(orange);
            //Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            //Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic);
            fruitList.add(pear);
            //Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic);
            fruitList.add(grape);
            //Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            //Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            //Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
            fruitList.add(cherry);
            //Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic);
            fruitList.add(mango);

        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }

}
