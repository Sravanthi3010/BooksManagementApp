package com.example.sahithi.booksmanagementapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_activity extends Activity implements View.OnClickListener {

    Button addTodoBtn;
    private EditText titleEditText;
    private EditText authorEditText;
    private EditText dateEditText;

    private DBManager dbManager;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_activity);
        setTitle("Add Note");
        titleEditText = (EditText)findViewById(R.id.name);
        authorEditText = (EditText)findViewById(R.id.author);
        dateEditText=(EditText)findViewById(R.id.date);

        addTodoBtn =(Button)findViewById(R.id.add_book);

        dbManager = new DBManager(this);
        // dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity mainActivity=new MainActivity();
        switch (v.getId()) {
            case R.id.add_book:

                String name = titleEditText.getText().toString();
                String desc = authorEditText.getText().toString();
                String date= dateEditText.getText().toString();
                //  DBManager dbManager = new DBManager(this);
                dbManager.open();
                boolean saved=dbManager.insert(name, desc, date);
                //  dbManager.close();
                if(saved)
                {
                    titleEditText.setText("");
                    authorEditText.setText("");
                    dateEditText.setText("");
                    // mainActivity.getspacecrafts();
                }else {
                    Toast.makeText(this,"Unable To Save", Toast.LENGTH_SHORT).show();
                }


                Intent main = new Intent(add_activity.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;

        }
    }
}