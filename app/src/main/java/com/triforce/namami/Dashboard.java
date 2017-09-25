package com.triforce.namami;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.triforce.namami.Fragments.AarathiFragment;
import com.triforce.namami.Fragments.PoojasFragment;
import com.triforce.namami.Fragments.StotramsFragment;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public static MediaPlayer mPlayer;
   // String myURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyApp.setLocale("mr");


        mPlayer = new MediaPlayer();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                //DO THINGS HERE

                if(mPlayer != null || mPlayer.isPlaying()) {
                    mPlayer.stop();
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
                if(mPlayer != null || mPlayer.isPlaying()) {
                    mPlayer.stop();
                }
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
                if(mPlayer != null || mPlayer.isPlaying()) {
                    mPlayer.stop();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        if(mPlayer != null || mPlayer.isPlaying()) {
            mPlayer.stop();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.
        int id = item.getItemId();

            // Handle the camera action
         if (id == R.id.nav_sendfeedback) {
            Intent intent = new Intent(Dashboard.this,Send_Feedback.class);
            startActivity(intent);
        } else if (id == R.id.nav_rateus) {
             String myURL = "https://play.google.com/store/apps/details?id=com.triforce.namami&hl=en";
             Intent browserIntent1 = new Intent(
                     Intent.ACTION_VIEW, Uri.parse(myURL));
             Bundle b = new Bundle();
             b.putBoolean("new_window", true); //sets new window
             browserIntent1.putExtras(b);
             startActivity(browserIntent1);
        } else if (id == R.id.nav_share) {
             Intent sendIntent = new Intent();
             sendIntent.setAction(Intent.ACTION_SEND);
             sendIntent.putExtra(Intent.EXTRA_TEXT,
                     "Hey check out Namami app at: https://play.google.com/store/apps/details?id=com.triforce.namami&hl=en");
             sendIntent.setType("text/plain");
             startActivity(sendIntent);
         }else if (id == R.id.nav_aboutpoojanam) {
            Intent intent = new Intent(Dashboard.this,About_Poojanam.class);
            startActivity(intent);
        }/* else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
                    result = new PoojasFragment();
                    break;
                case 1:
                    result = new StotramsFragment();
                    break;
                //return PlaceholderFragment.newInstance(position + 1);
                case 2:
                    result = new AarathiFragment();
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
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.str_poojas);
                case 1:
                    return getString(R.string.str_stotrams);
                case 2:
                    return getString(R.string.str_aarathi);
            }
            return null;
        }
    }
}
