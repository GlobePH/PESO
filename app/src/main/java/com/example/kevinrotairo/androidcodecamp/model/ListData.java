package com.example.kevinrotairo.androidcodecamp.model;

/**
 * Created by Kevin Rotairo on 5/7/2016.
 */
public class ListData {
    private String description;
    private String title;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

   
    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    
}
