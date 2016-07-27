package com.example.jirka.recycleview.model;

/**
 * Java Representation of our Data. To be displayed in RecyclerView
 * Created by Jirka on 26.7.2016.
 */

public class ListItem {
    private String title;
    private String subtitle;
    private int imageResID;
    private boolean favourite = false;

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    // getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResID() {
        return imageResID;
    }

    public void setImageResID(int imageResID) {
        this.imageResID = imageResID;
    }

}

