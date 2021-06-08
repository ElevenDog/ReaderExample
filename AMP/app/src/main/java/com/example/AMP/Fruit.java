package com.example.AMP;

public class Fruit {

    private String name;
    private int imageId;

    public String getLastNew() {
        return lastNew;
    }

    public String getTime() {
        return time;
    }

    private String lastNew;
    private String time;

    public Fruit(String name, int imageId,String lastNew,String time){
        this.name = name;
        this.imageId = imageId;
        this.lastNew = lastNew;
        this.time = time;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}