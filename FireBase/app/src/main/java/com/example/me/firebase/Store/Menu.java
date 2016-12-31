package com.example.me.firebase.Store;

import java.io.Serializable;

/**
 * Created by Me on 9/28/2016.
 */

public class Menu implements Serializable{
    //thong+tien
    String linkhinh,tenmon;
    String gia;

    public Menu() {

    }

    public Menu(String linkhinh, String tenmon, String gia) {
        this.linkhinh = linkhinh;
        this.tenmon = tenmon;
        this.gia = gia;
    }

    public String getLinkhinh() {
        return linkhinh;
    }

    public void setLinkhinh(String linkhinh) {
        this.linkhinh = linkhinh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
