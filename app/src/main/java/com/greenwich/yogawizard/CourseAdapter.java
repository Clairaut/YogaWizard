package com.greenwich.yogawizard;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    // List for course objects
    private List<CourseData> courseDataList;

    // Constructor to initialize list
    public CourseAdapter(List<CourseData> courseDataList) { this.courseDataList = courseDataList; }

    // Initializes card click listener
    private OnCardClickListener mListener;

    // Interface for card clicks
    public interface OnCardClickListener {
        void onCardClick(int position); // Gets position on card click
    }

    // Listener settler
    public void setOnCardClickListener(OnCardClickListener listener) { mListener = listener;}

    // Initializing recycler view holders
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Initializing text views within holder
        TextView name;
        TextView teacher;
        TextView type;
        TextView date;
        TextView time;

        // Structuring view holder
        public ViewHolder(@NonNull View courseView, final OnCardClickListener listener) {
            super(courseView);

            // Relates holder to UI ID
            name = courseView.findViewById(R.id.name);
            teacher = courseView.findViewById(R.id.teacher);
            type = courseView.findViewById(R.id.type);
            date = courseView.findViewById(R.id.date);
            time = courseView.findViewById(R.id.time);

            // Enables listener on course view holders
            courseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Triggers listener for card
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onCardClick(position);
                        }
                    }
                }
            });
        }
    }

    // Creating new empty card
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_course, parent, false); // Inflating Astral Item Layout
        return new ViewHolder(v, mListener);
    }

    // Filling in Card
    public void onBindViewHolder(ViewHolder courseHolder, int position) {
        CourseData courseData = courseDataList.get(position);

        if (courseData != null) {
            // Updating textviews within card
            courseHolder.name.setText(courseData.name);
            courseHolder.teacher.setText(courseData.teacher);
            courseHolder.type.setText(courseData.type);
            courseHolder.date.setText(courseData.date);
            courseHolder.time.setText(courseData.time);
        } else {
            Log.e("CourseAdapter", "Course data is null");
        }
    }

    // Item count within course data list
    public int getItemCount() { return courseDataList.size(); }
}
