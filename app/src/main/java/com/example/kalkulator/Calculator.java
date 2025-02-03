package com.example.kalkulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    TextView tvName;
    Spinner spOperator;
    Button btnCalculate;
    int indexSpinnerOp = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        tvName = (TextView) findViewById(R.id.tvName);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        spOperator = (Spinner) findViewById(R.id.spOperator);
        spOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int indexSpinner, long l) {
                indexSpinnerOp = indexSpinner;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // kondisi switch
                switch (indexSpinnerOp){
                    case 0:
                        // tambah
                        // parsing data dari edittext "5" -> 5
                        break;
                }
            }
        });

        // untuk get dari shared pref
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String username = pref.getString("username", "kosong"); // getting String
        tvName.setText("welcome : "+username);

    }
}