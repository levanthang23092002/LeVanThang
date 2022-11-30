package com.ldt.btk3;

public class sach {
    private String sach,mota;
    private int anh;

    public sach(String sach, String mota, int anh) {
        this.sach = sach;
        this.mota = mota;
        this.anh = anh;
    }

    public sach() {
    }

    public String getSach() {
        return sach;
    }

    public void setSach(String sach) {
        this.sach = sach;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
