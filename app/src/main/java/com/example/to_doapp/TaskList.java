package com.example.to_doapp;

import java.util.ArrayList;


public class TaskList {

    private ArrayList<Task> list;

    public TaskList(){
        list = new ArrayList<>();
    }

    public ArrayList<Task> getList() {
        return new ArrayList<>(list);
    }

}
