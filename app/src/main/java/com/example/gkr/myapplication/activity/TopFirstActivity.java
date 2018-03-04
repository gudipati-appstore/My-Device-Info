package com.example.gkr.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gkr.myapplication.BaseActivity;
import com.example.gkr.myapplication.R;

public class TopFirstActivity extends BaseActivity{

    private Button button_about_receivers;
    private Button button_about_devices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_topfirst);

        bindViews();
        bindEvents();
        

    }

    private void bindEvents() {
        button_about_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDeviceListPage();
            }
        });

        button_about_receivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBroadCastPage();

            }
        });
    }

    private void bindViews() {
        button_about_devices =  findViewById(R.id.button_about_devices);
        button_about_receivers = findViewById(R.id.button_about_receivers);
    }

    private void gotoDeviceListPage(){
        startActivity(new Intent(this, MainActivity.class));
    }

    private void gotoBroadCastPage(){
        startActivity(new Intent(this, BroadCastActivity.class));
    }

}

