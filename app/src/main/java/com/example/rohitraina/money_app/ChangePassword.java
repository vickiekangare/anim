package com.example.rohitraina.money_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class ChangePassword extends AppCompatActivity {

    EditText mEtNpass;
    EditText mEtCnPass;

    String strNpass;
    String strCnPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        mEtNpass = (EditText)findViewById(R.id.etNewPass);
        mEtCnPass = (EditText)findViewById(R.id.etConfermPass);
    }

    public void home(View view) {

        strNpass=mEtNpass.getText().toString();
        strCnPass=mEtCnPass.getText().toString();


        if(strNpass.equals(strCnPass))
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            }
        else
            {

            Toast.makeText(this,"Password does not match",Toast.LENGTH_SHORT).show();
            }
    }
}
