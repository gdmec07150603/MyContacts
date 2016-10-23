package com.example.administrator.mycontacts;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/18.
 */
public class ContactsTable {
    private final static String TABLENAME="contactTable";
    private  MyDB db;
    public  ContactsTable(Context context){
        db = new MyDB(context);
        if(!db.isTableExists(TABLENAME)){
            String createTableSql="CREATE TABLE IS NOT EXISTS"+TABLENAME+"(id_Db integer )"+
                    "primary key AUTOINCREMENT,"+User.NAME +" VARCHAR,"+User.MOBILE+" VARCHAR,"+
                    User.QQ+" VARCHAR,"+User.DANWEI+" VARCHAR,"+User.ADDRESS+" VARCHAR)";
            db.creaTable(createTableSql);
        }
    }
    public  boolean addData(User user){
        ContentValues values= new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.QQ,user.getQq());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.ADDRESS,user.getAddress());
        db.save(TABLENAME,values);
        return true;
    }
}
