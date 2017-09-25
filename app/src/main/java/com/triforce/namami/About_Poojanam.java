package com.triforce.namami;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class About_Poojanam extends AppCompatActivity {

    ImageView back;
    ImageButton facebook,twitter;
    String urlToShare = "https://play.google.com/store/apps/details?id=com.triforce.namami&hl=en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_poojanam);

        back = (ImageView) findViewById(R.id.imgAboutBack);
        facebook = (ImageButton) findViewById(R.id.img_about_facebook);
        twitter = (ImageButton) findViewById(R.id.img_about_twitter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                About_Poojanam.this.finish();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent();
                    intent1.setClassName("com.facebook.katana", "com.facebook.katana.activity.composer.ImplicitShareIntentHandler");
                    intent1.setAction("android.intent.action.SEND");
                    intent1.setType("text/plain");
                    intent1.putExtra("android.intent.extra.TEXT", urlToShare);
                    startActivity(intent1);
                } catch (Exception e) {
                    // If we failed (not native FB app installed), try share through SEND
                    String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + urlToShare;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                    startActivity(intent);
                }
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent();
                    intent1.setClassName("com.twitter.android", "com.twitter.android.composer.ComposerActivity");
                    intent1.setAction("android.intent.action.SEND");
                    intent1.setType("text/plain");
                    intent1.putExtra("android.intent.extra.TEXT", urlToShare);
                    startActivity(intent1);
                } catch (Exception e) {
                    // If we failed (not native FB app installed), try share through SEND
                    String sharerUrl = "https://twitter.com/intent/tweet?text=" + urlToShare;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        About_Poojanam.this.finish();
    }
}
