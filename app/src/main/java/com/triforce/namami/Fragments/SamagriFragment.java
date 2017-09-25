package com.triforce.namami.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triforce.namami.PoojaInformation;
import com.triforce.namami.R;


public class SamagriFragment extends Fragment {
    String puja;

    TextView txtTitleSamagri1,txtDetailSamagri1,txtTitleSamagri2,txtDetailSamagri2;


    public SamagriFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_samagri, container, false);
        puja = PoojaInformation.puja;

        txtTitleSamagri1 = (TextView)view.findViewById(R.id.txtTitleSamagri1);
        txtDetailSamagri1= (TextView)view.findViewById(R.id.txtDetailSamagri1);
        txtTitleSamagri2 = (TextView)view.findViewById(R.id.txtTitleSamagri2);
        txtDetailSamagri2 = (TextView)view.findViewById(R.id.txtDetailSamagri2);

        if(puja.equals("ganeshpuja")) {
            txtTitleSamagri1.setText(R.string.str_Title1_Samagri_ganesh);
            txtDetailSamagri1.setText(R.string.str_Detail1_Samagri_ganesh);
            txtTitleSamagri2.setText(R.string.str_Title2_Samagri_ganesh);
            txtDetailSamagri2.setText(R.string.str_Detail2_Samagri_ganesh);
        }
        else if(puja.equals("manglagauripuja")){
            txtTitleSamagri1.setText(R.string.str_Title1_Samagri_manglagauri);
            txtDetailSamagri1.setText(R.string.str_Detail1_Samagri_manglagauri);
            txtTitleSamagri2.setText(R.string.str_Title2_Samagri_manglagauri);
            txtDetailSamagri2.setText(R.string.str_Detail2_Samagri_manglagauri);

        }
        else if(puja.equals("satyanarayanpuja")) {
            txtTitleSamagri1.setText(R.string.str_Title1_Samagri_satyanarayan);
            txtDetailSamagri1.setText(R.string.str_Detail1_Samagri_satyanarayan);
            txtTitleSamagri2.setText(R.string.str_Title2_Samagri_satyanarayan);
            txtDetailSamagri2.setText(R.string.str_Detail2_Samagri_satyanarayan);

        }

        PoojaInformation.imgsharePoojaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
               /* String stringToSent = txtTitleSamagri1.getText().toString()+";"+ txtDetailSamagri1.getText().toString()+
                        ";"+txtTitleSamagri2.getText().toString()+";"+txtDetailSamagri2.getText().toString();*/
                share.putExtra(Intent.EXTRA_SUBJECT, "Samagri Details:");
                share.putExtra(Intent.EXTRA_TEXT,
                        Html.fromHtml(new StringBuilder()
                                .append("<html>")
                                .append(txtTitleSamagri1.getText().toString())
                                .append("<br/>")
                                .append(txtDetailSamagri1.getText().toString())
                                .append("<br/>")
                                .append(txtTitleSamagri2.getText().toString())
                                .append("<br/>")
                                .append(txtDetailSamagri2.getText().toString())
                                .append("<br/></html>").toString()
                        ));




              //  share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);


               /* share.putExtra(Intent.EXTRA_TEXT, txtDetailSamagri1.getText().toString());
                share.putExtra(Intent.EXTRA_TEXT, txtTitleSamagri2.getText().toString());
                share.putExtra(Intent.EXTRA_TEXT, txtDetailSamagri2.getText().toString());*/
                startActivity(Intent.createChooser(share, "Share via"));
            }
        });


        return view;

    }

}
