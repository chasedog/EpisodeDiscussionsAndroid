package com.thechasedog.episodediscussions.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.thechasedog.episodediscussions.BR;
import com.thechasedog.episodediscussions.R;

import java.util.List;

import com.thechasedog.episodediscussions.databinding.PostViewBinding;
import com.thechasedog.episodediscussions.viewmodels.PostViewModel;

public class PostListAdapter extends ArrayAdapter<PostViewModel> {
    public PostListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public PostListAdapter(Context context, int resource, List<PostViewModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.post_view, null);
        if (convertView == null) {

        }

        PostViewModel post = getItem(position);

        if (post != null) {
            ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.post_view, parent, false);
            binding.setVariable(BR.post, post);
            binding.executePendingBindings();
        }

        return convertView;
    }
}
