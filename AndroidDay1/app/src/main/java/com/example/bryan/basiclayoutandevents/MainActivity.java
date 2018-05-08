package com.example.bryan.basiclayoutandevents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button strikeButton = (Button) findViewById(R.id.strike);
        strikeButton.setOnClickListener(new StrikeListener());


    }

}
