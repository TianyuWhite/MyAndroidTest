package com.example.dell.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
                                "Strawberry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon",
                                "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};
    */

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();   //初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);

     //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        for(int i=0;i<2;i++){
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(apple);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(apple);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(apple);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(apple);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(apple);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(apple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(apple);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(apple);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(apple);

        }
    }
}