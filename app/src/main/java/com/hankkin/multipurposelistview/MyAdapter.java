package com.hankkin.multipurposelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hankkin on 16/1/30.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Item> data;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Item> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoloder holoder = null;
        if (convertView==null){
            holoder = new ViewHoloder();
            convertView = inflater.inflate(R.layout.item,null);
            holoder.tv = (TextView) convertView.findViewById(R.id.tv);
            holoder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holoder);
        }
        else {
            holoder = (ViewHoloder) convertView.getTag();
        }
        Item item = data.get(position);
        holoder.tv.setText(item.getTitle());
        holoder.iv.setImageResource(item.getResId());
        return convertView;
    }

    class ViewHoloder{
        TextView tv;
        ImageView iv;
    }
}
