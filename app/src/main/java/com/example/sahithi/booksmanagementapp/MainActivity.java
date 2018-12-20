package com.example.sahithi.booksmanagementapp;

import android.app.LauncherActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;
    ListView listView;
    FloatingActionButton fab;
    MyListAdapter adapter1;
    ArrayList<ListItem> listItems=new ArrayList<>();

    //  final String[] from = new String[] { DatabaseHelper._ID,
    //          DatabaseHelper.BOOK, DatabaseHelper.AUTHOR, DatabaseHelper.DATE };
    //  final int[] to = new int[] { R.id.id, R.id.book_name, R.id.author_name,R.id._date};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        adapter1 = new MyListAdapter(this, listItems);
        this.getspacecrafts();
        listView.setEmptyView(findViewById(R.id.empty));
        DBManager dbManager = new DBManager(MainActivity.this);
        dbManager.open();
     /*  Cursor cursor = dbManager.fetch();
          listView.setEmptyView(findViewById(R.id.empty));
          adapter = new SimpleCursorAdapter(this, R.layout.listcontent, cursor, from, to, 0);
          adapter.notifyDataSetChanged();
          listView.setAdapter(adapter); */

        fab = findViewById(R.id.fab);

        ((View) fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_mem = new Intent(MainActivity.this, add_activity.class);

                startActivity(add_mem);
            }
        });
    }
    public void getspacecrafts(){
        listItems.clear();
        DBManager dbManager = new DBManager(this);
        dbManager.open();
        Cursor c=dbManager.fetch();
        ListItem listItem=null;
        while (c.moveToNext()){
            int id=c.getInt(0);
            String name=c.getString(1);
            String authorname=c.getString(2);
            String datecreated=c.getString(3);
            listItem=new ListItem();
            listItem.setId(id);
            listItem.setName(name);
            listItem.setAuthorname(authorname);
            listItem.setDate(datecreated);
            listItems.add(listItem);
        }
        c.close();
        dbManager.close();
        listView.setAdapter(adapter1);
    }



}