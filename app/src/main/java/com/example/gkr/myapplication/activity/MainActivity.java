package com.example.gkr.myapplication.activity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

import com.example.gkr.myapplication.BaseActivity;
import com.example.gkr.myapplication.R;
import com.example.gkr.myapplication.fragment.DetailedFragment;
import com.example.gkr.myapplication.fragment.DeviceListFragment;

public class MainActivity extends BaseActivity implements DeviceListFragment.OnDeviceItemSelectListener, DetailedFragment.OnDetailFragmentEventListener {

    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DeviceListFragment.newInstance(null), "device_list_fragment").commit();
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

}

