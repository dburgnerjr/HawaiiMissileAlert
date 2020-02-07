package com.danielburgnerjr.hawaiimissilealert;

import androidx.appcompat.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class TestsActivity extends Activity {
    Button btnTestMessage;
    Button btnPACOMDrillState;
    Button btnAmberAlertDemo;
    Button btnVolcanicActivityTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        MobileAds.initialize(this, String.valueOf(R.string.admob_app_id));
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnTestMessage = findViewById(R.id.btnTestMessage);
        btnTestMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("test_message");
            }
        });

        btnPACOMDrillState = findViewById(R.id.btnPACOMDrillState);
        btnPACOMDrillState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("pacom_drill_state");
            }
        });

        btnAmberAlertDemo = findViewById(R.id.btnAmberAlertDemo);
        btnAmberAlertDemo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("amber_alert_demo");
            }
        });

        btnVolcanicActivityTest = findViewById(R.id.btnVolcanicActvityDrill);
        btnVolcanicActivityTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("volcanic_activity_test");
            }
        });

    }

    protected void displayMessage(String strButton) {
        AlertDialog adAlertBox = new AlertDialog.Builder(this).create();
        switch (strButton) {
            case "test_message":
                adAlertBox.setMessage("This is a test of the Hawaii Emergency Alert System. "
                        + "This is only a test.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                });
                adAlertBox.show();
                break;
            case "pacom_drill_state":
                adAlertBox.setMessage("This is a drill. Missile Alert! Missiles inbound, seek "
                        + "shelter immediately.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                });
                adAlertBox.show();
                break;
            case "amber_alert_demo":
                adAlertBox.setMessage("This is a drill. Amber Alert! Missing child reported in Maui "
                        + "County. License Plate ABC 123");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                });
                adAlertBox.show();
                break;
            case "volcanic_activity_test":
                adAlertBox.setMessage("This is a drill. Volcanic eruption reported in Hawaii "
                        + "County. Please proceed with evacuation of the immediate area.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                });
                adAlertBox.show();
                break;
        }
    }
}
