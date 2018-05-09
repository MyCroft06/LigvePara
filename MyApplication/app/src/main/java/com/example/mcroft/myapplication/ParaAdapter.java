package com.example.mcroft.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParaAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Para> mPara;

    public ParaAdapter(Activity activity, ArrayList<Para> liste) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mPara = liste;
    }

    @Override
    public int getCount() {
        return mPara.size();
    }

    @Override
    public Object getItem(int position) {
        return mPara.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        convertView = mInflater.inflate(R.layout.card_item, null);
        TextView isim = (TextView) convertView.findViewById(R.id.doviz);
        TextView zaman = (TextView) convertView.findViewById(R.id.zaman);
        TextView saattxt = (TextView) convertView.findViewById(R.id.saattxt);

        Date saat = new Date();
        SimpleDateFormat gün = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dakika = new SimpleDateFormat("HH:mm");;
        zaman.setText(gün.format(saat));
        saattxt.setText(dakika.format(saat));
        Para para = mPara.get(position);
        isim.setText(para.getIsim());

        return convertView;
    }
}
