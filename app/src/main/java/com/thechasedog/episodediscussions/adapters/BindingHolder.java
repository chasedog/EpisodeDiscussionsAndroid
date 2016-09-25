package com.thechasedog.episodediscussions.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Chase Dog on 9/24/2016.
 */
public class BindingHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public BindingHolder(View rowView) {
        super(rowView);
        binding = DataBindingUtil.bind(rowView);
    }
    public ViewDataBinding getBinding() {
        return binding;
    }
}
