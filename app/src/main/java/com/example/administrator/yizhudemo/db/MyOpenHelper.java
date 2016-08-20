package com.example.administrator.yizhudemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    /*
   *Doctor、Nurse表建表语句
   */
    public  static final String CREATE_DOC_NUR="create table doc_nur (" +
            "_id integer primary key autoincrement," +
            "name text,gender text,occupation text,department text," +
            "mobile text,job_history text,education text," +
            "description text)";

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOC_NUR);//创建医护表

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
