package com.example.datamahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String MHS_TABLE_NAME = "mahasiswa";
    public static final String MHS_COLUMN_ID = "id";
    public static final String MHS_COLUMN_NIM = "nim";
    public static final String MHS_COLUMN_NAMA = "nama";
    public static final String MHS_COLUMN_PHONE = "phone";
    private HashMap hp;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO Auto-generated method stub
        db.execSQL("create table mahasiswa" +
                "(id integer primary key, nim text, nama text, phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO Auto-generated method stub
        db.execSQL("drop table if exists mahasiswa");
        onCreate(db);
    }
}