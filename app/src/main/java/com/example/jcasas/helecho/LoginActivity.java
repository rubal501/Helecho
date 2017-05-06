package com.example.jcasas.helecho;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener{

    private TextView registerHint;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buildUi();
    }

    private void buildUi() {
        registerHint = (TextView) findViewById(R.id.loginRegisterHint);
        registerHint.setOnClickListener(this);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginRegisterHint:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.buttonLogin:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}
