package com.example.bryan.currencyexchange;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

class ConvertListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        View root = view.getRootView();
        RadioGroup from = root.findViewById(R.id.from);
        RadioGroup to = root.findViewById(R.id.to);
        EditText input = root.findViewById(R.id.input);
        TextView result = root.findViewById(R.id.result);

        double inputVal = Double.parseDouble(input.getText().toString());

        switch (from.getCheckedRadioButtonId()){
            case R.id.fromUSD:
                switch (to.getCheckedRadioButtonId()){
                    case R.id.toCAD:
                        result.setText(Double.toString(inputVal * 1.24));
                        break;
                    case R.id.toEUR:
                        result.setText(Double.toString(inputVal * 0.83));
                        break;
                }
                break;
        }
    }
}
