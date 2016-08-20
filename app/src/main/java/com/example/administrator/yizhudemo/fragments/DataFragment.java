package com.example.administrator.yizhudemo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.activities.datamanager.Doc_Nur_Main;
import com.example.administrator.yizhudemo.adapters.PictureAdapter;
import com.example.administrator.yizhudemo.tools.Utils;

/**
 * Created by Administrator on 2016/8/14/014.
 */
public class DataFragment extends Fragment implements AdapterView.OnItemClickListener {
    GridView gvInfo;// 创建GridView对象
    PictureAdapter adapter;
    String[] titles = new String[] { "患者信息", "医护信息", "医嘱信息", "护理等级", "药品名称",
            "历史患者信息", "菜单信息", "药品服用信息" };
    // 定义int数组，存储功能对应的图标
    int[] images = new int[] { R.drawable.ic_local_hotel_teal_500_48dp,
            R.drawable.ic_supervisor_account_teal_500_48dp,
            R.drawable.ic_contact_mail_teal_500_48dp,
            R.drawable.ic_grade_teal_500_48dp,
            R.drawable.ic_local_hospital_teal_500_48dp,
            R.drawable.ic_recent_actors_teal_500_48dp,
            R.drawable.ic_note_teal_500_48dp,
            R.drawable.ic_accessible_teal_500_48dp
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.data, container,false);

        gvInfo = (GridView) view.findViewById(R.id.gvInfo);
        adapter=new PictureAdapter(titles, images, getContext());
        gvInfo.setAdapter(adapter);// 为GridView设置数据源

        gvInfo.setOnItemClickListener(this);


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        switch (position){
            case 0:


                break;
            case 1:
                Utils.start_Activity(getActivity(), Doc_Nur_Main.class);


                break;
            case 2:



                break;
            case 3:




                break;

        }
    }
}
