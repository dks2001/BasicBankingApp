package com.dheerendrakumar.basicbankingapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private TextView userTextview;
    private TextView phoneTextView;
    private TextView idTextView;
    private TextView userTextviewTransfer;
    private TextView phoneTextViewTransfer;

    public UserViewHolder(View itemView) {
        super(itemView);

        userTextview = itemView.findViewById(R.id.usersTextviewTransfer);
        phoneTextView = itemView.findViewById(R.id.phonetextviewTransfer);
        idTextView = itemView.findViewById(R.id.idtextview);
        userTextviewTransfer = itemView.findViewById(R.id.usersTextviewTransfer);
        phoneTextViewTransfer = itemView.findViewById(R.id.phonetextviewTransfer);
    }

    public TextView getUserTextview() {
        return userTextview;
    }

    public TextView getPhoneTextView() {
        return phoneTextView;
    }

    public TextView getIdTextView() {
        return idTextView;
    }

    public TextView getUserTextviewTransfer() {
        return userTextviewTransfer;
    }

    public TextView getPhoneTextViewTransfer() {
        return phoneTextViewTransfer;
    }
}
