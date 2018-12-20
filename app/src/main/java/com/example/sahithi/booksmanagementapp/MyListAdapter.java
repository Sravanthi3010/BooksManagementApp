package com.example.sahithi.booksmanagementapp;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;


public class MyListAdapter extends BaseAdapter {

    private Context context;
    private DBManager dbManager;
    LayoutInflater inflater;
    // ListItem listItem;
    private ArrayList<ListItem> item;
    public MyListAdapter(Context context, ArrayList<ListItem> item){
        this.context=context;
        this.item=item;
    }
    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(inflater==null)
        {
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView==null){
            convertView=inflater.inflate(R.layout.listcontent,parent,false);
        }

        Viewholder holder=new Viewholder(convertView);

        holder.ntext.setText(item.get(position).getName());

        holder.atext.setText(item.get(position).getAuthorname());

        holder.dtext.setText(item.get(position).getDate());


        // ImageButton del=(ImageButton)listItemView.findViewById(R.id.delete);

        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity=new MainActivity();
                DBManager dbManager=new DBManager(context);
                dbManager.open();
                dbManager.delete(item.get(position).getId());
                dbManager.close();
                item.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}