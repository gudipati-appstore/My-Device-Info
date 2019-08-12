package com.example.gkr.myapplication.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.gkr.myapplication.R

import org.apache.commons.lang3.StringUtils


/**
 * A simple [Fragment] subclass.
 */
class DetailedFragment : Fragment() {

    private var textview_about_info: TextView? = null
    private var goback: Button? = null
    private var deviceParam: String? = null
    private var onDetailFragmentEventListener: OnDetailFragmentEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null && StringUtils.isNotBlank(savedInstanceState.getString("deviceParam"))) {
            deviceParam = savedInstanceState.getString("deviceParam")
        } else if (null != arguments) {
            deviceParam = arguments!!.getString("deviceParam")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (container == null) {
            return null
        }
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)
        bindViews(rootView, savedInstanceState)
        bindEvents()
        return rootView
    }

    private fun bindEvents() {

        goback!!.setOnClickListener { onDetailFragmentEventListener!!.onBackButtonClicked(deviceParam) }

    }

    private fun bindViews(rootView: View, savedInstanceState: Bundle?) {
        textview_about_info = rootView.findViewById(R.id.textview_about_info)
        goback = rootView.findViewById(R.id.goback)

        if (savedInstanceState != null && StringUtils.isNotBlank(savedInstanceState.getString("deviceParam"))) {
            deviceParam = savedInstanceState.getString("deviceParam")
        }

        if (StringUtils.isNotBlank(deviceParam)) {
            if (deviceParam!!.contains("1")) {
                textview_about_info!!.text = "hey you have chosen Mobile"
            } else if (deviceParam!!.contains("2")) {
                textview_about_info!!.text = "hey you have chosen Laptop"
            } else if (deviceParam!!.contains("3")) {
                textview_about_info!!.text = "hey you have chosen Hardcase"
            } else if (deviceParam!!.contains("4")) {
                textview_about_info!!.text = "hey you have chosen Monitor"
            } else if (deviceParam!!.contains("5")) {
                textview_about_info!!.text = "hey you have chosen Tv"
            } else if (deviceParam!!.contains("6")) {
                textview_about_info!!.text = "hey you have chosen FireTV"
            }
        }

        textview_about_info!!.append("\n\n\n" + resources.getText(R.string.extra_text))
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnDetailFragmentEventListener) {
            onDetailFragmentEventListener = context
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("deviceParam", deviceParam)
        super.onSaveInstanceState(outState)
    }

    interface OnDetailFragmentEventListener {
        fun onBackButtonClicked(deviceParam: String?)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    companion object {

        var TAG = DetailedFragment::class.java!!.getName()

        fun newInstance(deviceParam: String): DetailedFragment {
            val detailedFragment = DetailedFragment()

            val bundle = Bundle()
            bundle.putString("deviceParam", deviceParam)
            detailedFragment.arguments = bundle

            return detailedFragment

        }
    }
}//Empty Constructor for Fragment
