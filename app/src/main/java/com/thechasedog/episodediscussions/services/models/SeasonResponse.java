package com.thechasedog.episodediscussions.services.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SeasonResponse {

    @SerializedName("episodes")
    @Expose
    public List<EpisodeResponse> episodes = new ArrayList<EpisodeResponse>();
    @SerializedName("is_rewatch")
    @Expose
    public boolean isRewatch;
    @SerializedName("season_number")
    @Expose
    public int seasonNumber;

    public SeasonResponse() {
        episodes = new ArrayList<>();
    }

    public SeasonResponse(List<EpisodeResponse> episodes, boolean isRewatch, int seasonNumber) {
        this.episodes = episodes;
        this.isRewatch = isRewatch;
        this.seasonNumber = seasonNumber;
    }

}