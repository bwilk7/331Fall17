package com.example.bryan.basiclayoutandevents;

import android.view.View;
import android.widget.TextView;

class StrikeListener implements View.OnClickListener {
    private int strikes ;

    public StrikeListener(){
        strikes = 0;
    }

    @Override
    public void onClick(View view) {
        View root = view.getRootView();
        TextView strikesView  = (TextView)root.findViewById(R.id.strikeNum);
        strikes += 1;

        strikesView.setText(Integer.toString(strikes));
    }
}
