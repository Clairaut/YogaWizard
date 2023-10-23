package com.greenwich.yogawizard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class CourseInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Initializing UI
        Button backButton = findViewById(R.id.backButton);
        Button addButton = findViewById(R.id.addButton);

        // Receiving selected data from course activity class
        CourseData selectedData = (CourseData) getIntent().getSerializableExtra("Selected Data");

        // Creating and displaying fragment
        CourseFragment newFragment = CourseFragment.newInstance(selectedData);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.info_container, newFragment); // Replaces info container with fragment
        transaction.commit();

        // Back button listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseInfoActivity.this, CourseActivity.class);
                startActivity(intent);
            }
        });

        // Checks if course is already within myCourseList
        if (SingletonCourseData.getInstance().containsCourse(selectedData)) {
            addButton.setText("✔");
        }

        // Add button listener
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!SingletonCourseData.getInstance().containsCourse(selectedData)) {
                    SingletonCourseData.getInstance().addCourse(selectedData);
                    addButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.check, 0, 0, 0);
                }
            }
        });

    }
}
