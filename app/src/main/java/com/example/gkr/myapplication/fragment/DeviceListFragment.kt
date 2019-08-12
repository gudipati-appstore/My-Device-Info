package com.example.gkr.myapplication.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.gkr.myapplication.R

import org.apache.commons.lang3.StringUtils

/**
 * A simple [Fragment] subclass.
 */
class DeviceListFragment : Fragment() {

    private var button_about_mobile: Button? = null
    private var button_about_latop: Button? = null
    private var button_about_hardcase: Button? = null
    private var button_about_monitor: Button? = null
    private var button_about_tv: Button? = null
    private var button_about_amazon_firetv: Button? = null

    private var deviceParam: String? = null
    private var onDeviceItemSelectListener: OnDeviceItemSelectListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnDeviceItemSelectListener) {
            onDeviceItemSelectListener = context
        }
    }

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

        val rootView = inflater.inflate(R.layout.fragment_device_list, container, false)

        bindViews(rootView)
        bindEvents()

        return rootView
    }

    private fun bindEvents() {
        button_about_mobile!!.setOnClickListener { onDeviceItemSelectListener!!.onDeviceSelected("1") }

        button_about_latop!!.setOnClickListener { onDeviceItemSelectListener!!.onDeviceSelected("2") }

        button_about_hardcase!!.setOnClickListener { onDeviceItemSelectListener!!.onDeviceSelected("3") }

        button_about_monitor!!.setOnClickListener { onDeviceItemSelectListener!!.onDeviceSelected("4") }
        button_about_tv!!.setOnClickListener { onDeviceItemSelectListener!!.onDeviceSelected("5") }
        button_about_amazon_firetv!!.setOnClickListener { onDeviceItemSelectListener!!.onDeviceSelected("6") }
    }

    private fun bindViews(rootView: View) {
        button_about_mobile = rootView.findViewById(R.id.button_about_mobile)
        button_about_latop = rootView.findViewById(R.id.button_about_latop)
        button_about_hardcase = rootView.findViewById(R.id.button_about_hardcase)
        button_about_monitor = rootView.findViewById(R.id.button_about_monitor)
        button_about_tv = rootView.findViewById(R.id.button_about_tv)
        button_about_amazon_firetv = rootView.findViewById(R.id.button_about_amazon_firetv)

        if (StringUtils.isNotBlank(deviceParam)) {
            if (deviceParam!!.contains("1")) {
                button_about_mobile!!.isEnabled = false
                button_about_mobile!!.alpha = 0.5f
            } else if (deviceParam!!.contains("2")) {
                button_about_latop!!.isEnabled = false
                button_about_latop!!.alpha = 0.5f
            } else if (deviceParam!!.contains("3")) {
                button_about_hardcase!!.isEnabled = false
                button_about_hardcase!!.alpha = 0.5f
            } else if (deviceParam!!.contains("4")) {
                button_about_monitor!!.isEnabled = false
                button_about_monitor!!.alpha = 0.5f
            } else if (deviceParam!!.contains("5")) {
                button_about_tv!!.isEnabled = false
                button_about_tv!!.alpha = 0.5f
            } else if (deviceParam!!.contains("6")) {
                button_about_amazon_firetv!!.isEnabled = false
                button_about_amazon_firetv!!.alpha = 0.5f
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("deviceParam", deviceParam)
        super.onSaveInstanceState(outState)
    }

    interface OnDeviceItemSelectListener {
        fun onDeviceSelected(deviceName: String)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    companion object {

        var TAG = DeviceListFragment::class.java.name

        fun newInstance(deviceParam: String? = null): DeviceListFragment {
            val detailedFragment = DeviceListFragment()
            val bundle = Bundle()
            bundle.putString("deviceParam", deviceParam)
            detailedFragment.arguments = bundle
            return detailedFragment
        }
    }
}//Empty Constructor for Fragment
