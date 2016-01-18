package com.example.joo.samplemultitypelistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Joo on 2016-01-14.
 */
public class ChattingAdapter extends BaseAdapter {
    private static  final int VIEW_TYPE_COUNT = 3;
    private static  final int TYPE_RECEIVE = 0;
    private static  final int TYPE_SEND = 1;
    private static  final int TYPE_DATE = 2;

    public  void add(ChattingData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    public void clearMsg() {
        items.clear();
        notifyDataSetChanged();
    }

    ArrayList<ChattingData> items = new ArrayList<ChattingData>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_RECEIVE : {
                ReceiveView view;
                if (convertView != null && convertView instanceof ReceiveView) {
                    view = (ReceiveView) convertView;
                } else {
                    view = new ReceiveView(parent.getContext());
                }
                view.setData((ReceiveData) items.get(position));
                return view;
            }
            case TYPE_SEND : {
                SendView view;
                if (convertView != null && convertView instanceof SendView) {
                    view = (SendView) convertView;
                } else {
                    view = new SendView(parent.getContext());
                }
                view.setData((SendData) items.get(position));
                return view;
            }

            default: TYPE_DATE : {
                DateView view;
                if (convertView != null && convertView instanceof DateView) {
                    view = (DateView) convertView;
                } else {
                    view = new DateView(parent.getContext());
                }
                view.setData((DateData) items.get(position));
                return view;
            }
        }
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);

        if (data instanceof ReceiveData) {
            return TYPE_RECEIVE;
        } else if (data instanceof SendData) {
            return TYPE_SEND;
        } else {
            return TYPE_DATE;
        }
    }
}
