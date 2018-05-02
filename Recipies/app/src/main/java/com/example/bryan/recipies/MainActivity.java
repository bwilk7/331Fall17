package com.example.bryan.recipies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecipeListener handler = new RecipeListener();
        CardView r1 = (CardView)findViewById(R.id.r1);
        r1.setOnClickListener(handler);

        CardView r2 = (CardView)findViewById(R.id.r2);
        r2.setOnClickListener(handler);

        CardView r3 = (CardView)findViewById(R.id.r3);
        r3.setOnClickListener(handler);
    }

    private class RecipeListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            CardView cv = (CardView)view;
            TextView tv = (TextView) cv.getChildAt(0);


        }
    }
}
