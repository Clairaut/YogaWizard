package com.greenwich.yogawizard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class CourseFragment extends Fragment {
    private CourseData selectedData;

    // New instance of course fragment
    public static CourseFragment newInstance(CourseData selectedData) {
        CourseFragment fragment = new CourseFragment(); // Creates course fragment
        Bundle args = new Bundle(); // Creates bundle to hold arguments
        args.putSerializable("Course Data", (Serializable) selectedData); // Fits course data into bundle
        fragment.setArguments(args); // Passing arguments to fragment
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieves bundle and data
        if (getArguments() != null) {
            selectedData = (CourseData) getArguments().getSerializable("Course Data");
        }
    }

    // Fragment structure
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflates layout for fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        // Initializing textviews
        TextView name = view.findViewById(R.id.name);
        TextView teacher = view.findViewById(R.id.teacher);
        TextView type = view.findViewById(R.id.type);
        TextView location = view.findViewById(R.id.location);
        TextView date = view.findViewById(R.id.date);
        TextView time = view.findViewById(R.id.time);
        TextView duration = view.findViewById(R.id.duration);
        TextView pricing = view.findViewById(R.id.pricing);
        TextView capacity = view.findViewById(R.id.capacity);
        TextView description = view.findViewById(R.id.description);

        // Setting textview text
        name.setText(selectedData.name);
        teacher.setText(selectedData.teacher);
        type.setText(selectedData.type);
        location.setText("Location: " + selectedData.location);
        date.setText("Date: " + selectedData.date);
        time.setText("Time: " + selectedData.time);
        duration.setText("Duration: " + selectedData.duration);
        pricing.setText("Pricing: " + selectedData.pricing);
        capacity.setText("Capacity: " + selectedData.capacity);
        description.setText(selectedData.description);

        return view;
    }
}
