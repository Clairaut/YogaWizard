package com.greenwich.yogawizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI Widgets
        Button buttonAvailableCourses = findViewById(R.id.courseButton); // Buttons
        Button buttonMyCourses = findViewById(R.id.myCourseButton);

        // Available Courses Button Listener
        buttonAvailableCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CourseActivity.class);
                startActivity(intent);
            }
        });

        buttonMyCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CourseUserActivity.class);
                startActivity(intent);
            }
        });

    }
}