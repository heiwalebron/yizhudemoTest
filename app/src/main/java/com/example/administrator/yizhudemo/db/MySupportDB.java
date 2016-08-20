package com.example.administrator.yizhudemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class MySupportDB {
    /*
    * 数据库名
    * */
    public static final String DB_NAME="doctorsys.db";
    /*
    * 数据库版本
    * */
    public static final int VERSION=1;
    private static MySupportDB mySupportDB;
    private SQLiteDatabase db;
    private Context context;
    long insert, delete;

    /*
    * 将构造方法私有化
    * */
    public MySupportDB(Context context){
        this.context=context;
        MyOpenHelper dbHelper=new MyOpenHelper(context,DB_NAME,null,VERSION);
        db=dbHelper.getWritableDatabase();
    }
    /*
   *保存医护人员信息实例
   *
   */
    public boolean saveDoc_Nur_info(String empName, String empGender,String empOccup,
                                    String empDepart,String empMobile,
                                    String empJob_History, String empEdu,
                                    String empDesc){
        ContentValues values = new ContentValues();
        values.put("name", empName);
        values.put("gender", empGender);
        values.put("occupation", empOccup);
        values.put("department", empDepart);
        values.put("mobile", empMobile);
        values.put("job_history", empJob_History);
        values.put("education", empEdu);
        values.put("description", empDesc);


        insert = db.insert("doc_nur", null, values);



        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }
    /*
    *遍历医护人员信息
    */
    public List<String> getAllDoc_NurData(String id) {
        List<String> emp = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + "doc_nur" + " WHERE " + "_id" + " = '" + id + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                emp.add(cursor.getString(0)); //id
                emp.add(cursor.getString(1)); //name
                emp.add(cursor.getString(2)); //gender
                emp.add(cursor.getString(3)); //occup
                emp.add(cursor.getString(4)); //department
                emp.add(cursor.getString(5)); //mobile
                emp.add(cursor.getString(6)); //job_history
                emp.add(cursor.getString(7)); //education
                emp.add(cursor.getString(8)); //desc
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();


        // returning labels
        return emp;
    }
    /*
    * 遍历id/ name /mobile
    * */
    public List<String> getAllName_Mobile(){
        List<String> doc_NurIdName = new ArrayList<String>();
        String selectQuery = "select * from doc_nur";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                doc_NurIdName.add(cursor.getString(0));//id
                doc_NurIdName.add(cursor.getString(1));//name
                doc_NurIdName.add(cursor.getString(5));//mobile

            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();


        // returning labels
        return doc_NurIdName;

    }

    /*
    * 删除医护信息
    * */

    public long deleteDoc_Nur(String employeeId) {


        String[] convert = {employeeId};
        //  Inserting Row
        delete = db.delete("doc_nur", "_id" + " LIKE ?", convert);

        //db.close();


        return delete;
    }

    /*
     * 更新医护人员信息
     * */
    public long updateDoc_Nur(String[] id,String empName, String empGender,String empOccup,
                              String empDepart,String empMobile,
                              String empJob_History, String empEdu,
                              String empDesc) {
        ContentValues values = new ContentValues();
        values.put("name", empName);
        values.put("gender", empGender);
        values.put("occupation", empOccup);
        values.put("department", empDepart);
        values.put("mobile", empMobile);
        values.put("job_history", empJob_History);
        values.put("education", empEdu);
        values.put("description", empDesc);

        //  Update
        long rowAffected = db.update("doc_nur", values, "_id" + " LIKE ?", id);


        //db.close();

        return rowAffected;

    }





}
