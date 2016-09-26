package com.thechasedog.episodediscussions.services;

import com.thechasedog.episodediscussions.models.Episode;
import com.thechasedog.episodediscussions.models.Season;
import com.thechasedog.episodediscussions.models.Subreddit;
import com.thechasedog.episodediscussions.services.models.EpisodeResponse;
import com.thechasedog.episodediscussions.services.models.SeasonResponse;
import com.thechasedog.episodediscussions.services.models.SubredditResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public static Subreddit getSubreddit(String subreddit) throws IOException {
        DiscussionApi api = DiscussionService.GetDiscussionApi();
        Call<SubredditResponse> subredditCall = api.getSubreddit(subreddit);
        return mapSubreddit(subredditCall.execute().body());
    }

    private static Subreddit mapSubreddit(SubredditResponse response) {
        Subreddit result = new Subreddit();
        result.Name = response.subreddit;
        for (SeasonResponse s : response.seasons) {
            result.seasons.add(mapSeason(s));
        }
        return result;
    }

    private static Season mapSeason(SeasonResponse s) {
        Season result = new Season();
        result.IsRewatch = s.isRewatch;
        result.SeasonNumber = s.seasonNumber;

        for (EpisodeResponse e : s.episodes) {
            result.Episodes.add(mapEpisode(e));
        }
        return result;
    }

    private static Episode mapEpisode(EpisodeResponse e) {
        Episode result = new Episode();
        result.Title = e.title;
        result.URL = e.url;
        result.EpisodeNumber = e.episodeNumber;
        return result;
    }
}
