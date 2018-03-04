package com.example.gkr.myapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gkr.myapplication.BaseActivity;
import com.example.gkr.myapplication.R;

public class BroadCastActivity extends BaseActivity{

    private TextView broadcast_events;
    private String broadcast_event_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_broadcast);

        Bundle extras = getIntent().getExtras();
        broadcast_event_text = "No Broadcast event recevied";
        if (extras != null) {
            broadcast_event_text = extras.getString("broadcast_event_info");
        }

        bindViews();

        

    }


    private void bindViews() {
        broadcast_events = findViewById(R.id.broadcast_events);
        broadcast_events.setText(broadcast_event_text);
    }

}

