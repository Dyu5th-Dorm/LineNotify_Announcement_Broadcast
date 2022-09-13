package com.github.nutt1101.model;

import org.json.JSONObject;

public class AnnouncementModel {

    private Integer id;
    private String title;
    private String content;
    private String date;
    private String URL;
    private String imageURL;

    public AnnouncementModel(Integer id, String title, String content, String date, String URL, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.URL = URL;
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getURL() {
        return URL;
    }

    public String getImageURL() {
        return imageURL;
    }
}
