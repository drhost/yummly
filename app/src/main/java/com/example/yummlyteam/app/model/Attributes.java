
package com.example.yummlyteam.app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("course")
    @Expose
    private List<String> course = null;
    @SerializedName("cuisine")
    @Expose
    private List<String> cuisine = null;
    @SerializedName("holiday")
    @Expose
    private List<String> holiday = null;

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public List<String> getCuisine() {
        return cuisine;
    }

    public void setCuisine(List<String> cuisine) {
        this.cuisine = cuisine;
    }

    public List<String> getHoliday() {
        return holiday;
    }

    public void setHoliday(List<String> holiday) {
        this.holiday = holiday;
    }

}
