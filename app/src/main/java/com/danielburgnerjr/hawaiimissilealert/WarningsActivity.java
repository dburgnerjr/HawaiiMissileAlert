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

public class WarningsActivity extends Activity {
    Button btnTsunamiWarning;
    Button btnHighSurfWarning;
    Button btnLandslideHanaRoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warnings);

        MobileAds.initialize(this, String.valueOf(R.string.admob_app_id));
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnTsunamiWarning = findViewById(R.id.btnTsunamiWarning);
        btnTsunamiWarning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("tsunami_warning");
            }
        });

        btnHighSurfWarning = findViewById(R.id.btnHighSurfWarning);
        btnHighSurfWarning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("high_surf_warning");
            }
        });

        btnLandslideHanaRoad = findViewById(R.id.btnLandslideHanaRoad);
        btnLandslideHanaRoad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("landslide_hana_road");
            }
        });
    }

    protected void displayMessage(String strButton) {
        AlertDialog adAlertBox = new AlertDialog.Builder(this).create();
        switch (strButton) {
            case "tsunami_warning":
                adAlertBox.setMessage("Tsunami inbound, seek shelter immediately.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                break;
            case "high_surf_warning":
                adAlertBox.setMessage("High surf warning in effect, all beaches affected are closed "
                        + "until further notice.");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                adAlertBox.show();
                break;
            case "landslide_hana_road":
                adAlertBox.setMessage("Landslide reported on Hana Road.  Hana Road is closed until "
                        + "further notice.");
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
