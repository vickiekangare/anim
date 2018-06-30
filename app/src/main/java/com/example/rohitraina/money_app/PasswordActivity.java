package com.example.rohitraina.money_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {


    TextView mTvChangePasswod;
    TextView mTvForgetPassword;

    EditText mEtPassword1;
    EditText mEtPassword2;
    EditText mEtPassword3;
    EditText mEtPassword4;


    private static final String TAG = "LoginActivity";
    ImageView i1, i2, i3, i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);



        mEtPassword1 = (EditText)findViewById(R.id.et1);
        mEtPassword2 = (EditText)findViewById(R.id.et2);
        mEtPassword3 = (EditText)findViewById(R.id.et3);
        mEtPassword4 = (EditText)findViewById(R.id.et4);

        mTvChangePasswod=(TextView)findViewById(R.id.tvChangePassword);
        mTvForgetPassword=(TextView)findViewById(R.id.tvForgetPassword);


        i1 = (ImageButton) findViewById(R.id.imgbtnUploadPendingPods1);
        i2 = (ImageButton) findViewById(R.id.imgbtnUploadPendingPods2);
        i3 = (ImageButton) findViewById(R.id.imgbtnUploadPendingPods3);
        i4 = (ImageButton) findViewById(R.id.imgbtnUploadPendingPods4);


        mEtPassword1.requestFocus();
        mEtPassword1.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEtPassword1.setFocusableInTouchMode(true);


        mEtPassword1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                i1.setImageResource(R.drawable.circle2);
                mEtPassword1.setVisibility(View.INVISIBLE);
            }
        });


      //  mEtPassword2.requestFocus();
        mEtPassword2.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEtPassword2.setFocusableInTouchMode(true);

        mEtPassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                i2.setImageResource(R.drawable.circle2);
                mEtPassword2.setVisibility(View.INVISIBLE);
            }
        });

     //   mEtPassword3.requestFocus();
        mEtPassword3.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEtPassword3.setFocusableInTouchMode(true);

        mEtPassword3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                i3.setImageResource(R.drawable.circle2);
                mEtPassword3.setVisibility(View.INVISIBLE);
            }
        });

    //    mEtPassword4.requestFocus();
        mEtPassword4.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEtPassword4.setFocusableInTouchMode(true);

        mEtPassword4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                i4.setImageResource(R.drawable.circle2);
                mEtPassword4.setVisibility(View.INVISIBLE);
                if(mEtPassword4!=null)
                {
                   nextActivity();
                   finish();
                }
            }
        });

    mTvChangePasswod.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeActiviry();
        }
    });

    mTvForgetPassword.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           forgetActivity();
        }
    });
        }

    private void forgetActivity() {
        Intent intent = new Intent(this,ForgetPassword.class);
        startActivity(intent);
    }

    private void changeActiviry() {
        Intent intent = new Intent(this,ChangePassword.class);
        startActivity(intent);
    }

    public void nextActivity()
    {

        Intent intent = new Intent(this,PersonalDetailsActivity.class);
        startActivity(intent);
    }





}


