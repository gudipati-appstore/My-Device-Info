package com.example.gkr.myapplication.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

/**
 * Created by kondareddygudipati on 1/14/18.
 */

class MyDialogFragment : DialogFragment() {

    private var dialog_title: String? = null
    private var dialog_body: String? = null
    private var positive_button_title: String? = null
    private var negative_button_title: String? = null
    private var neutral_button_title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null || arguments != null) {
            dialog_title = savedInstanceState?.getString("dialog_title")
            dialog_body = savedInstanceState?.getString("dialog_body")
            positive_button_title = savedInstanceState?.getString("positive_button_title")
            negative_button_title = savedInstanceState?.getString("negative_button_title")
            neutral_button_title = savedInstanceState?.getString("neutral_button_title")
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = AlertDialog.Builder(activity!!)
        dialog.setCancelable(true)
        dialog.setTitle(dialog_title)
        dialog.setMessage(dialog_body)
        dialog.setNeutralButton(neutral_button_title) { dialog, which -> dialog.dismiss() }
        return dialog.create()
    }

    companion object {


        fun newInstance(bundle: Bundle): MyDialogFragment {
            val detailedFragment = MyDialogFragment()
            detailedFragment.arguments = bundle
            return detailedFragment

        }
    }
}
