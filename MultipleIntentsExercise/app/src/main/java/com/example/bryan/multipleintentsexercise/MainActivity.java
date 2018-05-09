package com.example.bryan.multipleintentsexercise;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;


public class MainActivity extends AppCompatActivity {

    private final int DEDUCTION_REQUEST = 30;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            TextView tv = (TextView)findViewById(R.id.taxable);
            writeTaxes(tv.getText().toString());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == DEDUCTION_REQUEST && resultCode == RESULT_OK){
            double deductionValue = data.getDoubleExtra("deduction",0.0);
            EditText deduction = (EditText)findViewById(R.id.deduction);
            deduction.setText(Double.toString(deductionValue));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button worksheet = (Button)findViewById(R.id.deductionWorksheet);
        worksheet.setOnClickListener(new WorksheetStarter());

        Button calc = (Button)findViewById(R.id.calc);
        calc.setOnClickListener(new CalculateListener());

        Button send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new SendListener());
    }



    private class WorksheetStarter implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText income = (EditText)findViewById(R.id.income);

            Intent deductionIntent = new Intent(MainActivity.this, Worksheet.class);
            deductionIntent.putExtra("income",
                    Double.parseDouble(income.getText().toString()));
            startActivityForResult(deductionIntent,DEDUCTION_REQUEST);

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

    private class SendListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tax = (TextView)findViewById(R.id.taxable);

            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Your taxes are" + tax.getText());
            sendIntent.putExtra(Intent.EXTRA_SUBJECT,"Your Taxes!!!");
            sendIntent.setType("text/plain");

            if(sendIntent.resolveActivity(getPackageManager()) != null){
                startActivity(sendIntent);
            }else{
                /*sendIntent.setData(Uri.parse("sms://4104551000"));
                sendIntent.putExtra("sms_body", "Your taxes are" + tax.getText());
                startActivity(sendIntent);*/
                String[] permissions =  {Manifest.permission.WRITE_EXTERNAL_STORAGE};

                if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    writeTaxes(tax.getText().toString());
                }
                else{
                    requestPermissions(permissions,4500);
                }

            }
        }
    }

    private void writeTaxes(String tax) {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File location = getExternalFilesDir(null);
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        location.getAbsoluteFile() + "/taxes.txt"));
                pw.println(tax);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
