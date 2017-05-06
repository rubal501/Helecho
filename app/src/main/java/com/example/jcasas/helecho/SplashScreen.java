package com.example.jcasas.helecho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(500);
                    login();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void login() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
