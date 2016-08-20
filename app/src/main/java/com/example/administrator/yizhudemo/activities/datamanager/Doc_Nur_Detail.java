package com.example.administrator.yizhudemo.activities.datamanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yizhudemo.R;
import com.example.administrator.yizhudemo.db.MySupportDB;
import com.example.administrator.yizhudemo.tools.Utils;

import java.util.List;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class Doc_Nur_Detail extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;

    TextView name,
            gender,
            occupation,
            department,
            mobile,
            job_history,
            education,
            description;
    Button  edit,
            button_cancel,
            button_delete,
            button_update;
    EditText name_update,
            mobile_update,
            job_history_update,
            desc_update;
    Spinner gender_update,
            occupation_update,
            department_update,
            education_update;
    LinearLayout linearLayout_info,
                 linearLayout_update;
    String idFromListItem;
    MySupportDB mySupportDB;
    List<String> doc_nur_data;
    String id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_nur_detail);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("医护人员详细资料");




        name=(TextView)findViewById(R.id.name);
        gender=(TextView)findViewById(R.id.gender);
        occupation=(TextView)findViewById(R.id.occupation);
        department=(TextView)findViewById(R.id.department);
        mobile=(TextView)findViewById(R.id.mobile);
        job_history=(TextView)findViewById(R.id.job_history);
        education=(TextView)findViewById(R.id.education);
        description=(TextView)findViewById(R.id.description);

        edit=(Button)findViewById(R.id.edit);
        button_cancel=(Button)findViewById(R.id.button_cancel);
        button_delete=(Button)findViewById(R.id.button_delete);
        button_update=(Button)findViewById(R.id.button_update);

        name_update=(EditText)findViewById(R.id.name_update);
        mobile_update=(EditText)findViewById(R.id.mobile_update);
        job_history_update=(EditText)findViewById(R.id.job_history_update);
        desc_update=(EditText)findViewById(R.id.desc_update);

        linearLayout_info = (LinearLayout) findViewById(R.id.linearLayout_info);
        linearLayout_update = (LinearLayout) findViewById(R.id.linearLayout_update);


        gender_update=(Spinner)findViewById(R.id.gender_update);
        occupation_update=(Spinner)findViewById(R.id.occupation_update);
        department_update=(Spinner)findViewById(R.id.department_update);
        education_update=(Spinner)findViewById(R.id.education_update);


        // spinner load
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adaptergender=  ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapteroccup=  ArrayAdapter.createFromResource(this, R.array.occupation, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterdepart=  ArrayAdapter.createFromResource(this, R.array.department, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapteredu=  ArrayAdapter.createFromResource(this, R.array.education, android.R.layout.simple_spinner_item);


        // Specify the layout to use when the list of choices appears
        adaptergender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapteroccup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterdepart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapteredu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        gender_update.setAdapter(adaptergender);
        occupation_update.setAdapter(adapteroccup);
        department_update.setAdapter(adapterdepart);
        education_update.setAdapter(adapteredu);



        // while opening the activity edit/update part of layout will be visibility GONE
        linearLayout_update.setVisibility(View.GONE);
        edit.setOnClickListener(this);
        button_cancel.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_update.setOnClickListener(this);


        mySupportDB=new MySupportDB(this);
        idFromListItem = getIntent().getStringExtra(Doc_Nur_Main.EXTRA_MESSAGE2);
        List<String> employeeAllData = mySupportDB.getAllDoc_NurData(idFromListItem);

        // set data on textView
        doc_nur_data=employeeAllData;
        name.setText(doc_nur_data.get(1));
        gender.setText(doc_nur_data.get(2));
        occupation.setText(doc_nur_data.get(3));
        department.setText(doc_nur_data.get(4));
        mobile.setText(doc_nur_data.get(5));
        job_history.setText(doc_nur_data.get(6));
        education.setText(doc_nur_data.get(7));
        description.setText(doc_nur_data.get(8));



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit:
                linearLayout_info.setVisibility(View.GONE);
                linearLayout_update.setVisibility(View.VISIBLE);

                // set data to edit text
                name_update.setText(name.getText().toString());
                gender_update.setSelection(((ArrayAdapter) gender_update.getAdapter()).getPosition(gender.getText().toString()));
                mobile_update.setText(mobile.getText().toString());
                occupation_update.setSelection(((ArrayAdapter) occupation_update.getAdapter()).getPosition(occupation.getText().toString()));
                job_history_update.setText(job_history.getText().toString());
                department_update.setSelection(((ArrayAdapter) department_update.getAdapter()).getPosition(department.getText().toString()));
                education_update.setSelection(((ArrayAdapter) education_update.getAdapter()).getPosition(education.getText().toString()));
                desc_update.setText(description.getText().toString());

                break;

            case R.id.button_delete:

                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setMessage("Are you sure that you want to delete " + name_update.getText().toString() + " from the database?");
                b.setNegativeButton("No", null);
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long confirmDelete = mySupportDB.deleteDoc_Nur(idFromListItem);
                        Toast.makeText(getApplicationContext(), "Deleted! " + confirmDelete + "row affected", Toast.LENGTH_LONG).show();
                    }
                });
                b.setCancelable(true);
                b.create().show();


                break;

            case R.id.button_update:
                String empName=name_update.getText().toString();
                String empGender=gender_update.getSelectedItem().toString();
                String empMobile=mobile_update.getText().toString();
                String empOccup=occupation_update.getSelectedItem().toString();
                String empDepart=department_update.getSelectedItem().toString();
                String empJob_History=job_history_update.getText().toString();
                String empEdu=education_update.getSelectedItem().toString();
                String empDesc=desc_update.getText().toString();
                if (empName.isEmpty() || empMobile.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill the empty field.", Toast.LENGTH_LONG).show();
                }else{
                    String[] convertId = {idFromListItem};
                    long rowAffected = mySupportDB.updateDoc_Nur(convertId, empName, empGender, empMobile, empOccup, empDepart,
                            empJob_History, empEdu, empDesc);

                    if (rowAffected > 0) {
                        Toast.makeText(getApplicationContext(), "Done! " + rowAffected + " Row Affected.", Toast.LENGTH_LONG).show();
                        ;linearLayout_info.setVisibility(View.VISIBLE);
                        linearLayout_update.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(getApplicationContext(), "Not Done! " + rowAffected + " Row Affected.", Toast.LENGTH_LONG).show();
                    }
                }


                    break;
            case R.id.button_cancel:
                linearLayout_info.setVisibility(View.VISIBLE);
                linearLayout_update.setVisibility(View.GONE);

                break;


        }
    }
}
