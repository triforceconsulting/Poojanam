package com.triforce.namami;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by MansiPatel on 17/08/2017.
 */
public class MyApp extends Application {

    String languageCode = "";
    public static Resources mResources;

    @Override
    public void onCreate() {
        super.onCreate();
        mResources = getResources();
        setLocale(languageCode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final Locale locale = newConfig.locale;
        setLocale(languageCode);
    }

    public static void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = mResources;
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

}
