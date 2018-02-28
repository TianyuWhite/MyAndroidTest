package com.example.dell.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dell on 2018/2/28.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    /*
    FruitAdapter为RecyclerView的适配器
    继承RecyclerView.Adapter  将泛型指定为FruitAdapter.ViewHolder
     */
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        //fruitViewl变量来保存子项最外层布局实例
        View fruitView;
        //内部类ViewHolder继承RecyclerView.ViewHolder
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view){
            super(view);    //构造函数传参（参数为RecyclerView子项的最外层布局）
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
            //获取布局中ImageView，TextView的实例
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //将fruit_item布局加载进来 然后创建ViewHolder实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                //两事件现货去了用户点击的position
                Fruit fruit = mFruitList.get(position);
                //通过position获得想用Fruit实例
                Toast.makeText(v.getContext(), "you clicked view"+fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image"+fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        //ViewHolder holder = new ViewHolder(view);//将加载好的布局传到构造函数中
        return holder;//返回实例
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        //对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行
        Fruit fruit = mFruitList.get(position);//通过position得到当前项的Fruit实例
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        //将数据设置到ViewHolder中ImageView，TextView中
    }

    public int getItemCount(){
        return mFruitList.size();
        //用于告诉RecycylerView一共有多少子项，返回的为数据长度
    }
}
