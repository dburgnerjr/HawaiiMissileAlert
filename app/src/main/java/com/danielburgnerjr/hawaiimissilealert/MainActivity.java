package com.danielburgnerjr.hawaiimissilealert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String strPackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        strPackName = getApplicationContext().getPackageName();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
