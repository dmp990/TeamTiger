package com.sparta.tt.phase_two;

import java.util.ArrayList;
import java.util.Date;

public class Spartan {
    private String name;
    private String course;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Spartan(String name, String course, String date) {
        this.name = name;
        this.course = course;

        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
