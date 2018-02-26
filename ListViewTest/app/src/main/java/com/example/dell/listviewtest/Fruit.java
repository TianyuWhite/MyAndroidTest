package com.example.dell.listviewtest;

/**
 * Created by dell on 2018/2/26.
 */

public class Fruit {
    private String name;//水果名
    private int imageId;//水果对应图片的资源id
    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
