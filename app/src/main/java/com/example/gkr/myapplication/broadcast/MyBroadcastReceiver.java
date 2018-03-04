package com.example.gkr.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;

import com.example.gkr.myapplication.activity.BroadCastActivity;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches(LocationManager.PROVIDERS_CHANGED_ACTION)) {
            handleIntent(context, "Location has Changed");
        } else if (null != intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO)){
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if(info.isConnected()) {
                // Do your work.
                handleIntent(context, "Wifi is connected");
                // e.g. To check the Network Name or other info:
               /* WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ssid = wifiInfo.getSSID();*/
            } else {
                handleIntent(context, "Wifi is not connected");
            }
        } else {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL);

            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

            if(isCharging){
                if(usbCharge){
                    handleIntent(context, "Battery is Charging with usb cable");
                } else if(acCharge){
                    handleIntent(context, "Battery is Charging with power adapter");
                }
            } else {
                handleIntent(context, "Battery is not Charging");
            }


        }

    }

    private void handleIntent(Context context, String message){

        //TODO Do not start activities from Broadcast receiver
        Intent pushIntent = new Intent(context, BroadCastActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("broadcast_event_info", message);
        pushIntent.putExtras(bundle);
        pushIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(pushIntent);
    }
}
