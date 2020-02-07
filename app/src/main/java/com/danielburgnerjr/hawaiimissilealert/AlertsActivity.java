package com.danielburgnerjr.hawaiimissilealert;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
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
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnAmberAlertKauai = findViewById(R.id.btnAmberAlertKauai);
        btnAmberAlertKauai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("amber_alert_kauai");
            }
        });

        btnAmberAlertState = findViewById(R.id.btnAmberAlertState);
        btnAmberAlertState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("amber_alert_state");
            }
        });

        btnPACOMAlertState = findViewById(R.id.btnPACOMAlertState);
        btnPACOMAlertState.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("pacom_alert_state");
            }
        });

        btnVolcanicActivityAlert = findViewById(R.id.btnVolcanicActivityAlert);
        btnVolcanicActivityAlert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("volcanic_activity_alert");
            }
        });

        btnBMDFalseAlarm = findViewById(R.id.btnBMDFalseAlarm);
        btnBMDFalseAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getConfirmation("bmd_false_alarm");
            }
        });

    }

    protected void getConfirmation(final String strButton) {
        AlertDialog adAlertBox = new AlertDialog.Builder(this).create();
        adAlertBox.setMessage("Are you sure?");
        adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE,"OK",
                new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        displayMessage(strButton);
                    }
        });
        adAlertBox.setButton(AlertDialog.BUTTON_NEGATIVE,"Cancel",
                new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.cancel();
                    }
        });
        adAlertBox.show();
    }

    protected void displayMessage(String strButton) {
        AlertDialog adAlertBox = new AlertDialog.Builder(this).create();
        switch (strButton) {
            case "amber_alert_kauai":
                adAlertBox.setMessage("Amber Alert! Missing child reported in Kauai County. "
                        + "License Plate ABC 123");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                break;
            case "amber_alert_state":
                adAlertBox.setMessage("Amber Alert! Missing child reported could be anywhere in the "
                        + "state.  License Plate ABC 123");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                break;
            case "pacom_alert_state":
                adAlertBox.setMessage("Missile Alert! Missiles inbound, seek shelter immediately.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                btnBMDFalseAlarm.setVisibility(View.VISIBLE);
                break;
            case "volcanic_activity_alert":
                adAlertBox.setMessage("Volcanic eruption reported in Hawaii County. Please proceed "
                        + "with evacuation of the immediate area.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                break;
            case "bmd_false_alarm":
                adAlertBox.setMessage("The Missile Alert was a false alarm.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                btnBMDFalseAlarm.setVisibility(View.GONE);
                break;
        }
    }
}
