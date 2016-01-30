package com.hankkin.multipurposelistview;

import java.io.Serializable;

/**
 * Created by Hankkin on 16/1/30.
 */
public class Item implements Serializable{
    private String title;
    private int resId;

    public Item(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
