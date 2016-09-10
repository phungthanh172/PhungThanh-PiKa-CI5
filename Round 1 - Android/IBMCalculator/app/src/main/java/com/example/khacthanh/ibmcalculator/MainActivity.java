package com.example.khacthanh.ibmcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.toString() ;
    private EditText etWeight;
    private EditText etHeight;
    private Button btnCalculator;
    private TextView tvResult;
    private TextView tvResultNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLayoutReferences();

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float weight = Float.parseFloat(etWeight.getText().toString());
                    float height = Float.parseFloat(etHeight.getText().toString());
                    height /= 100;
                    Log.d(TAG, String.format("Calculator : %s %s ", weight, height));
                    float bmi = weight / (height * height);
                    Log.d(TAG, String.format("Calculator DONE : %s %s %s",weight, height, bmi));
                    tvResult.setText(String.format("%.2f",bmi));
                    tvResultNotice.setText(getBMItype(bmi));
                } catch (Exception e){
                    Log.d(TAG, "Exception in parse...");
                }
            }
        });
    }

    String getBMItype(float bmi){
        if(bmi <16){
            return "Very severely underweight";
        }else if(bmi< 18.5){
            return "Underweight";
        }else if(bmi<25){
            return "Normal (healthy weight)";
        }else if(bmi<30){
            return "Overweight";
        }else {
            return "Obese";
        }
    }
    void getLayoutReferences() {
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        btnCalculator = (Button) findViewById(R.id.btnCalculator);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResultNotice = (TextView) findViewById(R.id.tvResultNotice);
    }
}
