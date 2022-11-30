package com.ldt.btk3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class chitiecsach extends AppCompatActivity {
    sach nn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiecsach);
        nn = new sach();
        nn = (sach) getIntent().getSerializableExtra("NgonNgu");
    }
}