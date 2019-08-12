package com.example.gkr.myapplication.activity

import android.os.Bundle
import android.widget.TextView

import com.example.gkr.myapplication.BaseActivity
import com.example.gkr.myapplication.R

class BroadCastActivity : BaseActivity() {

    private var broadcast_events: TextView? = null
    private var broadcast_event_text: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_broadcast)

        val extras = intent.extras
        broadcast_event_text = "No Broadcast event recevied"
        if (extras != null) {
            broadcast_event_text = extras.getString("broadcast_event_info")
        }

        bindViews()


    }


    private fun bindViews() {
        broadcast_events = findViewById(R.id.broadcast_events)
        broadcast_events!!.text = broadcast_event_text
    }

}

