package com.thechasedog.episodediscussions.services.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubredditResponse {

    @SerializedName("seasons")
    @Expose
    public List<SeasonResponse> seasons = new ArrayList<SeasonResponse>();
    @SerializedName("subreddit")
    @Expose
    public String subreddit;

    public SubredditResponse() {
    }

    public SubredditResponse(List<SeasonResponse> seasons, String subreddit) {
        this.seasons = seasons;
        this.subreddit = subreddit;
    }

}
