package com.example.gkr.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog

import com.example.gkr.myapplication.BaseActivity
import com.example.gkr.myapplication.R
import com.example.gkr.myapplication.fragment.DetailedFragment
import com.example.gkr.myapplication.fragment.DeviceListFragment

class MainActivity : BaseActivity(), DeviceListFragment.OnDeviceItemSelectListener, DetailedFragment.OnDetailFragmentEventListener {

    private val dialog: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DeviceListFragment.newInstance(null), "device_list_fragment").commit()
        }
    }


    override fun onDeviceSelected(deviceName: String) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DetailedFragment.newInstance(deviceName), "detail_fragment").commit()
    }

    override fun onBackButtonClicked(deviceParam: String?) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DeviceListFragment.newInstance(deviceParam), "device_list_fragment").commit()
    }

}

