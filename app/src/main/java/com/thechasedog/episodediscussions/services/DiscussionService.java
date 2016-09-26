package com.thechasedog.episodediscussions.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chase Dog on 9/25/2016.
 */

public class DiscussionService {
    private static final String BASE_URL = "http://episodediscussions.herokuapp.com/api/";
    private static DiscussionApi DiscussionApi;

    public static DiscussionApi GetDiscussionApi() {
        if (DiscussionApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            DiscussionApi = retrofit.create(DiscussionApi.class);
        }

        return DiscussionApi;
    }
}
