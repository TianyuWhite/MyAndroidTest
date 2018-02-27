package com.example.dell.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2018/2/26.
 */

public class FruitAdapter extends ArrayAdapter <Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View converView, ViewGroup parent){
        //converView用于将之前加载好的布局进行缓存
        Fruit fruit = getItem(position);        //获取当前项的Fruit实例
        //View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        //LayoutInflater为子项加载传入的布局

        View view;
        ViewHolder viewHolder;      //ViewHolder为一个内部类,对控件实例进行缓存
        //现在在getView方法中进行判断， 若convertView为null， 则加载布局，不为null则重用
        if(converView == null){
            //view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();  //为null时创建实例，实例都存放在ViewHolder里
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);        //setTag()将ViewHolder存在View中
        }
        else{
            view = converView;
            viewHolder = (ViewHolder) view.getTag();    //getTag()重新获取ViewHolder
        }

        /*ImageView fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());*/

        //这样所有实例都缓存在ViewHolder里了，无需每次都通过findViewById()来获取控件实例
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    private class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
