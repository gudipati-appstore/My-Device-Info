package com.example.gkr.myapplication

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.gkr.myapplication.fragment.MyDialogFragment

open class BaseActivity : AppCompatActivity() {

    private val dialog: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCustomHeaderView()
        // checkin 1

    }

    private fun setCustomHeaderView() {

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowCustomEnabled(true)
            supportActionBar!!.setCustomView(R.layout.title_bar)

            supportActionBar!!.customView.setOnClickListener { showDialogBox() }
        }
    }

    private fun showDialogBox() {
        val savedInstanceState = Bundle()
        savedInstanceState.putString("dialog_title", "About App")
        savedInstanceState.putString("dialog_body", "Hello.. Welcome to my App. Hope you like it..!")
        savedInstanceState.putString("positive_button_title", null)
        savedInstanceState.putString("negative_button_title", null)
        savedInstanceState.putString("neutral_button_title", "Okay")
        supportFragmentManager.beginTransaction().add(MyDialogFragment.newInstance(savedInstanceState), "dialog").commit()
    }
}

