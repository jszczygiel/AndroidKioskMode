package com.wroclawstudio.example;

import android.os.Bundle;
import android.view.View;

import com.wroclawstudio.kioskmode.KioskActivity;

/**
 * Created by jakubszczygiel on 15/11/14.
 */
public class ExampleKioskActivity extends KioskActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_kiosk);
        findViewById(R.id.a_kiosk_finish_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
