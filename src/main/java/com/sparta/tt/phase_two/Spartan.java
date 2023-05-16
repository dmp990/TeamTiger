package com.sparta.tt.phase_two;

import java.util.ArrayList;

public class Spartan {
    private String name;
    private String course;
    private ArrayList<Boolean> flags;


    public Spartan(String name, String course, ArrayList<Boolean> flags) {
        this.name = name;
        this.course = course;
        this.flags = flags;
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

    public ArrayList<Boolean> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<Boolean> flags) {
        this.flags = flags;
    }
}
