package com.example.bryan.multipleintentsexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Worksheet extends AppCompatActivity {

    double income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worksheet);

        Intent launcher = getIntent();
        income = launcher.getDoubleExtra("income",0.0);

        Button calculate = (Button)findViewById(R.id.calculateDeduction);
        calculate.setOnClickListener(new CalculateDeduction());

        TextView incomeView = (TextView)findViewById(R.id.worksheetIncome);
        incomeView.setText(Double.toString(income));


    }

    private class CalculateDeduction implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            double line_c = 1050;
            if(income > line_c){
                line_c = income;
            }
            double line_d = 0;
            double line_e = 0;
            double line_f = 0;
            RadioGroup rg = (RadioGroup)findViewById(R.id.status);
            Switch dependent = (Switch)findViewById(R.id.dependent);
            switch(rg.getCheckedRadioButtonId()){
                case R.id.single:
                    line_d = 6350;
                    line_f = 0;
                    break;
                case R.id.joint:
                    line_d = 12700;
                    if(dependent.isChecked()){
                        line_f = 4050;
                    }
                    break;
            }
            if(line_d < line_c){
                line_e = line_d;
            }
            else{
                line_e = line_c;
            }

            Intent result = new Intent();
            result.putExtra("deduction", line_e + line_f);
            setResult(RESULT_OK, result);
            finish();

            
        }
    }
}
