package com.thechasedog.episodediscussions.activities;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thechasedog.episodediscussions.R;
import com.thechasedog.episodediscussions.databinding.PostViewBinding;
import com.thechasedog.episodediscussions.models.Episode;
import com.thechasedog.episodediscussions.viewmodels.PostViewModel;

import java.util.List;

public class EpisodeViewListAdapter extends RecyclerView.Adapter<EpisodeViewListAdapter.BindingHolder> {

    private final EpisodeFragment.OnListFragmentInteractionListener mListener;
    private final List<Episode> mEpisodes;

    public EpisodeViewListAdapter(List<Episode> items, EpisodeFragment.OnListFragmentInteractionListener listener) {
        mEpisodes = items;
        mListener = listener;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PostViewBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.post_view, parent, false);
        return new BindingHolder(binding);
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

    /*@Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }*/

    public class BindingHolder extends RecyclerView.ViewHolder {
        private final PostViewBinding mBinding;
        private final PostViewModel mPostViewModel;

        public BindingHolder(PostViewBinding binding) {
            super(binding.getRoot());
            mPostViewModel = new PostViewModel(mListener);
            binding.setPost(mPostViewModel);
            mBinding = binding;
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }

        public void bindPost(Episode episode) {
            mPostViewModel.setPost(episode);
            mBinding.executePendingBindings();
        }
    }
}
