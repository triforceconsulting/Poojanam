package com.triforce.namami;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

public class Change_Language extends AppCompatActivity {

    CheckBox check_marathi;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "Namami";
    public static final String LanguageShown = "LanguageShown";

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__language);

        check_marathi = (CheckBox) findViewById(R.id.change_lang_marathi);
        check_marathi.setText( getResources().getString(R.string.cng_marathi) + " (Marathi) ");

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LanguageShown, "true");
        editor.commit();

        check_marathi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(Change_Language.this, Dashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return false;
            }

        });

    }

}
