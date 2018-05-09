package com.example.mcroft.myapplication;

import android.graphics.Color;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Asus on 28.09.2017.
 */

public class Takimadapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Lig> takimArrayList;

    public Takimadapter(Activity activity, ArrayList<Lig> takimArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.takimArrayList = takimArrayList;
    }

    @Override
    public int getCount() {
        return takimArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return takimArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.satir_layout, null);
        TextView isim = (TextView) convertView.findViewById(R.id.isim);
        TextView galibiyet = (TextView) convertView.findViewById(R.id.galibiyet);
        TextView beraberlik = (TextView) convertView.findViewById(R.id.beraberlik);
        TextView maglubiyet = (TextView) convertView.findViewById(R.id.maglubiyet);
        TextView puan = (TextView) convertView.findViewById(R.id.puan);
        Lig gol = takimArrayList.get(position);
        isim.setText(gol.getIsim());
        galibiyet.setText(gol.isGalibiyet());
        beraberlik.setText(gol.isBeraberlik());
        maglubiyet.setText(gol.isMaglubiyet());
        puan.setText(gol.isPuan());
        return convertView;
    }
}

