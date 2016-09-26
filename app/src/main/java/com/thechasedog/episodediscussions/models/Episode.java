package com.thechasedog.episodediscussions.models;
/*
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;*/

public class Episode {// extends RealmObject {
    //@PrimaryKey
    public int Id;
    public String PostId;
    public String Title;
    public String URL;
    public int Ups;
    public String Subreddit;

    public Episode() {
    }

    public Episode(String title, int ups) {
        Title = title;
        Ups = ups;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getUps() {
        return Ups;
    }

    public void setUps(int ups) {
        Ups = ups;
    }

    public String getSubreddit() {
        return Subreddit;
    }

    public void setSubreddit(String subreddit) {
        Subreddit = subreddit;
    }
}
