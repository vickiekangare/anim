package com.example.rohitraina.money_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdharCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhar_card);

    }

    public void next(View view) {
        Intent intent = new Intent(this,AddAccount.class);
        startActivity(intent);
    }
}
