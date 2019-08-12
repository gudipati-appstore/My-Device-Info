package com.example.gkr.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

import com.example.gkr.myapplication.BaseActivity
import com.example.gkr.myapplication.R

class TopFirstActivity : BaseActivity() {

    private var button_about_receivers: Button? = null
    private var button_about_devices: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_topfirst)

        bindViews()
        bindEvents()


    }

    private fun bindEvents() {
        button_about_devices!!.setOnClickListener { gotoDeviceListPage() }

        button_about_receivers!!.setOnClickListener { gotoBroadCastPage() }
    }

    private fun bindViews() {
        button_about_devices = findViewById(R.id.button_about_devices)
        button_about_receivers = findViewById(R.id.button_about_receivers)
    }

    private fun gotoDeviceListPage() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun gotoBroadCastPage() {
        startActivity(Intent(this, BroadCastActivity::class.java))
    }

}

