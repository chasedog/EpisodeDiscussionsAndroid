package com.thechasedog.episodediscussions.services.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chase Dog on 9/25/2016.
 */
public class EpisodeResponse {

    @SerializedName("date_pacific")
    @Expose
    public String datePacific;
    @SerializedName("date_utc")
    @Expose
    public float dateUtc;
    @SerializedName("episode_number")
    @Expose
    public int episodeNumber;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;

    public EpisodeResponse() {
    }

    public EpisodeResponse(String datePacific, float dateUtc, int episodeNumber, String name, String title, String url) {
        this.datePacific = datePacific;
        this.dateUtc = dateUtc;
        this.episodeNumber = episodeNumber;
        this.name = name;
        this.title = title;
        this.url = url;
    }
}
