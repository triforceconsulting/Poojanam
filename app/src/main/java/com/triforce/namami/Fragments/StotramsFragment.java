package com.triforce.namami.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.triforce.namami.Dashboard;
import com.triforce.namami.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class StotramsFragment extends Fragment {

    LinearLayout lin_dattatreya,lin_ganpati_atharv,lin_ganpati_sukta,
            lin_mahalakshmi, lin_maruti,lin_navgraha,lin_purusha,
            lin_ramaraksha,lin_rudra,lin_sankatnashan_ganesh,lin_shani,
            lin_shri,lin_sour;
    ImageView img_dattatreya,img_ganpati_atharv,img_ganpati_sukta,
            img_mahalakshmi,img_maruti,img_navgraha,img_purusha,
            img_ramaraksha,img_rudra,img_sankatnashan_ganesh,img_shani,
            img_shri,img_sour;
    TextView txt_dattatreya,txt_ganpati_atharv,txt_ganpati_sukta,
            txt_mahalakshmi,txt_maruti,txt_navgraha,txt_purusha,
            txt_ramaraksha,txt_rudra,txt_sankatnashan_ganesh,txt_shani,
            txt_shri,txt_sour;
    TextView play_name,play_time;
    ImageButton img_pause,img_previous,img_next;
    SeekBar seekBar;
    int pos = 0;
    LinearLayout lin_play;
    ScrollView scroll;
    MediaPlayer m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13;
    static int count;

    public StotramsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_stotrams, container, false);

        lin_dattatreya = (LinearLayout) view.findViewById(R.id.stotram_dattatreya);
        lin_ganpati_atharv = (LinearLayout) view.findViewById(R.id.stotram_ganpati_atharv);
        lin_ganpati_sukta = (LinearLayout) view.findViewById(R.id.stotram_ganpati_sukta);
        lin_mahalakshmi = (LinearLayout) view.findViewById(R.id.stotram_mahalakshmi);
        lin_maruti = (LinearLayout) view.findViewById(R.id.stotram_maruti);
        lin_navgraha = (LinearLayout) view.findViewById(R.id.stotram_navgraha);
        lin_purusha = (LinearLayout) view.findViewById(R.id.stotram_purusha);
        lin_ramaraksha = (LinearLayout) view.findViewById(R.id.stotram_ramaraksha);
        lin_rudra = (LinearLayout) view.findViewById(R.id.stotram_rudra);
        lin_sankatnashan_ganesh = (LinearLayout) view.findViewById(R.id.stotram_sankatnashan_ganesh);
        lin_shani = (LinearLayout) view.findViewById(R.id.stotram_shani);
        lin_shri = (LinearLayout) view.findViewById(R.id.stotram_shri);
        lin_sour = (LinearLayout) view.findViewById(R.id.stotram_sour);

        lin_play = (LinearLayout) view.findViewById(R.id.lin_stotram_play);
        scroll = (ScrollView) view.findViewById(R.id.scroll_stotram);

        img_dattatreya = (ImageView) view.findViewById(R.id.img_pause_dattatreya);
        img_ganpati_atharv = (ImageView) view.findViewById(R.id.img_pause_ganpati_atharav);
        img_ganpati_sukta = (ImageView) view.findViewById(R.id.img_pause_ganpati_sukta);
        img_mahalakshmi = (ImageView) view.findViewById(R.id.img_pause_mahalakshmi);
        img_maruti = (ImageView) view.findViewById(R.id.img_pause_maruti);
        img_navgraha = (ImageView) view.findViewById(R.id.img_pause_navgraha);
        img_purusha = (ImageView) view.findViewById(R.id.img_pause_purusha);
        img_ramaraksha = (ImageView) view.findViewById(R.id.img_pause_ramaraksha);
        img_rudra = (ImageView) view.findViewById(R.id.img_pause_rudra);
        img_sankatnashan_ganesh = (ImageView) view.findViewById(R.id.img_pause_sankatnashan_ganesh);
        img_shani = (ImageView) view.findViewById(R.id.img_pause_shani);
        img_shri = (ImageView) view.findViewById(R.id.img_pause_shri);
        img_sour = (ImageView) view.findViewById(R.id.img_pause_sour);

        txt_dattatreya = (TextView) view.findViewById(R.id.txt_stotram_dattatreya_min);
        txt_ganpati_atharv = (TextView) view.findViewById(R.id.txt_stotram_ganpati_atharv_min);
        txt_ganpati_sukta = (TextView) view.findViewById(R.id.txt_stotram_ganpati_sukta_min);
        txt_mahalakshmi = (TextView) view.findViewById(R.id.txt_stotram_mahalakshmi_min);
        txt_maruti = (TextView) view.findViewById(R.id.txt_stotram_maruti_min);
        txt_navgraha = (TextView) view.findViewById(R.id.txt_stotram_navgraha_min);
        txt_purusha = (TextView) view.findViewById(R.id.txt_stotram_purusha_min);
        txt_ramaraksha = (TextView) view.findViewById(R.id.txt_stotram_ramaraksha_min);
        txt_rudra = (TextView) view.findViewById(R.id.txt_stotram_rudra_min);
        txt_sankatnashan_ganesh = (TextView) view.findViewById(R.id.txt_stotram_sankatnashan_ganesh_min);
        txt_shani = (TextView) view.findViewById(R.id.txt_stotram_shani_min);
        txt_shri = (TextView) view.findViewById(R.id.txt_stotram_shri_min);
        txt_sour = (TextView) view.findViewById(R.id.txt_stotram_sour_min);

        img_pause = (ImageButton) view.findViewById(R.id.img_stotram_pause);
        img_previous = (ImageButton) view.findViewById(R.id.img_stotram_previous);
        img_next = (ImageButton) view.findViewById(R.id.img_stotram_next);

        play_name = (TextView) view.findViewById(R.id.txt_stotram_play);
        play_time = (TextView) view.findViewById(R.id.txt_stotram_play_time);

        seekBar = (SeekBar) view.findViewById(R.id.seekbar_stotram);

        m1 = MediaPlayer.create(getActivity(),R.raw.dattatreya_kashta_nashak_stotram);
        m2 = MediaPlayer.create(getActivity(),R.raw.ganpati_athravshisha_stotram);
        m3 = MediaPlayer.create(getActivity(),R.raw.ganpati_sukta_stotram);
        m4 = MediaPlayer.create(getActivity(),R.raw.mahalakshmi_ashtakam_stotram);
        m5 = MediaPlayer.create(getActivity(),R.raw.maruti_stotram);
        m6 = MediaPlayer.create(getActivity(),R.raw.navgraha_stotram);
        m7 = MediaPlayer.create(getActivity(),R.raw.purusha_sukta_stotram);
        m8 = MediaPlayer.create(getActivity(),R.raw.ramaraksha_stotram);
        m9 = MediaPlayer.create(getActivity(),R.raw.rudra_adhyay_stotram);
        m10 = MediaPlayer.create(getActivity(),R.raw.sankatnashan_ganesh_stotram);
        m11 = MediaPlayer.create(getActivity(),R.raw.shani_stotram);
        m12 = MediaPlayer.create(getActivity(),R.raw.shri_stotram);
        m13 = MediaPlayer.create(getActivity(),R.raw.sour_stotram);

        txt_dattatreya.setText(milliSecondsToTimer(m1.getDuration())+" min");
        txt_ganpati_atharv.setText(milliSecondsToTimer(m2.getDuration())+" min");
        txt_ganpati_sukta.setText(milliSecondsToTimer(m3.getDuration())+" min");
        txt_mahalakshmi.setText(milliSecondsToTimer(m4.getDuration())+" min");
        txt_maruti.setText(milliSecondsToTimer(m5.getDuration())+" min");
        txt_navgraha.setText(milliSecondsToTimer(m6.getDuration())+" min");
        txt_purusha.setText(milliSecondsToTimer(m7.getDuration())+" min");
        txt_ramaraksha.setText(milliSecondsToTimer(m8.getDuration())+" min");
        txt_rudra.setText(milliSecondsToTimer(m9.getDuration())+" min");
        txt_sankatnashan_ganesh.setText(milliSecondsToTimer(m10.getDuration())+" min");
        txt_shani.setText(milliSecondsToTimer(m11.getDuration())+" min");
        txt_shri.setText(milliSecondsToTimer(m12.getDuration())+" min");
        txt_sour.setText(milliSecondsToTimer(m13.getDuration()) + " min");

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_dattatreya))) {
                    lin_ganpati_atharv.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_ganpati_athravshisha))) {
                    lin_ganpati_sukta.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_ganpati_sukta))) {
                    lin_mahalakshmi.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_mahalakshmi_ashtakam))) {
                    lin_maruti.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_maruti))) {
                    lin_navgraha.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_navgraha))) {
                    lin_purusha.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_purusha_sukta))) {
                    lin_ramaraksha.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_ramaraksha))) {
                    lin_rudra.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_rudra_adhyay))) {
                    lin_sankatnashan_ganesh.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_sankatnashan_ganesh))) {
                    lin_shani.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_shani))) {
                    lin_shri.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_shri))) {
                    lin_sour.performClick();
                }

            }
        });

        img_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_ganpati_athravshisha))) {
                    lin_dattatreya.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_ganpati_sukta))) {
                    lin_ganpati_atharv.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_mahalakshmi_ashtakam))) {
                    lin_ganpati_sukta.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_maruti))) {
                    lin_mahalakshmi.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_navgraha))) {
                    lin_maruti.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_purusha_sukta))) {
                    lin_navgraha.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_ramaraksha))) {
                    lin_purusha.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_rudra_adhyay))) {
                    lin_ramaraksha.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_sankatnashan_ganesh))) {
                    lin_rudra.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_shani))) {
                    lin_sankatnashan_ganesh.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_shri))) {
                    lin_shani.performClick();
                } else if (play_name.getText().toString().equals(getResources().getString(R.string.str_stotram_sour))) {
                    lin_shri.performClick();
                }

            }
        });

        lin_dattatreya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.INVISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.VISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.dattatreya_kashta_nashak_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_dattatreya));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_dattatreya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_ganpati_atharv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.VISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.ganpati_athravshisha_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_ganpati_athravshisha));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_ganpati_atharv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_ganpati_sukta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.VISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.ganpati_sukta_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_ganpati_sukta));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_ganpati_sukta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_mahalakshmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.VISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.mahalakshmi_ashtakam_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_mahalakshmi_ashtakam));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_mahalakshmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_maruti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.VISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.maruti_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_maruti));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_maruti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_navgraha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.VISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.navgraha_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_navgraha));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_navgraha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_purusha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.VISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.purusha_sukta_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_purusha_sukta));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_purusha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_ramaraksha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.VISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.ramaraksha_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_ramaraksha));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_ramaraksha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_rudra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.VISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.rudra_adhyay_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_rudra_adhyay));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_rudra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_sankatnashan_ganesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.VISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.sankatnashan_ganesh_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_sankatnashan_ganesh));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_sankatnashan_ganesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_shani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.VISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.shani_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_shani));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_shani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_shri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.VISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.VISIBLE);
                img_sour.setVisibility(View.INVISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.shri_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_shri));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_shri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        lin_sour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dashboard.mPlayer!=null){
                    Dashboard.mPlayer.stop();
                }
                img_previous.setVisibility(View.VISIBLE);
                img_next.setVisibility(View.INVISIBLE);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

                lp.bottomMargin = 220;
                scroll.setLayoutParams(lp);
                lin_play.setVisibility(View.VISIBLE);
                img_dattatreya.setVisibility(View.INVISIBLE);
                img_ganpati_atharv.setVisibility(View.INVISIBLE);
                img_ganpati_sukta.setVisibility(View.INVISIBLE);
                img_mahalakshmi.setVisibility(View.INVISIBLE);
                img_maruti.setVisibility(View.INVISIBLE);
                img_navgraha.setVisibility(View.INVISIBLE);
                img_purusha.setVisibility(View.INVISIBLE);
                img_ramaraksha.setVisibility(View.INVISIBLE);
                img_rudra.setVisibility(View.INVISIBLE);
                img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
                img_shani.setVisibility(View.INVISIBLE);
                img_shri.setVisibility(View.INVISIBLE);
                img_sour.setVisibility(View.VISIBLE);
                Dashboard.mPlayer = MediaPlayer.create(getActivity(),R.raw.sour_stotram);
                Dashboard.mPlayer.start();

                play_name.setText(getResources().getString(R.string.str_stotram_sour));

                ScheduledExecutorService myScheduledExecutorService = Executors.newScheduledThreadPool(1);

                myScheduledExecutorService.scheduleWithFixedDelay(
                        new Runnable() {
                            @Override
                            public void run() {
                                monitorHandler.sendMessage(monitorHandler.obtainMessage());
                            }
                        },
                        100, //initialDelay
                        100, //delay
                        TimeUnit.MILLISECONDS);

            }

        });

        img_sour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        img_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_call();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //listener
            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
                //add your event here
                Dashboard.mPlayer.seekTo((int) (((double) pos / 100) * Dashboard.mPlayer.getDuration()));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser) {
                pos = progress;
                seekBar.setProgress(progress);
            }

        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUserVisibleHint(false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            pause_call();
        }
    }

    public void pause_call() {
        lin_play.setVisibility(View.GONE);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)scroll.getLayoutParams();

        lp.bottomMargin = 0;
        scroll.setLayoutParams(lp);
        if(Dashboard.mPlayer!=null){
            Dashboard.mPlayer.stop();
        }
        img_dattatreya.setVisibility(View.INVISIBLE);
        img_ganpati_atharv.setVisibility(View.INVISIBLE);
        img_ganpati_sukta.setVisibility(View.INVISIBLE);
        img_mahalakshmi.setVisibility(View.INVISIBLE);
        img_maruti.setVisibility(View.INVISIBLE);
        img_navgraha.setVisibility(View.INVISIBLE);
        img_purusha.setVisibility(View.INVISIBLE);
        img_ramaraksha.setVisibility(View.INVISIBLE);
        img_rudra.setVisibility(View.INVISIBLE);
        img_sankatnashan_ganesh.setVisibility(View.INVISIBLE);
        img_shani.setVisibility(View.INVISIBLE);
        img_shri.setVisibility(View.INVISIBLE);
        img_sour.setVisibility(View.INVISIBLE);
    }

    Handler monitorHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            long totalDuration = Dashboard.mPlayer.getDuration();
            long currentDuration = Dashboard.mPlayer.getCurrentPosition();

            if(totalDuration == currentDuration) {
                Dashboard.mPlayer.seekTo(0);
                seekBar.setProgress(0);
                Dashboard.mPlayer.stop();
            }

            // Displaying time completed playing
            play_time.setText(""
                    + milliSecondsToTimer(currentDuration));

            // Updating progress bar
            int progress = (getProgressPercentage(currentDuration,
                    totalDuration));
            // Log.d("Progress", ""+progress);
            seekBar.setProgress(progress);
        }

    };

    public String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        // Add hours if there
        if(hours > 0){
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if(seconds < 10){
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;}

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    public int getProgressPercentage(long currentDuration, long totalDuration){
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage =(((double)currentSeconds)/totalSeconds)*100;

        // return percentage
        return percentage.intValue();
    }



}
