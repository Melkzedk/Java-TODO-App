package com.example.to_doapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActivityLogTask extends AppCompatActivity implements View.OnClickListener {

    private EditText new_text_title;
    private EditText new_text_description;
    private CheckBox completeBox;
    private Button btnDatePicker;
    private EditText txtDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_task);

        new_text_title = findViewById(R.id.new_task_title);
        new_text_description = findViewById(R.id.new_task_description);
//       due_date = (EditText) findViewById(R.id.due_date);
        Button save_button = findViewById(R.id.save_button);
        completeBox = findViewById(R.id.completeBox);

        btnDatePicker= findViewById(R.id.date_button);
        txtDate= findViewById(R.id.due_date);

        btnDatePicker.setOnClickListener(this);
    }


    @Override
    public void onClick(View button) {

        if (button == btnDatePicker) {

            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year, monthOfYear, dayOfMonth) -> txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


    public void onSaveButtonClick(View view){
        String newTitle = new_text_title.getText().toString();
        String newDescription = new_text_description.getText().toString();
        String newDueDate = txtDate.getText().toString();
        boolean newComplete = completeBox.isChecked();

       Task newTask = new Task(newTitle, newDescription, newDueDate, newComplete);
//        now throw to Movie List
        Intent intent = new Intent(this, ActivityList.class);
        intent.putExtra("newTask", newTask);
        Toast.makeText(this, "Task saved!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


}
