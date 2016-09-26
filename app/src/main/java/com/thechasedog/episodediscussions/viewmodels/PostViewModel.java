package com.thechasedog.episodediscussions.viewmodels;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.Uri;

import com.thechasedog.episodediscussions.Util.Device;
import com.thechasedog.episodediscussions.models.Episode;

import static android.content.Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class PostViewModel extends BaseObservable{
    public Episode mEpisode;
    private Activity mContext;

    public PostViewModel(Activity context) {

        mContext = context;
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
        Intent intent = getIntentForURL(mEpisode.getURL());
        mContext.startActivity(intent);
    }

    private Intent getIntentForURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        addFlagsForMultiWindowDevices(intent);
        return intent;
    }

    private void addFlagsForMultiWindowDevices(Intent intent) {
        if (Device.hasNougatOrGreater()) {
            intent.addFlags(getFlagsIfInMultiwindow());
        }
    }

    @TargetApi(24)
    private int getFlagsIfInMultiwindow() {
        if (mContext.isInMultiWindowMode()) {
            return FLAG_ACTIVITY_LAUNCH_ADJACENT | FLAG_ACTIVITY_NEW_TASK;
        }
        return 0;
    }
}
