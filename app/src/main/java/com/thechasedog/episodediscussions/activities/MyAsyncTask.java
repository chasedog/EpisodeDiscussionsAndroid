package com.thechasedog.episodediscussions.activities;

import android.os.AsyncTask;

/**
 * Created by Chase Dog on 9/25/2016.
 */

public abstract class MyAsyncTask<TParams, TProgress, TResult> extends AsyncTask<TParams, TProgress, TResult> {

    private AsyncResponse<TResult> listener;

    public MyAsyncTask(AsyncResponse<TResult> response) {
        listener = response;
    }

    @Override
    protected void onPostExecute(TResult tResult) {
        listener.processFinish(tResult);
    }
}
