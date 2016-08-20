package com.example.administrator.yizhudemo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.tools.Utils;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView img_back;
    private TextView txt_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        img_back=(ImageView)findViewById(R.id.img_back);
        txt_title=(TextView)findViewById(R.id.txt_title);

        img_back.setVisibility(View.VISIBLE);
        txt_title.setText("设置");
        img_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                Utils.finish(SettingActivity.this);
                break;
        }
    }
}
