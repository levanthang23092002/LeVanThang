package com.ldt.btk3;

import java.io.Serializable;

public class NgonNgu implements Serializable {
    private String tenNN, vidu;
    private int image;

    public NgonNgu() {
    }

    public NgonNgu(String tenNN, String vidu, int image) {
        this.tenNN = tenNN;
        this.vidu = vidu;
        this.image = image;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getVidu() {
        return vidu;
    }

    public void setVidu(String vidu) {
        this.vidu = vidu;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
