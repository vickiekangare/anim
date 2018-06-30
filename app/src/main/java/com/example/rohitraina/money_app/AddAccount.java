package com.example.rohitraina.money_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.wifi.aware.PublishConfig;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.nio.file.Path;

public class AddAccount extends AppCompatActivity {

    Context context;
    FloatingActionButton mfab_add;
    Animation FabOpen, FabClose, FabRcockwisew, FabRanriclockwise;//for button layout
    boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        mfab_add = (FloatingActionButton) findViewById(R.id.fab_add);

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);//for button layout
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);//for button layout
        FabRcockwisew = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);//for button layout
        FabRanriclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rorate_anticlockwise);//for button layout

        mfab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isopen) {
//                    fab_multi.startAnimation(FabClose);
//                    fab_minus.startAnimation(FabOpen);
                    mfab_add.startAnimation(FabRanriclockwise);
//                    fab_minus.setClickable(false);
//                    fab_multi.setClickable(false);
                    isopen = false;




                } else {
//                    fab_multi.startAnimation(FabOpen);
//                    fab_minus.startAnimation(FabOpen);
                    mfab_add.startAnimation(FabRcockwisew);
//                    fab_minus.setClickable(true);
//                    fab_multi.setClickable(true);
                    isopen = true;
                }

            }
        });




    }

    public void know()
    {
        Intent intent = new Intent(context,AddAccount.class);
        startActivity(intent);

    }



}
