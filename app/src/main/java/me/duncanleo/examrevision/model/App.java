package me.duncanleo.examrevision.model;

/**
 * Created by duncanleo on 6/8/17.
 */

public class App {
    private String imageURL;
    private String title;
    private String type;
    private int procUsage = 0;

    public App(String imageURL, String title, String type, int procUsage) {
        this.imageURL = imageURL;
        this.title = title;
        this.type = type;
        this.procUsage = procUsage;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getProcUsage() {
        return procUsage;
    }
}
