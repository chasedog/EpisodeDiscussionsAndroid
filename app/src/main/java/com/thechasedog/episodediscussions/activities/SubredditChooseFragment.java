package com.thechasedog.episodediscussions.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.thechasedog.episodediscussions.R;

/**
 * Created by Chase Dog on 9/27/2016.
 */

public class SubredditChooseFragment extends DialogFragment {
    private Context mContext;

    public interface NoticeDialogListener {
        void onDialogPositiveClick(SubredditChooserResponse result);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    NoticeDialogListener mListener;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
        try {
            mListener = (NoticeDialogListener)context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View view = View.inflate(mContext, R.layout.dialog_enter_subreddit, null);
        final EditText subreddit = (EditText)view.findViewById(R.id.edit_text_subreddit);
        final CheckBox saveToDrawer = (CheckBox) view.findViewById(R.id.checkbox_save_to_drawer);
        builder.setView(view)
                .setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        SubredditChooserResponse result = new SubredditChooserResponse(subreddit.getText().toString(), saveToDrawer.isChecked());
                        mListener.onDialogPositiveClick(result);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
