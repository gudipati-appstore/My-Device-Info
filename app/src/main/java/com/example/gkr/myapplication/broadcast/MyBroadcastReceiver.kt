package com.example.gkr.myapplication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.Bundle

import com.example.gkr.myapplication.activity.BroadCastActivity

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action!!.matches(LocationManager.PROVIDERS_CHANGED_ACTION.toRegex())) {
            handleIntent(context, "Location has Changed")
        } else if (null != intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO)) {
            val info = intent.getParcelableExtra<NetworkInfo>(WifiManager.EXTRA_NETWORK_INFO)
            if (info!!.isConnected) {
                // Do your work.
                handleIntent(context, "Wifi is connected")
                // e.g. To check the Network Name or other info:
                /* WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ssid = wifiInfo.getSSID();*/
            } else {
                handleIntent(context, "Wifi is not connected")
            }
        } else {
            val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL

            val chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            val usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

            if (isCharging) {
                if (usbCharge) {
                    handleIntent(context, "Battery is Charging with usb cable")
                } else if (acCharge) {
                    handleIntent(context, "Battery is Charging with power adapter")
                }
            } else {
                handleIntent(context, "Battery is not Charging")
            }


        }

    }

    private fun handleIntent(context: Context, message: String) {

        //TODO Do not start activities from Broadcast receiver
        val pushIntent = Intent(context, BroadCastActivity::class.java)
        val bundle = Bundle()
        bundle.putString("broadcast_event_info", message)
        pushIntent.putExtras(bundle)
        pushIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(pushIntent)
    }
}
