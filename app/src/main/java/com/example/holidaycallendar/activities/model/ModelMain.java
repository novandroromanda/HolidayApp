package com.example.holidaycallendar.activities.model;

import java.io.Serializable;


public class ModelMain implements Serializable {

    String strTanggal;
    String strKeterangan;
    String strCuti;

    public String getStrTanggal() {
        return strTanggal;
    }

    public void setStrTanggal(String strTanggal) {
        this.strTanggal = strTanggal;
    }

    public String getStrKeterangan() {
        return strKeterangan;
    }

    public void setStrKeterangan(String strKeterangan) {
        this.strKeterangan = strKeterangan;
    }

    public String getStrCuti() {
        return strCuti;
    }

    public void setStrCuti(String strCuti) {
        this.strCuti = strCuti;
    }
}