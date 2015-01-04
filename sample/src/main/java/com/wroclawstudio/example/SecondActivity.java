package com.wroclawstudio.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wroclawstudio.kioskmode.KioskActivity;

/**
 * Created by jakubszczygiel on 04/01/15.
 */
public class SecondActivity extends KioskActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_second);
        findViewById(R.id.a_second_finish_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
