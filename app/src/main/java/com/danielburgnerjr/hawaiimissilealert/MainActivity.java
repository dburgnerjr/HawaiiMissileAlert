package com.danielburgnerjr.hawaiimissilealert;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends Activity {

    String strPackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        strPackName = getApplicationContext().getPackageName();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, String.valueOf(R.string.admob_app_id));

        final Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intA);
            }
        });

        final Button btnAlerts = (Button) findViewById(R.id.btnAlerts);
        btnAlerts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, AlertsActivity.class);
                startActivity(intA);
            }
        });

        final Button btnWarnings = (Button) findViewById(R.id.btnWarnings);
        btnWarnings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, WarningsActivity.class);
                startActivity(intA);
            }
        });

        final Button btnTests = (Button) findViewById(R.id.btnTests);
        btnTests.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, TestsActivity.class);
                startActivity(intA);
            }
        });
    }
}
