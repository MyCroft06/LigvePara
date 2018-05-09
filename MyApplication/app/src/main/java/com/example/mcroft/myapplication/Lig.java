package com.example.mcroft.myapplication;

/**
 * Created by Asus on 28.09.2017.
 */

public class Lig {

    private String  isim;
    private String  galibiyet,beraberlik,maglubiyet;
    private String  puan;

    public Lig(String isim, String galibiyet,String beraberlik,String maglubiyet, String puan) {
        super();
        this.isim = isim;
        this.galibiyet = galibiyet;
        this.beraberlik = beraberlik;
        this.maglubiyet = maglubiyet;
        this.puan = puan;
    }

    @Override
    public String toString() {
        return isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }


    public String isGalibiyet() {
        return galibiyet;
    }

    public void setGalibiyet(String galibiyet) {
        this.galibiyet = galibiyet;
    }


    public String isBeraberlik() {
        return beraberlik;
    }

    public void setBeraberlik(String beraberlik) {
        this.beraberlik = beraberlik;
    }


    public String isMaglubiyet() {
        return maglubiyet;
    }

    public void setMaglubiyet(String maglubiyet) {
        this.maglubiyet = maglubiyet;
    }


    public String isPuan() {
        return puan;
    }

    public void setPuan(String puan) {
        this.puan = puan;
    }



}
