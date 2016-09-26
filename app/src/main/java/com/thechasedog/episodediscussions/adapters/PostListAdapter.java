package com.thechasedog.episodediscussions.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.thechasedog.episodediscussions.R;

import java.util.List;

import com.thechasedog.episodediscussions.databinding.PostViewBinding;
import com.thechasedog.episodediscussions.models.Episode;

public class PostListAdapter extends RecyclerView.Adapter<BindingHolder> {
    private Activity context;
    private final List<Episode> mEpisodes;

    public PostListAdapter(Activity context, List<Episode> episodes) {
        this.context = context;
        mEpisodes = episodes;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        PostViewBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.post_view, parent, false);
        return new BindingHolder(context, binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
         Episode episode = mEpisodes.get(position);
        holder.bindPost(episode);
    }

    @Override
    public int getItemCount() {
        return mEpisodes.size();
    }
}
