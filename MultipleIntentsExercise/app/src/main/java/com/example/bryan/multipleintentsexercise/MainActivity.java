package com.example.bryan.multipleintentsexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button worksheet = (Button)findViewById(R.id.deductionWorksheet);
        worksheet.setOnClickListener(new WorksheetStarter());

        Button calc = (Button)findViewById(R.id.calc);
        calc.setOnClickListener(new CalculateListener());
    }



    private class WorksheetStarter implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,Worksheet.class);
            EditText income = (EditText)findViewById(R.id.income);

        }
    }

    private class CalculateListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText income = (EditText)findViewById(R.id.income);
            EditText interest = (EditText)findViewById(R.id.interest);
            EditText deduction = (EditText)findViewById(R.id.deduction);

            double gross = Double.parseDouble(income.getText().toString()) +
                    Double.parseDouble(income.getText().toString());

            double taxable = gross - Double.parseDouble(deduction.getText().toString());
            if(taxable < 0){
                taxable = 0;
            }
            TextView tax = (TextView)findViewById(R.id.taxable);
            tax.setText(Double.toString(taxable));
        }
    }
}
