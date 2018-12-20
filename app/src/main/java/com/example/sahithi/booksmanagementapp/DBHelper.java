package com.example.sahithi.booksmanagementapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "BookList";

    // Table columns
    public static final String _ID = "_id";
    public static final String BOOK = "name";
    public static final String AUTHOR = "author";
    public static final String DATE= "date";

    // Database Information
    static final String DB_NAME = "Books.DB";

    // database version
    static final int DB_VERSION = 1;


    public DBHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }


    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK + " TEXT NOT NULL, " + AUTHOR + " TEXT NOT NULL, " + DATE + " TEXT );";

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            db.execSQL(CREATE_TABLE);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}