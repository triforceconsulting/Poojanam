package com.triforce.namami;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pooja_Detail extends AppCompatActivity {

    TextView pageTitle,txtAbout,txtDuration,txtTithi,txtBenefits;
    TextView txtTitleAbout, txtTitleTithi, txtTitleDuration , txtTitleBenifits;
    String puja;
    ImageView back;
    ImageView imgtithi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pooja__detail);

        pageTitle = (TextView) findViewById(R.id.txtTitlePoojaDetail);
        txtAbout = (TextView) findViewById(R.id.txtPoojaDetailAbout);
        txtDuration = (TextView) findViewById(R.id.txtPoojaDetailDuration);
        txtTithi = (TextView) findViewById(R.id.txtPoojaDetailTithi);
        txtBenefits = (TextView) findViewById(R.id.txtPoojaDetailBenefits);
        back = (ImageView) findViewById(R.id.imgPoojaDetailBack);
        imgtithi = (ImageView)findViewById(R.id.imgcalender);

        txtTitleAbout = (TextView)findViewById(R.id.txt_Title_detail_about);
        txtTitleTithi = (TextView)findViewById(R.id.txt_Title_detail_tithi);
        txtTitleDuration = (TextView)findViewById(R.id.txt_Title_detail_duration);
        txtTitleBenifits = (TextView)findViewById(R.id.txt_Title_detail_benifits);


        Intent i = getIntent();
        puja = i.getStringExtra("puja");

        if(puja.equals("ganeshpuja")) {
            pageTitle.setText("Ganesh Chaturthi");
            txtTitleAbout.setText(getResources().getString(R.string.str_pooja_detail_about_title_ganesh));
            txtAbout.setText(getResources().getString(R.string.str_pooja_about_ganesh));

            txtTitleTithi.setText(getResources().getString(R.string.str_pooja_detail_tithi_title_ganesh));
            txtTithi.setText(getResources().getString(R.string.str_pooja_tithi_ganesh));

            txtTitleDuration.setText(getResources().getString(R.string.str_pooja_detail_Duration_title_ganesh));
            txtDuration.setText(getResources().getString(R.string.str_pooja_duration_ganesh));

            txtTitleBenifits.setText(getResources().getString(R.string.str_pooja_detail_benifits_title_ganesh));
            txtBenefits.setText(getResources().getString(R.string.str_pooja_benefits_ganesh));

        }
        else if(puja.equals("manglagauripuja")){
            pageTitle.setText("ManglaGauri");
            txtTitleAbout.setText(getResources().getString(R.string.str_pooja_detail_about_title_mangla));
            txtAbout.setText(getResources().getString(R.string.str_pooja_about_mangal));

            txtTitleTithi.setText(getResources().getString(R.string.str_pooja_detail_tithi_title_mangla));
            txtTithi.setText(getResources().getString(R.string.str_pooja_tithi_mangla));

            txtTitleDuration.setText(getResources().getString(R.string.str_pooja_detail_Duration_title_mangla));
            txtDuration.setText(getResources().getString(R.string.str_pooja_duration_mangla));

            txtTitleBenifits.setText(getResources().getString(R.string.str_pooja_detail_benifits_title_mangla));
            txtBenefits.setText(getResources().getString(R.string.str_pooja_benefits_mangal));
        }
        else if(puja.equals("satyanarayanpuja")) {
            txtTithi.setVisibility(View.GONE);
            txtTitleTithi.setVisibility(View.GONE);
            imgtithi.setVisibility(View.GONE);
            pageTitle.setText("SatyaNarayan");
            txtTitleAbout.setText(getResources().getString(R.string.str_pooja_detail_about_title_satyanarayan));
            txtAbout.setText(getResources().getString(R.string.str_pooja_about_satyanarayan));

           /* txtTitleTithi.setText(getResources().getString(R.string.str_pooja_detail_tithi_title_mangla));
            txtTithi.setText(getResources().getString(R.string.str_pooja_tithi_mangla));*/

            txtTitleDuration.setText(getResources().getString(R.string.str_pooja_detail_Duration_title_satyanarayan));
            txtDuration.setText(getResources().getString(R.string.str_pooja_duration_satyanarayan));

            txtTitleBenifits.setText(getResources().getString(R.string.str_pooja_detail_benifits_title_satyanarayan));
            txtBenefits.setText(getResources().getString(R.string.str_pooja_benefits_satyanarayan));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pooja_Detail.this.finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Pooja_Detail.this.finish();
    }
}
