package com.example.administrator.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MyDB extends SQLiteOpenHelper {
    private static String DB_NAME="My_DB.db";
    private static int DB_VERSION=2;
    private SQLiteDatabase db;
    public  MyDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        db= getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public SQLiteDatabase openConnection(){
        if(!db.isOpen()){
            db= getWritableDatabase();
        }
        return db;
    }
    public  void closeConnection(){
        if(db!=null&&db.isOpen()){
            db.close();
        }
    }
    public boolean creaTable(String createTableSql){
        try{
            openConnection();
            db.execSQL(createTableSql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
    public boolean delete(String table,String deleteSql,String obj[]){
       try{
        openConnection();
        db.delete(table,deleteSql,obj);
    }catch(Exception e){
           e.printStackTrace();
           return false;
       }finally {
    closeConnection();
       }
        return true;
       }
    public boolean save(String tableName,ContentValues values){
        try {
            openConnection();
            db.insert(tableName,null,values);
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }finally {
            closeConnection();
        }
        return true;
    }
    public boolean update(String table,ContentValues values,String whereCluase,String[] whereArgs){
        try{
            openConnection();
            db.update(table,values,whereCluase,whereArgs);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
    public Cursor find(String findsql,String obj[]){
        try{
            openConnection();
            Cursor cursor =db.rawQuery(findsql,obj);
            return cursor;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean isTableExists(String tablename){
        try{
            openConnection();
            String str="select count(*)xcount from"+tablename;
            db.rawQuery(str,null).close();
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }finally {
            closeConnection();
        }
        return  true;
    }
}
