package com.example.examan.model;

public class ItemHome {
    int id;
    String title, imageHome, imageDetails, details;

    public ItemHome(int id, String title, String imageHome, String imageDetails, String details) {
        this.id = id;
        this.title = title;
        this.imageHome = imageHome;
        this.imageDetails = imageDetails;
        this.details = details;
    }

    public ItemHome(int id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }

    public ItemHome() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageHome() {
        return imageHome;
    }

    public String getImageDetails() {
        return imageDetails;
    }

    public String getDetails() {
        return details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageHome(String imageHome) {
        this.imageHome = imageHome;
    }

    public void setImageDetails(String imageDetails) {
        this.imageDetails = imageDetails;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
