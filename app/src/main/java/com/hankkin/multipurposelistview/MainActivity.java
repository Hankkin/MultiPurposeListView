package com.hankkin.multipurposelistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.hankkin.multipurposelistview.refreshlayout.RefreshLayout;
import com.hankkin.multipurposelistview.swipeview.ISwipeMenuCreator;
import com.hankkin.multipurposelistview.swipeview.SwipeMenu;
import com.hankkin.multipurposelistview.swipeview.SwipeMenuItem;
import com.hankkin.multipurposelistview.swipeview.SwipeMenuListView;
import com.hankkin.multipurposelistview.util.HankkinUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, RefreshLayout.OnLoadListener {

    private RefreshLayout refreshLayout;
    private List<Item> data = new ArrayList<>();
    private MyAdapter adapter;
    private SwipeMenuListView menuListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData(){
        for (int i=0;i<20;i++){
            Item item = new Item("item"+i,R.drawable.hankkin);
            data.add(item);
        }
    }

    private void initView() {
        refreshLayout = (RefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //设置卷内的颜色
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        refreshLayout.setOnLoadListener(this);
        refreshLayout.setOnRefreshListener(this);
        menuListView = (SwipeMenuListView) findViewById(R.id.swipe);
        refreshLayout.setChildView(menuListView);
        adapter = new MyAdapter(MainActivity.this, data);
        menuListView.setAdapter(adapter);

        ISwipeMenuCreator creator = new ISwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // 创建滑动选项
                SwipeMenuItem showItem = new SwipeMenuItem(
                        getApplicationContext());
                // 设置选项背景
                showItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // 设置选项宽度
                showItem.setWidth(HankkinUtil.dp2px(90,MainActivity.this));
                // 设置选项标题
                showItem.setTitle("Show");
                // 设置选项标题
                showItem.setTitleSize(18);
                // 设置选项标题颜色
                showItem.setTitleColor(Color.WHITE);
                // 添加选项
                menu.addMenuItem(showItem);

                // 创建删除选项
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                deleteItem.setWidth(HankkinUtil.dp2px(90, MainActivity.this));
                deleteItem.setIcon(R.drawable.ic_delete);
                menu.addMenuItem(deleteItem);
            }
        };

        menuListView.setMenuCreator(creator);

        menuListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0: //第一个选项
                        HankkinUtil.showToast(MainActivity.this, data.get(position).getTitle());
                        break;
                    case 1: //第二个选项
                        data.remove(position);
                        adapter.notifyDataSetChanged();
                        break;

                }
            }
        });


    }

    @Override
    public void onLoad() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
                adapter.notifyDataSetChanged();
                refreshLayout.setLoading(false);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                data.clear();
                initData();
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        }, 1000);
    }
}
