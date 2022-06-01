package com.example.sqllistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context c;
    LayoutInflater inflater;
    List<ArrayList> mydata;

    public CustomAdapter(Context c, List mydata) {
        this.c = c;
        this.mydata = mydata;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return mydata.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.element, null);
        TextView data = (TextView) view.findViewById(R.id.tv1);
        data.setText(String.valueOf(mydata.get(i)));
        return view;
    }

}
