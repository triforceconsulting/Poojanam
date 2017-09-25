package com.triforce.namami;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.triforce.namami.Fragments.PoojavidhiFragment;
import com.triforce.namami.Fragments.SamagriFragment;

public class PoojaInformation extends AppCompatActivity {
    LinearLayout Lin_back_poojainformation;
    public static ImageView imgsharePoojaInfo;
    ImageView imgbackPoojaInfo;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public static String puja;
    TextView txtTitle;
    public static int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pooja_information);

        txtTitle = (TextView)findViewById(R.id.txtTitlePoojaInfo);
        imgbackPoojaInfo = (ImageView)findViewById(R.id.imgbackPoojaInfo);
        Lin_back_poojainformation = (LinearLayout)findViewById(R.id.lin_poojas_back);
        imgsharePoojaInfo = (ImageView)findViewById(R.id.imgSharePujaInfo);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 1) {
                    mViewPager.setCurrentItem(1);
                    imgsharePoojaInfo.setVisibility(View.GONE);
                    return;
                } else {
                    mViewPager.setCurrentItem(0);
                    imgsharePoojaInfo.setVisibility(View.VISIBLE);
                    return;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        imgbackPoojaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoojaInformation.this.finish();
               // PoojavidhiFragment.mPlayer.stop();
            }
        });




/*
        Lin_back_poojainformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoojaInformation.this.finish();
            }
        });*/

        Intent i = getIntent();
        puja = i.getStringExtra("puja");


        if(puja.equals("ganeshpuja")) {
            txtTitle.setText("Ganesh Chaturthi");
        }
        else if(puja.equals("manglagauripuja")){
            txtTitle.setText("ManglaGauri");
        }
        else if(puja.equals("satyanarayanpuja")) {
            txtTitle.setText("SatyaNarayan");
        }

    }
    
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            final Fragment result;
            switch (position) {
                case 0:
                    result = new SamagriFragment();
                    break;
                case 1:
                    result = new PoojavidhiFragment();
                    break;
                //return PlaceholderFragment.newInstance(position + 1);
                default:
                    result = null;
                    break;
            }

            return result;
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.str_title_samagri);
                case 1:
                    return getString(R.string.str_title_poojavidhi);
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  PoojavidhiFragment.mPlayer.stop();
    }
}
