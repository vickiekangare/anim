package com.example.rohitraina.money_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonalDetailsActivity extends AppCompatActivity implements OnItemSelectedListener, View.OnClickListener {

    Spinner spState;
    SeekBar sbAmt;

    EditText tvAmt;

    EditText mEtFname;
    EditText mEtLname;
    EditText mEtCompname;
    EditText mEtEmaiId;
    EditText mEtCity;

    String email;



    Button mbtn12;
    Button mbtn24;
    Button mbtn36;
    Button mbtn48;

    Button mbtnPrivate;
    Button mbtnPublic;
    Button mbtnGovernment;

    Button mbtnSallaried;
    Button mbtnNonSallaried;

    Button mbtnCheck;
    Button mbtnBank;
    Button mbtnCash;

    private Button[] btnMonths = new Button[4];
    private Button[] btnSector = new Button[3];
    private Button[] btnSallary = new Button[2];
    private Button[] btnMode = new Button[3];

    private Button btn_unfocusMonth;
    private Button btn_unfocusSector;
    private Button btn_unfocusSallary;
    private Button btn_unfocusMode;


    private int[] btn_id = {R.id.btn12, R.id.btn24, R.id.btn36, R.id.btn48};
    private int[] btn_id1 = {R.id.btnPrivate, R.id.btnPublic, R.id.btnGovernment};
    private int[] btn_id2 = {R.id.btnSallaried, R.id.btnNonsallaried};
    private int[] btn_id3 = {R.id.btnCheck, R.id.btnBank,R.id.btnCash};



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        spState = (Spinner) findViewById(R.id.spState);//for spinner
        spState.setOnItemSelectedListener(this);
        List<String> states = new ArrayList<String>();
        states.add("Select your state");
        states.add("Andra Pradesh");
        states.add("Arunachal Pradesh");
        states.add("Assam");
        states.add("Bihar");
        states.add("Chhattisgarh");
        states.add("Goa");
        states.add("Gujarat");
        states.add("Haryana");
        states.add("Himachal Pradesh");
        states.add("Jammu and Kashmir");
        states.add("Jharkhand");
        states.add("Karnataka");
        states.add("Kerala");
        states.add("Madya Pradesh");
        states.add("Maharashtra");
        states.add("Mizoram");
        states.add("Punjab");
        states.add("Rajasthan");
        states.add("Sikkim");
        states.add("Tripura");
        states.add("West Bengal");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spState.setAdapter(dataAdapter);
        seekbar();//for seekbar
        //textView2.setBackgroundColor(Color.parseColor("#808080"));


        for (int i = 0; i < btnMonths.length; i++) {
            btnMonths[i] = (Button) findViewById(btn_id[i]);
            btnMonths[i].setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
            btnMonths[i].setOnClickListener(this);
        }

        btn_unfocusMonth = btnMonths[0];

        for (int i = 0; i < btnSector.length; i++) {
            btnSector[i] = (Button) findViewById(btn_id1[i]);
            btnSector[i].setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
            btnSector[i].setOnClickListener(this);
        }

        btn_unfocusSector = btnSector[0];

        for (int i = 0; i < btnSallary.length; i++) {
            btnSallary[i] = (Button) findViewById(btn_id2[i]);
            btnSallary[i].setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
            btnSallary[i].setOnClickListener(this);
        }

        btn_unfocusSallary = btnSallary[0];

        for (int i = 0; i < btnMode.length; i++) {
            btnMode[i] = (Button) findViewById(btn_id3[i]);
            btnMode[i].setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
            btnMode[i].setOnClickListener(this);
        }

        btn_unfocusMode = btnMode[0];


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @SuppressLint("SetTextI18n")
    public void seekbar() {
        sbAmt = (SeekBar) findViewById(R.id.seekBar);
        tvAmt = (EditText) findViewById(R.id.tvAmt);
        tvAmt.setSelection(tvAmt.getText().length());
        // sbAmt.setProgress(50000);
        tvAmt.setText("Rs." + 50000);
        sbAmt.incrementProgressBy(10000);
        sbAmt.setMax(200000);

        sbAmt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;
                progress = progress / 10;
                progress = progress * 10;
                tvAmt.setText(String.valueOf(progress));
                //tvAmt.setText("Rs." + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvAmt.setText("Rs." + progress_value);

            }

        });

        tvAmt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    //Update Seekbar value after entering a number
                    sbAmt.setProgress(Integer.parseInt(s.toString()));
                } catch (Exception ex) {
                }
            }

        });
    }


    public void onClick(View v) {//for all button click

        mbtn12 = (Button) findViewById(R.id.btn12);
        mbtn24 = (Button) findViewById(R.id.btn24);
        mbtn36 = (Button) findViewById(R.id.btn36);
        mbtn48 = (Button) findViewById(R.id.btn48);

        mbtnPrivate = (Button) findViewById(R.id.btnPrivate);
        mbtnPublic = (Button) findViewById(R.id.btnPublic);
        mbtnGovernment = (Button) findViewById(R.id.btnGovernment);

        mbtnCheck = (Button) findViewById(R.id.btnCheck);
        mbtnBank = (Button) findViewById(R.id.btnBank);
        mbtnCash = (Button) findViewById(R.id.btnCash);


        mbtnSallaried = (Button) findViewById(R.id.btnSallaried);
        mbtnNonSallaried = (Button) findViewById(R.id.btnNonsallaried);

        //setFocus(btn_unfocus, (Button) findViewById(v.getId()));
        int id = v.getId();
        switch (id) {
            case R.id.btn12:
                setFocus(btn_unfocusMonth, btnMonths[0]);
                break;

            case R.id.btn24:
                setFocus(btn_unfocusMonth, btnMonths[1]);
                break;

            case R.id.btn36:
                setFocus(btn_unfocusMonth, btnMonths[2]);
                break;

            case R.id.btn48:
                setFocus(btn_unfocusMonth, btnMonths[3]);
                break;
        }


        int id1 = v.getId();
        switch (id1) {
            case R.id.btnPrivate:
                setFocus1(btn_unfocusSector, btnSector[0]);
                break;

            case R.id.btnPublic:
                setFocus1(btn_unfocusSector, btnSector[1]);
                break;

            case R.id.btnGovernment:
                setFocus1(btn_unfocusSector, btnSector[2]);
                break;

        }


        int id2 = v.getId();
        switch (id2) {
            case R.id.btnSallaried:
                setFocus2(btn_unfocusSallary, btnSallary[0]);
                break;

            case R.id.btnNonsallaried:
                setFocus2(btn_unfocusSallary, btnSallary[1]);
                break;

                }


        int id3 = v.getId();

        switch (id3) {
            case R.id.btnCheck:
                setFocus3(btn_unfocusMode, btnMode[0]);
                break;

            case R.id.btnBank:
                setFocus3(btn_unfocusMode, btnMode[1]);
                break;


            case R.id.btnCash:
                setFocus3(btn_unfocusMode, btnMode[2]);
                break;
        }
                }




    private void setFocus(Button btn_unfocus, Button btn_focus) {

        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        this.btn_unfocusMonth = btn_focus;
    }

    private void setFocus1(Button btn_unfocus, Button btn_focus) {

        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        this.btn_unfocusSector = btn_focus;
    }

    private void setFocus2(Button btn_unfocus, Button btn_focus) {

        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        this.btn_unfocusSallary = btn_focus;
    }

    private void setFocus3(Button btn_unfocus, Button btn_focus) {

        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.btn_backgrnd));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.btn_style));
        this.btn_unfocusMode = btn_focus;
    }



    public void next(View view) {

        mEtFname = (EditText)findViewById(R.id.etFname);
        mEtLname = (EditText)findViewById(R.id.etLname);
        mEtCompname = (EditText)findViewById(R.id.etCompname);
        mEtEmaiId = (EditText)findViewById(R.id.etEmaiId);
        mEtCity = (EditText)findViewById(R.id.etCity);

        email = mEtEmaiId.getText().toString();

        if(mEtFname.getText().toString().equals(""))
        {
            Toast.makeText(this,"First Name is empty",Toast.LENGTH_SHORT).show();
        }

        else if (mEtLname.getText().toString().equals(""))
        {
            {
                Toast.makeText(this,"Last Name is empty",Toast.LENGTH_SHORT).show();
            }
        }
        else if (mEtCompname.getText().toString().equals(""))
        {
            {
                Toast.makeText(this,"Company Name is empty",Toast.LENGTH_SHORT).show();
            }
        }
        else if (mEtEmaiId.getText().toString().equals(""))
        {
            {
                Toast.makeText(this,"Email-Id is empty",Toast.LENGTH_SHORT).show();
            }
        }
        else if (mEtCity.getText().toString().equals(""))
        {
            {
                Toast.makeText(this,"City name is empty",Toast.LENGTH_SHORT).show();
            }
        }


        else if((!isValidMail()))
        {
            Toast.makeText(this,"Email is not valid",Toast.LENGTH_SHORT).show();
        }


        else if((isValidMail()))
            {
            Intent intent = new Intent(this, AdharCardActivity.class);
            startActivity(intent);
            }

    }

    private boolean isValidMail() {

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}

