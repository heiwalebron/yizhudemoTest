package com.example.administrator.yizhudemo.activities.datamanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.adapters.Doc_NurAdapter;
import com.example.administrator.yizhudemo.db.MySupportDB;
import com.example.administrator.yizhudemo.tools.Utils;

import java.util.List;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class Doc_Nur_Main extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    ListView lv1;
    FloatingActionButton fab1;
    private MySupportDB mySupportDB;
    private Doc_NurAdapter doc_nurAdapter;

    public final static String EXTRA_MESSAGE = "com.touhidapps.myemployee.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "com.touhidapps.myemployee.MESSAGE2";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doc_nur_first);
        lv1=(ListView)findViewById(R.id.lv1);
        fab1=(FloatingActionButton)findViewById(R.id.fab1);

        mySupportDB=new MySupportDB(this);//实例化

        List<String> employeeData = mySupportDB.getAllName_Mobile();

        String[] id = new String[employeeData.size() / 3]; // divided how much data slot are coming, extra size will make unnecessary blank list items
        String[] name = new String[employeeData.size() / 3];
        String[] phone = new String[employeeData.size() / 3];

        boolean boolId = true,
                boolName = false,
                boolPhone = false;
        int intId = 0,
                intName = 0,
                intPhone = 0;

        for (int i = 0; i < employeeData.size(); i++) {

            if (boolId) {
                id[intId] = employeeData.get(i);
                intId++;
                boolId = false;
                boolName = true;
                boolPhone = false;
                continue;
            } else if (boolName) {
                name[intName] = employeeData.get(i);
                intName++;
                boolId = false;
                boolName = false;
                boolPhone = true;
                continue;
            } else if (boolPhone) {
                phone[intPhone] = employeeData.get(i);
                intPhone++;
                boolId = true;
                boolName = false;
                boolPhone = false;
//                continue;
            }

        }//取出id[]、name[]、phone[]

        doc_nurAdapter=new Doc_NurAdapter(this,id,name,phone);

        lv1.setAdapter(doc_nurAdapter);
        lv1.setOnItemClickListener(this);//listview显示记录
        fab1.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // get employee id from the listView item, (Kept hidden, don't need to show it on the list item)
        TextView empID = (TextView) view.findViewById(R.id.textView_list_item_id);
        String getEmpID = empID.getText().toString();
        Intent intent = new Intent(getApplicationContext(), Doc_Nur_Detail.class);
        intent.putExtra(EXTRA_MESSAGE2, getEmpID);

        startActivity(intent);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab1:
               // Utils.start_Activity(this,Add_Doc_Nur_info.class);
                Intent intent = new Intent(getApplicationContext(), Add_Doc_Nur_info.class);
                startActivity(intent);



                break;
        }
        
    }
}
