package com.hankkin.multipurposelistview.swipeview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hankkin on 16/1/30.
 */
public class SwipeMenu {
    private Context mContext;   //上下文
    private List<SwipeMenuItem> mItems; //数据源
    private int mViewType;  //显示类型

    public SwipeMenu(Context context) {
        mContext = context;
        mItems = new ArrayList<SwipeMenuItem>();
    }

    public Context getContext() {
        return mContext;
    }

    public void addMenuItem(SwipeMenuItem item) {
        mItems.add(item);
    }

    public void removeMenuItem(SwipeMenuItem item) {
        mItems.remove(item);
    }

    public List<SwipeMenuItem> getMenuItems() {
        return mItems;
    }

    public SwipeMenuItem getMenuItem(int index) {
        return mItems.get(index);
    }

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(int viewType) {
        this.mViewType = viewType;
    }
}
