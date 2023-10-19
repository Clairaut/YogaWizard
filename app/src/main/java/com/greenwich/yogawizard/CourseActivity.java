package com.greenwich.yogawizard;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseview);

        // Initializing courses object list
        List<CourseData> courseDataList = new ArrayList<>();

        // Appending default classes
        courseDataList.add(new CourseData("Aerial Yoga", "Kyle Kyleson", "Aerial Yoga", "2023-12-25", "12 PM",  "Greenwich", "1 hour", "20", "$30", "This is a yoga class"));

        // Initializing UI
        Button backButton = findViewById(R.id.backButton);

        // Initializing Course Adapter
        final CourseAdapter courseAdapter = new CourseAdapter(courseDataList);

        // Initializing recycler view for courses
        RecyclerView courseView = findViewById(R.id.courseView);
        courseView.setLayoutManager(new LinearLayoutManager(this));
        courseView.setAdapter(courseAdapter);

        // Listener for Adapter
        courseAdapter.setOnCardClickListener(new CourseAdapter.OnCardClickListener() {
            @Override
            public void onCardClick(int position) {
                // Receiving Selected Data
                CourseData selectedData = courseDataList.get(position);

                // Creating a new fragment
                Intent intent = new Intent(CourseActivity.this, CourseInfoActivity.class);
                intent.putExtra("Selected Data", selectedData); // Passes selected data to info class
                startActivity(intent);
            }
        });

        // Back button listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}