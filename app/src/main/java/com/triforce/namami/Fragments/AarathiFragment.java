package com.triforce.namami.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.triforce.namami.Aarati_Detail;
import com.triforce.namami.R;

public class AarathiFragment extends Fragment {

    LinearLayout lin_ganesh,lin_datta,lin_durga_devi,lin_mangala,lin_satya,lin_shankar,lin_maruti,lin_shriram,lin_vitthal;

    public AarathiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_aarathi, container, false);

        lin_ganesh = (LinearLayout) view.findViewById(R.id.LinAaratiGanesh);
        lin_datta = (LinearLayout) view.findViewById(R.id.LinAaratidatta);
        lin_durga_devi = (LinearLayout) view.findViewById(R.id.LinAaratiDurga);
        lin_mangala = (LinearLayout) view.findViewById(R.id.LinAaratiMangal);
        lin_satya = (LinearLayout) view.findViewById(R.id.LinAaratiSatya);
        lin_shankar = (LinearLayout) view.findViewById(R.id.LinAaratiShankar);
        lin_maruti = (LinearLayout) view.findViewById(R.id.LinAaratiMaruti);
        lin_shriram = (LinearLayout) view.findViewById(R.id.LinAaratiRam);
        lin_vitthal = (LinearLayout) view.findViewById(R.id.LinAaratiVitthal);

        lin_ganesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","ganesh");
                getActivity().startActivity(i);
            }
        });

        lin_datta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","datta");
                getActivity().startActivity(i);
            }
        });

        lin_durga_devi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","durga");
                getActivity().startActivity(i);
            }
        });

        lin_mangala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","mangala");
                getActivity().startActivity(i);
            }
        });

        lin_satya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","satya");
                getActivity().startActivity(i);
            }
        });

        lin_shankar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","shankar");
                getActivity().startActivity(i);
            }
        });

        lin_maruti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","maruti");
                getActivity().startActivity(i);
            }
        });

        lin_shriram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","shriram");
                getActivity().startActivity(i);
            }
        });

        lin_vitthal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aarati_Detail.class);
                i.putExtra("aarati","vitthal");
                getActivity().startActivity(i);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
