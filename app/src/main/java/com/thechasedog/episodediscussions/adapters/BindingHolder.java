package com.thechasedog.episodediscussions.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.thechasedog.episodediscussions.databinding.PostViewBinding;
import com.thechasedog.episodediscussions.models.Episode;
import com.thechasedog.episodediscussions.viewmodels.PostViewModel;

/**
 * Created by Chase Dog on 9/24/2016.
 */
public class BindingHolder extends RecyclerView.ViewHolder {
    private final PostViewBinding mBinding;
    private final PostViewModel mPostViewModel;

    public BindingHolder(Activity context, PostViewBinding binding) {
        super(binding.getRoot());
        mPostViewModel = new PostViewModel(context);
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
