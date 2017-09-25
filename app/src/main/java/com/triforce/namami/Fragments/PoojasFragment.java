package com.triforce.namami.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.triforce.namami.PoojaInformation;
import com.triforce.namami.Pooja_Detail;
import com.triforce.namami.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PoojasFragment extends Fragment {

    LinearLayout Lin_ganesh, Lin_manglagauri, Lin_Satyanaraya;
    ImageView img_ganesh,img_mangal,img_satyanarayan;

    public PoojasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_poojas, container, false);

        Lin_ganesh = (LinearLayout) view.findViewById(R.id.Lin_ganesh);
        /*Lin_anantpoja = (LinearLayout) view.findViewById(R.id.Lin_anantpuja);
        Lin_grahpravesh = (LinearLayout) view.findViewById(R.id.Lin_grah_pravesh);
        Lin_gauripuja = (LinearLayout) view.findViewById(R.id.Lin_gauripuja);*/
        Lin_manglagauri = (LinearLayout) view.findViewById(R.id.Lin_manglaGauri);
        Lin_Satyanaraya = (LinearLayout) view.findViewById(R.id.Lin_Satyanaraya);
        img_ganesh = (ImageView) view.findViewById(R.id.detailicon_ganesh);
        img_mangal = (ImageView) view.findViewById(R.id.detailicon_manglaGauri);
        img_satyanarayan = (ImageView) view.findViewById(R.id.detailicon_Satyanaraya);

        img_ganesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Pooja_Detail.class);
                //i.putExtra("ganeshpuja","puja");
                i.putExtra("puja","ganeshpuja");
                getActivity().startActivity(i);
            }
        });

        img_satyanarayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Pooja_Detail.class);
                //i.putExtra("ganeshpuja","puja");
                i.putExtra("puja","satyanarayanpuja");
                getActivity().startActivity(i);
            }
        });

        img_mangal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Pooja_Detail.class);
                //i.putExtra("ganeshpuja","puja");
                i.putExtra("puja","manglagauripuja");
                getActivity().startActivity(i);
            }
        });

        Lin_ganesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),PoojaInformation.class);
                //i.putExtra("ganeshpuja","puja");
                i.putExtra("puja","ganeshpuja");
                getActivity().startActivity(i);
              //  getActivity().setTitle("Ganesh Chaturthi");
            }
        });

        Lin_manglagauri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),PoojaInformation.class);
              //  i.putExtra("manglagauripuja","puja");
                i.putExtra("puja","manglagauripuja");
                 getActivity().startActivity(i);
             //   getActivity().setTitle("ManglaGauri");
            }
        });

        Lin_Satyanaraya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),PoojaInformation.class);
               // i.putExtra("satyanarayanpuja","puja");
                i.putExtra("puja","satyanarayanpuja");
                getActivity().startActivity(i);
               // getActivity().setTitle("Satyanarayan");
            }
        });

        return view;
    }

}
