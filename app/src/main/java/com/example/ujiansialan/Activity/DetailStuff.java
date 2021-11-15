package com.example.ujiansialan.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ujiansialan.R;

public class DetailStuff extends AppCompatActivity {

    TextView tl, des, prc;
    String tls, imgs, dess, prcs;
    ImageView img;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_stuff);

        tls = getIntent().getStringExtra("t_st");
        prcs = getIntent().getStringExtra("pr_st");
        imgs = getIntent().getStringExtra("img_st");



    }
}
