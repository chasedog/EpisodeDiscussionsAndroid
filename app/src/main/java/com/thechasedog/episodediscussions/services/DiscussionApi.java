package com.thechasedog.episodediscussions.services;

import com.thechasedog.episodediscussions.models.Subreddit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chase Dog on 9/25/2016.
 */

public interface DiscussionApi {
    @GET("r/{subreddit}")
    Call<Subreddit> getSubreddit(@Path("subreddit") String subreddit);
}
