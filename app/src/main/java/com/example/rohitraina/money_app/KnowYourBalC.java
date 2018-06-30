package com.example.rohitraina.money_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KnowYourBalC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_bal_c);
    }

    public void Add_bank(View view) {
        Intent intent = new Intent(this,AddBank.class);
        startActivity(intent);
    }
}
