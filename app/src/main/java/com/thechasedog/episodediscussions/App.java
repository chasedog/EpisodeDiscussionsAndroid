package com.thechasedog.episodediscussions;

import android.app.Application;

import net.dean.jraw.RedditClient;
import net.dean.jraw.android.AndroidRedditClient;
import net.dean.jraw.android.AndroidTokenStore;
import net.dean.jraw.auth.AuthenticationManager;
import net.dean.jraw.auth.RefreshTokenHandler;
import net.dean.jraw.http.LoggingMode;

/**
 * Created by Chase Dog on 10/2/2016.
 */

public class App extends Application {
    public static RedditClient redditClient;

    @Override
    public void onCreate() {
        super.onCreate();
        redditClient = new AndroidRedditClient(this);
        redditClient.setLoggingMode(LoggingMode.ALWAYS);
        RefreshTokenHandler handler = new RefreshTokenHandler(new AndroidTokenStore(this), redditClient);
        AuthenticationManager.get().init(redditClient, handler);
    }
}
