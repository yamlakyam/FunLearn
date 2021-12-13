package com.example.funlearn.Models;

import com.google.gson.annotations.SerializedName;

public class Reviewer {

    @SerializedName("name")
    private String name;

    @SerializedName("display_name")
    private String display_name;

    public String getName() {
        return name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
}
