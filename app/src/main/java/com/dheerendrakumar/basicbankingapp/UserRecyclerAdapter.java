package com.dheerendrakumar.basicbankingapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {

    List<User> users;
    private Context context;

    public UserRecyclerAdapter(Context context , List<User> users) {
        this.users = users;
        this.context = context;
    }


    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userview_holder,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.getUserTextview().setText(String.valueOf(users.get(position).getName()));
        holder.getPhoneTextView().setText(String.valueOf(users.get(position).getPhone()));
        holder.getIdTextView().setId(Integer.parseInt(String.valueOf(users.get(position).getId())));

        holder.getIdTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("id",String.valueOf(holder.getIdTextView().getId()));
                Intent intent = new Intent(context,ViewUserActivity.class);
                intent.putExtra("user_id",users.get(position).getId());
                intent.putExtra("user_name",users.get(position).getName());
                intent.putExtra("user_email",users.get(position).getEmail());
                intent.putExtra("user_phone",users.get(position).getPhone());
                intent.putExtra("user_balance",users.get(position).getBalance());
                intent.putExtra("user_upi",users.get(position).getUpi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
