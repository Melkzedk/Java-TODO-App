package com.example.to_doapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityTaskDetails extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView due_date;
    private CheckBox complete;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        title = findViewById(R.id.task_title_detail);
        description = findViewById(R.id.task_description);
        due_date = findViewById(R.id.text_due_date);
        complete = findViewById(R.id.completeCheckbox);

        Task task = (Task)getIntent().getExtras().get("task");
        title.setText(task.getTitle());
        description.setText(task.getDescription());
        due_date.setText(task.getDueDate());
        complete.setChecked(task.getComplete());
    }

    public void onEditButtonClick(View view){

        String titleString = title.getText().toString();
        String descriptionString = description.getText().toString();
        String dueDateString = due_date.getText().toString();
        boolean isComplete = complete.isChecked();

        Task newTask = new Task(titleString, descriptionString, dueDateString, isComplete);
//        now throw to Movie List
        Intent intent = new Intent(this, ActivityList.class);
        intent.putExtra("newTask", newTask);
        Toast.makeText(this, "Task updated!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


}
