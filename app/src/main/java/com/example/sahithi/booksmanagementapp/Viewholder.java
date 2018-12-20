package com.example.sahithi.booksmanagementapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Viewholder {
    TextView ntext,atext,dtext;
    ImageButton ib;
    public  Viewholder(View v){
        ntext=(TextView)v.findViewById(R.id.book_name);
        atext=(TextView)v.findViewById(R.id.author_name);
        dtext=(TextView)v.findViewById(R.id._date);
        ib=(ImageButton)v.findViewById(R.id.delete);
    }
}