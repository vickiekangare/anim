package com.example.rohitraina.money_app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;//for drawer
    ActionBarDrawerToggle actionBarDrawerToggle;//for drawer

    EditText mEtMobNo;

    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);//for drawer
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);//for drawer
        drawerLayout.setDrawerListener(actionBarDrawerToggle);//for drawer
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {//for drawer
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    public void login(View view) {



        mEtMobNo = (EditText)findViewById(R.id.etMobileno);
        phone =mEtMobNo.getText().toString();

        if(mEtMobNo.getText().toString().equals(""))
        {
            Toast.makeText(this,"Please Enter Your 10 digit  Mobile Number",Toast.LENGTH_SHORT).show();
        }

        else
            {
                Intent intent = new Intent(this, PasswordActivity.class);
                startActivity(intent);
            }

    }



//    private boolean isValidMobile() {
//        boolean check=false;
//        if(!Pattern.matches("[1-9][0-9]{9}", phone)) {
//            if(phone.length() < 10 || phone.length() > 10) {
//                // if(phone.length() != 10) {
//                check = false;
//                Toast.makeText(this,"Mobile Number is not valid",Toast.LENGTH_SHORT).show();
//            } else {
//                check = true;
//            }
//        } else {
//            check=false;
//        }
//        return check;
//    }




}
