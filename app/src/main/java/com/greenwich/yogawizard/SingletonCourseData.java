package com.greenwich.yogawizard;

import java.util.ArrayList;
import java.util.List;

public class SingletonCourseData {
    private static SingletonCourseData instance;
    private final List<CourseData> myCourseDataList;

    private SingletonCourseData() {
        myCourseDataList = new ArrayList<>();
    }

    public static SingletonCourseData getInstance() {
        if (instance == null) {
            instance = new SingletonCourseData();
        }
        return instance;
    }

    public boolean containsCourse(CourseData courseData) {
        return myCourseDataList.contains(courseData);
    }

    public void addCourse(CourseData courseData) {
        myCourseDataList.add(courseData);
    }

    public List<CourseData> getCourseDataList() {
        return myCourseDataList;
    }
}
