package com.example.administrator.yizhudemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.activities.SettingActivity;
import com.example.administrator.yizhudemo.tools.Utils;

/**
 * Created by Administrator on 2016/8/15/015.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {
    private TextView setting;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.more,container,false);

        setting=(TextView) view.findViewById(R.id.setting);
        setting.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting:
                Utils.start_Activity(getActivity(), SettingActivity.class);
                break;


        }

    }
}
