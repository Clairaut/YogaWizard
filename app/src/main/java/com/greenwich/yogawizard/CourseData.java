package com.greenwich.yogawizard;

import java.io.Serializable;
import java.time.Clock;
import java.util.Calendar;

public class CourseData implements Serializable {
    String name;
    String teacher;
    String type;
    String date;
    String time;
    String location;
    String duration;
    String capacity;
    String pricing;
    String description;

    public CourseData(String name, String teacher, String type, String date, String time, String location, String duration, String capacity, String pricing, String description) {
        this.name = name;
        this.teacher = teacher;
        this.type = type;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.capacity = capacity;
        this.pricing = pricing;
        this.description = description;
    }
}
