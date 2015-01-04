package com.wroclawstudio.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wroclawstudio.kioskmode.KioskActivity;
import com.wroclawstudio.kioskmode.RootKioskActivity;

/**
 * Created by jakubszczygiel on 15/11/14.
 */
public class ExampleKioskActivity extends RootKioskActivity {

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
        findViewById(R.id.a_kiosk_start_different_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ExampleKioskActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
