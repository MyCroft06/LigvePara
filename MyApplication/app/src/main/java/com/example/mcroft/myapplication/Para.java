package com.example.mcroft.myapplication;

/**
 * Created by mcroft on 29.12.2017.
 */

class Para {

    private String  isim;

    public Para(String isim) {
        super();
        this.isim = isim;
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

}