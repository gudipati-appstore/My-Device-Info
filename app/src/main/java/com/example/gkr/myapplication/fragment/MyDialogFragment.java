package com.example.gkr.myapplication.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

/**
 * Created by kondareddygudipati on 1/14/18.
 */

public class MyDialogFragment extends DialogFragment {

    private String dialog_title;
    private String dialog_body;
    private String positive_button_title;
    private String negative_button_title;
    private String neutral_button_title;


    public static MyDialogFragment newInstance(Bundle bundle) {
        MyDialogFragment detailedFragment = new MyDialogFragment();
        detailedFragment.setArguments(bundle);
        return detailedFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null || getArguments() != null) {
            if(getArguments() != null){
                savedInstanceState = getArguments();
            }
            dialog_title = savedInstanceState.getString("dialog_title");
            dialog_body = savedInstanceState.getString("dialog_body");
            positive_button_title = savedInstanceState.getString("positive_button_title");
            negative_button_title = savedInstanceState.getString("negative_button_title");
            neutral_button_title = savedInstanceState.getString("neutral_button_title");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setCancelable(true);
        dialog.setTitle(dialog_title);
        dialog.setMessage(dialog_body);
        dialog.setNeutralButton(neutral_button_title, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return dialog.create();
    }
}
