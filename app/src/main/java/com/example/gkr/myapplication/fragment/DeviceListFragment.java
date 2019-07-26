package com.example.gkr.myapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gkr.myapplication.R;

import org.apache.commons.lang3.StringUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceListFragment extends Fragment {

    public static String TAG = DeviceListFragment.class.getName();

    private Button button_about_mobile;
    private Button button_about_latop;
    private Button button_about_hardcase;
    private Button button_about_monitor;
    private Button button_about_tv;
    private Button button_about_amazon_firetv;

    private String deviceParam;
    private OnDeviceItemSelectListener onDeviceItemSelectListener;

    public DeviceListFragment() {
        //Empty Constructor for Fragment
    }

    public static DeviceListFragment newInstance(String deviceParam) {
        DeviceListFragment detailedFragment = new DeviceListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("deviceParam", deviceParam);
        detailedFragment.setArguments(bundle);
        return detailedFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnDeviceItemSelectListener) {
            onDeviceItemSelectListener = (OnDeviceItemSelectListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && StringUtils.isNotBlank(savedInstanceState.getString("deviceParam"))) {
            deviceParam = savedInstanceState.getString("deviceParam");
        } else if (null != getArguments()) {
            deviceParam = getArguments().getString("deviceParam");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        View rootView = inflater.inflate(R.layout.fragment_device_list, container, false);

        bindViews(rootView);
        bindEvents();

        return rootView;
    }

    private void bindEvents() {
        button_about_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeviceItemSelectListener.onDeviceSelected("1");
            }
        });

        button_about_latop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeviceItemSelectListener.onDeviceSelected("2");
            }
        });

        button_about_hardcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeviceItemSelectListener.onDeviceSelected("3");
            }
        });

        button_about_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeviceItemSelectListener.onDeviceSelected("4");
            }
        });
        button_about_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeviceItemSelectListener.onDeviceSelected("5");
            }
        });
        button_about_amazon_firetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeviceItemSelectListener.onDeviceSelected("6");
            }
        });
    }

    private void bindViews(View rootView) {
        button_about_mobile = rootView.findViewById(R.id.button_about_mobile);
        button_about_latop = rootView.findViewById(R.id.button_about_latop);
        button_about_hardcase = rootView.findViewById(R.id.button_about_hardcase);
        button_about_monitor = rootView.findViewById(R.id.button_about_monitor);
        button_about_tv = rootView.findViewById(R.id.button_about_tv);
        button_about_amazon_firetv = rootView.findViewById(R.id.button_about_amazon_firetv);

        if (StringUtils.isNotBlank(deviceParam)) {
            if (deviceParam.contains("1")) {
                button_about_mobile.setEnabled(false);
                button_about_mobile.setAlpha(0.5f);
            } else if (deviceParam.contains("2")) {
                button_about_latop.setEnabled(false);
                button_about_latop.setAlpha(0.5f);
            } else if (deviceParam.contains("3")) {
                button_about_hardcase.setEnabled(false);
                button_about_hardcase.setAlpha(0.5f);
            } else if (deviceParam.contains("4")) {
                button_about_monitor.setEnabled(false);
                button_about_monitor.setAlpha(0.5f);
            } else if (deviceParam.contains("5")) {
                button_about_tv.setEnabled(false);
                button_about_tv.setAlpha(0.5f);
            } else if (deviceParam.contains("6")) {
                button_about_amazon_firetv.setEnabled(false);
                button_about_amazon_firetv.setAlpha(0.5f);
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("deviceParam", deviceParam);
        super.onSaveInstanceState(outState);
    }

    public interface OnDeviceItemSelectListener {
        void onDeviceSelected(String deviceName);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
}
