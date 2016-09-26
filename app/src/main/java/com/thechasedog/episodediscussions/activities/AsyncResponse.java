package com.thechasedog.episodediscussions.activities;

public interface AsyncResponse<T> {
    void processFinish(T result);
}
