package com.example.sahithi.booksmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;

public class DBManager {
    private DBHelper dbHelper;

    private Context c;

    private SQLiteDatabase database;

    public DBManager(Context c) {

        this.c = c;
        dbHelper = new DBHelper(c);
    }

    public void open(){
        // dbHelper = new DBHelper(c);
        try {
            database = dbHelper.getWritableDatabase();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        //  return this;
    }

    public void close() throws SQLException {
        dbHelper.close();
    }

    public boolean insert(String name, String author,String date) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(DBHelper.BOOK, name);
            contentValue.put(DBHelper.AUTHOR, author);
            contentValue.put(DBHelper.DATE, date);
            long result = database.insert(DBHelper.TABLE_NAME, DBHelper._ID, contentValue);
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cursor fetch() {
        String[] columns ={ DBHelper._ID, DBHelper.BOOK, DBHelper.AUTHOR,DBHelper.DATE };
        Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
        //  if (cursor != null) {
        //     cursor.moveToFirst();
        //  }
        return cursor;
    }


    public boolean delete(int _id) {
        try{
            int result=database.delete(DBHelper.TABLE_NAME, DBHelper._ID + "=?", new String[]{String.valueOf(_id)});
            if(result>0){
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}