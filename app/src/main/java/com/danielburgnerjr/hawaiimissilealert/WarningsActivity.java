package com.danielburgnerjr.hawaiimissilealert;

import android.support.v7.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.MobileAds;

public class WarningsActivity extends Activity {
    Button btnTsunamiWarning;
    Button btnHighSurfWarning;
    Button btnLandslideHanaRoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warnings);

        MobileAds.initialize(this, "ca-app-pub-8379108590476103~9902912939");

        btnTsunamiWarning = (Button) findViewById(R.id.btnTsunamiWarning);
        btnTsunamiWarning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("tsunami_warning");
            }
        });

        btnHighSurfWarning = (Button) findViewById(R.id.btnHighSurfWarning);
        btnHighSurfWarning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("high_surf_warning");
            }
        });

        btnLandslideHanaRoad = (Button) findViewById(R.id.btnLandslideHanaRoad);
        btnLandslideHanaRoad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayMessage("landslide_hana_road");
            }
        });
    }

    protected void displayMessage(String strButton) {
        if (strButton.equals("tsunami_warning")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("Tsunami inbound, seek shelter immediately.")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (strButton.equals("high_surf_warning")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("High surf warning in effect, all beaches affected are " +
                            "closed until further notice.")
                    .setPositiveButton("OK", null)
                    .show();
        }
        if (strButton.equals("landslide_hana_road")) {
            AlertDialog adAlertBox = new AlertDialog.Builder(this)
                    .setMessage("Landslide reported on Hana Road.  Hana Road is closed " +
                            "until further notice.")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
