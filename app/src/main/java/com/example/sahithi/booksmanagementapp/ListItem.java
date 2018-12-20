package com.example.sahithi.booksmanagementapp;

public class ListItem {

    String name;
    int id;
    String authorname;
    String date;

    public ListItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public String getDate() {
        return date;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public void setDate(String date) {
        this.date = date;
    }

}