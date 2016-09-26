package com.thechasedog.episodediscussions.services;

import com.thechasedog.episodediscussions.services.models.SubredditResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chase Dog on 9/25/2016.
 */

public interface DiscussionApi {
    @GET("r/{subreddit}")
    Call<SubredditResponse> getSubreddit(@Path("subreddit") String subreddit);
}
