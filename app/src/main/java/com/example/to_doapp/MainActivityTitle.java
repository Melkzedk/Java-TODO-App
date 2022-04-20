package com.example.to_doapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void onViewAllButtonClicked(View button){
        Intent intent = new Intent(this, ActivityList.class);
        startActivity(intent);
    }

    public void onSaveNewButtonClicked(View button){
        Intent intent = new Intent(this, ActivityLogTask.class);
        startActivity(intent);
    }




}
