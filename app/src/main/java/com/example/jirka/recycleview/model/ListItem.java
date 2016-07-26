package com.example.jirka.recycleview.model;
/**
 * Java Representation of our Data. To be displayed in RecyclerView
 * Created by Jirka on 26.7.2016.
 */

public class ListItem {
    private String title;
    private int imageResID;

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public int getImageResID() {return imageResID;}
    public void setImageResID(int imageResID) {this.imageResID = imageResID;}

}

