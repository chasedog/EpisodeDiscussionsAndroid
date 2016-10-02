package com.thechasedog.episodediscussions.viewmodels;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.Uri;

import com.thechasedog.episodediscussions.Util.Device;
import com.thechasedog.episodediscussions.activities.EpisodeFragment;
import com.thechasedog.episodediscussions.models.Episode;

import static android.content.Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class PostViewModel extends BaseObservable{
    private final EpisodeFragment.OnListFragmentInteractionListener mListener;
    public Episode mEpisode;

    public PostViewModel(EpisodeFragment.OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Bindable
    public String getUps() {
        return Integer.toString(mEpisode.getUps());
    }

    @Bindable
    public String getEpisodeNumber() {
        return Integer.toString(mEpisode.getEpisodeNumber());
    }

    @Bindable
    public String getTitle() {
        return mEpisode.getTitle();
    }

    public void setPost(Episode episode) {
        mEpisode = episode;
        notifyChange();
    }

    public void onClick() {
        mListener.onClick(mEpisode);
    }
}
