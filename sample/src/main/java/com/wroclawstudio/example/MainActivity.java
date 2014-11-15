package com.wroclawstudio.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wroclawstudio.kioskmode.KioskActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        findViewById(R.id.a_main_start_kiosk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KioskActivity.startKioskActivity(MainActivity.this, ExampleKioskActivity.class);

            }
        });
    }


}
