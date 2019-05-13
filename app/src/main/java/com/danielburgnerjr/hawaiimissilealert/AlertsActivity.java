package com.danielburgnerjr.hawaiimissilealert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.MobileAds;

public class AlertsActivity extends Activity {
    Button btnAmberAlertKauai;
    Button btnAmberAlertState;
    Button btnPACOMAlertState;
    Button btnVolcanicActivityAlert;
    Button btnBMDFalseAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        MobileAds.initialize(this, String.valueOf(R.string.admob_app_id));

        btnAmberAlertKauai = (Button) findViewById(R.id.btnAmberAlertKauai);
        btnAmberAlertKauai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("amber_alert_kauai");
            }
        });

        btnAmberAlertState = (Button) findViewById(R.id.btnAmberAlertState);
        btnAmberAlertState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("amber_alert_state");
            }
        });

        btnPACOMAlertState = (Button) findViewById(R.id.btnPACOMAlertState);
        btnPACOMAlertState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("pacom_alert_state");
            }
        });

        btnVolcanicActivityAlert = (Button) findViewById(R.id.btnVolcanicActivityAlert);
        btnVolcanicActivityAlert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("volcanic_activity_alert");
            }
        });

        btnBMDFalseAlarm = (Button) findViewById(R.id.btnBMDFalseAlarm);
        btnBMDFalseAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("bmd_false_alarm");
            }
        });

    }

    protected void getConfirmation(final String strButton) {
        AlertDialog adAlertBox = new AlertDialog.Builder(this)
                .setMessage("Are you sure?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        displayMessage(strButton);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.cancel();
                    }
                })
                .show();
    }

    protected void displayMessage(String strButton) {
        if (strButton.equals("amber_alert_kauai")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("Amber Alert! Missing child reported in Kauai County." +
                                "License Plate ABC 123")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (strButton.equals("amber_alert_state")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("Amber Alert! Missing child reported could be anywhere" +
                            " in the state.  License Plate ABC 123")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (strButton.equals("pacom_alert_state")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("Missile Alert! Missiles inbound, seek shelter immediately.")
                    .setPositiveButton("OK", null)
                    .show();
            btnBMDFalseAlarm.setVisibility(View.VISIBLE);
        }

        if (strButton.equals("volcanic_activity_alert")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("Volcanic eruption reported in Hawaii County. " +
                            "Please proceed with evacuation of the immediate area.")
                    .setPositiveButton("OK", null)
                    .show();
        }

        if (strButton.equals("bmd_false_alarm")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("The Missile Alert was a false alarm.")
                    .setPositiveButton("OK", null)
                    .show();
            btnBMDFalseAlarm.setVisibility(View.GONE);
        }
        //close();

    }

}
