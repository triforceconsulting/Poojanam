package com.triforce.namami;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Aarati_Detail extends AppCompatActivity {

    ImageView img_back;
    TextView txt_title,txt_lyrics;
    String aarati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aarati_detail);

        img_back = (ImageView) findViewById(R.id.imgAaratiDetailBack);
        txt_title = (TextView) findViewById(R.id.txtTitleAaratiDetail);
        txt_lyrics = (TextView) findViewById(R.id.txtAaratiDetailLyrics);

        Intent i = getIntent();
        aarati = i.getStringExtra("aarati");

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aarati_Detail.this.finish();
            }
        });

        if(aarati.equals("ganesh")) {
            txt_title.setText("Ganesh Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_ganesh_lyrics));
        } else if(aarati.equals("datta")) {
            txt_title.setText("Datta Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_datta_lyrics));
        } else if(aarati.equals("durga")) {
            txt_title.setText("Durga Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_durga_lyrics));
        } else if(aarati.equals("mangala")) {
            txt_title.setText("ManglaGauri Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_mangal_lyrics));
        } else if(aarati.equals("satya")) {
            txt_title.setText("Satyanarayan Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_satya_lyrics));
        } else if(aarati.equals("shankar")) {
            txt_title.setText("Shankar Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_shankar_lyrics));
        } else if(aarati.equals("maruti")) {
            txt_title.setText("Maruti Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_maruti_lyrics));
        } else if(aarati.equals("shriram")) {
            txt_title.setText("Shriram Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_shriram_lyrics));
        } else if(aarati.equals("vitthal")) {
            txt_title.setText("Vitthal Aarathi");
            txt_lyrics.setText(getResources().getString(R.string.str_aarati_vitthal_lyrics));
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Aarati_Detail.this.finish();
    }
}
