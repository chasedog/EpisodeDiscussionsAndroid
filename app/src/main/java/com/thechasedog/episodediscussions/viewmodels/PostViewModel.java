package com.thechasedog.episodediscussions.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.thechasedog.episodediscussions.models.Episode;

public class PostViewModel extends BaseObservable{
    public Episode mEpisode;

    public PostViewModel() {

    }

    @Bindable
    public String getUps() {
        return Integer.toString(mEpisode.getUps());
    }

    @Bindable
    public String getTitle() {
        return mEpisode.getTitle();
    }

    public void setPost(Episode episode) {
        mEpisode = episode;
        notifyChange();
    }
}
