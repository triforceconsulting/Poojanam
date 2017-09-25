package com.triforce.namami;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "Namami";
    public static final String LanguageShown = "LanguageShown";
    String language = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        language = sharedpreferences.getString(LanguageShown, "");

        MyApp.setLocale("mr");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if(language.equals("true")) {
                    Intent intent = new Intent(Splash_Screen.this, Dashboard.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Splash_Screen.this,Change_Language.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_TIME_OUT);
    }

}
