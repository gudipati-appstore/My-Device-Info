package com.example.gkr.myapplication;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.gkr.myapplication.fragment.DetailedFragment;
import com.example.gkr.myapplication.fragment.DeviceListFragment;
import com.example.gkr.myapplication.fragment.MyDialogFragment;

public class MainActivity extends AppCompatActivity implements DeviceListFragment.OnDeviceItemSelectListener, DetailedFragment.OnDetailFragmentEventListener {

    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setCustomHeaderView();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DeviceListFragment.newInstance(null), "device_list_fragment").commit();
        }
    }

    private void setCustomHeaderView() {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setCustomView(R.layout.title_bar);

            getSupportActionBar().getCustomView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialogBox();
                }
            });
        }
    }


    @Override
    public void onDeviceSelected(String deviceName) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DetailedFragment.newInstance(deviceName), "detail_fragment").commit();
    }

    @Override
    public void onBackButtonClicked(String deviceParam) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DeviceListFragment.newInstance(deviceParam), "device_list_fragment").commit();
    }

    private void showDialogBox() {
        getFragmentManager().beginTransaction().add(new MyDialogFragment(), "dialog").commit();
    }
}

