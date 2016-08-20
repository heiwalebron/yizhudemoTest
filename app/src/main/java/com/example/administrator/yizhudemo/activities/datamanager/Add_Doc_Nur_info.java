package com.example.administrator.yizhudemo.activities.datamanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.db.MySupportDB;
import com.example.administrator.yizhudemo.tools.Utils;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class Add_Doc_Nur_info extends AppCompatActivity implements View.OnClickListener {
    EditText name,
            mobile,
            job_history,
            desc;
    Spinner gender,
            occupation,
            department,
            education;
    Button btn_left1,
            btn_save;

    MySupportDB mySupportDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doc_nur_new_info);

        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        job_history=(EditText)findViewById(R.id.job_history);
        desc=(EditText)findViewById(R.id.desc);

        gender=(Spinner)findViewById(R.id.gender);
        occupation=(Spinner)findViewById(R.id.occupation);
        department=(Spinner)findViewById(R.id.department);
        education=(Spinner)findViewById(R.id.education);

        ArrayAdapter<CharSequence> adaptergender=  ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapteroccup=  ArrayAdapter.createFromResource(this, R.array.occupation, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterdepart=  ArrayAdapter.createFromResource(this, R.array.department, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapteredu=  ArrayAdapter.createFromResource(this, R.array.education, android.R.layout.simple_spinner_item);

        adaptergender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapteroccup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterdepart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapteredu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gender.setAdapter(adaptergender);
        occupation.setAdapter(adapteroccup);
        department.setAdapter(adapterdepart);
        education.setAdapter(adapteredu);



        btn_left1=(Button)findViewById(R.id.btn_left1);
        btn_save=(Button)findViewById(R.id.btn_save);

        btn_left1.setOnClickListener(this);
        btn_save.setOnClickListener(this);

        mySupportDB=new MySupportDB(this);//new对象实例化，否则会出现空指针状况；

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_left1:
                /*startActivity(new Intent(this,Doc_Nur_Main.class));
                finish();*/
                Utils.finish(this);


                break;



            case R.id.btn_save:


                String empName=name.getText().toString();
                String empMobile=mobile.getText().toString();
                String empJob_History=job_history.getText().toString();
                String empDesc=desc.getText().toString();
                String empGender = gender.getSelectedItem().toString();
                String empOccup = occupation.getSelectedItem().toString();
                String empDepart = department.getSelectedItem().toString();
                String empEdu = education.getSelectedItem().toString();


                if (empName.isEmpty()||empMobile.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill the empty field.", Toast.LENGTH_LONG).show();
                }else
                {
                    boolean b =mySupportDB.saveDoc_Nur_info(empName,empGender,empOccup,empDepart,empMobile,
                            empJob_History,empEdu,empDesc);
                    if (b) {
                        Toast.makeText(getApplicationContext(), "Data inserted successfully.", Toast.LENGTH_LONG).show();
                       /* startActivity(new Intent(this,Doc_Nur_Main.class));
                        finish();*/
                    } else {
                        Toast.makeText(getApplicationContext(), "Not successful!", Toast.LENGTH_LONG).show();
                    }
                }






                break;
        }






    }
}
