package com.thechasedog.episodediscussions.activities;

public class SubredditChooserResponse {
    public String subreddit;
    public boolean saveToDrawer;

    public SubredditChooserResponse(String subreddit, boolean saveToDrawer) {
        this.subreddit = subreddit;
        this.saveToDrawer = saveToDrawer;
    }
}
