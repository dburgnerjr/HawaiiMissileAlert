package com.danielburgnerjr.hawaiimissilealert;

import android.support.v7.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.MobileAds;

public class TestsActivity extends Activity {
    Button btnTestMessage;
    Button btnPACOMDrillState;
    Button btnAmberAlertDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        MobileAds.initialize(this, "ca-app-pub-8379108590476103~9902912939");

        btnTestMessage = (Button) findViewById(R.id.btnTestMessage);
        btnTestMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("test_message");
            }
        });

        btnPACOMDrillState = (Button) findViewById(R.id.btnPACOMDrillState);
        btnPACOMDrillState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("pacom_drill_state");
            }
        });

        btnAmberAlertDemo = (Button) findViewById(R.id.btnAmberAlertDemo);
        btnAmberAlertDemo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("amber_alert_demo");
            }
        });
    }

    protected void displayMessage(String strButton) {
        if (strButton.equals("test_message")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("This is a test of the Hawaii Emergency Alert System. " +
                            "This is only a test.")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (strButton.equals("pacom_drill_state")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("This is a drill. Missile Alert! Missiles inbound, " +
                            "seek shelter immediately.")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (strButton.equals("amber_alert_demo")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("This is a drill. Amber Alert! Missing child reported in " +
                            "Maui County. License Plate ABC 123")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
