package com.example.gkr.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.gkr.myapplication.fragment.MyDialogFragment;

public class BaseActivity extends AppCompatActivity{

    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomHeaderView();

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

    private void showDialogBox() {
        Bundle savedInstanceState = new Bundle();
        savedInstanceState.putString("dialog_title", "About App");
        savedInstanceState.putString("dialog_body", "Hello.. Welcome to my App. Hope you like it..!");
        savedInstanceState.putString("positive_button_title", null);
        savedInstanceState.putString("negative_button_title", null);
        savedInstanceState.putString("neutral_button_title", "Okay");
        getFragmentManager().beginTransaction().add(MyDialogFragment.newInstance(savedInstanceState), "dialog").commit();
    }
}

