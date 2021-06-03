package com.dheerendrakumar.basicbankingapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TransferRecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {

    MySqliteHandler mySqliteHandler;

   /* String fromId = TransferMoneyActivity.id;
    String fromUpi = TransferMoneyActivity.upi;
    int fromBalance = TransferMoneyActivity.balance;
    int sendBalance =  TransferMoneyActivity.sendBalance;
    String fromName = TransferMoneyActivity.name;
    String fromEmail = TransferMoneyActivity.email;
    String fromPhone = TransferMoneyActivity.phone; */

    List<User> users;
    private Context context;

    public TransferRecyclerAdapter(Context context , List<User> users) {
        this.users = users;
        this.context = context;

    }


    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfermoney_viewholder,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.getUserTextviewTransfer().setText(String.valueOf(users.get(position).getName()));
        holder.getPhoneTextViewTransfer().setText(String.valueOf(users.get(position).getPhone()));
        holder.getUserTextviewTransfer().setId(Integer.parseInt(String.valueOf(users.get(position).getId())));

        holder.getUserTextviewTransfer().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySqliteHandler = new MySqliteHandler(context);

                String fromTotalBalance = String.valueOf(TransferMoneyActivity.balance - TransferMoneyActivity.sendBalance);

                Log.i("kkkkkkkkkkk","kkkkkkkk");
                Log.i("name",users.get(position).getName());
                Log.i("fromName",TransferMoneyActivity.name);
                Log.i("fromemail",TransferMoneyActivity.email);
                Log.i("phonefrom",TransferMoneyActivity.phone);
                Log.i("fromId",TransferMoneyActivity.id);
                Log.i("balance",TransferMoneyActivity.balance+"");
                Log.i("upi",TransferMoneyActivity.upi);
                Log.i("totalfrombalance",fromTotalBalance);



                User fromUser = new User(TransferMoneyActivity.id,TransferMoneyActivity.name,TransferMoneyActivity.email,
                        TransferMoneyActivity.phone,fromTotalBalance, TransferMoneyActivity.upi);

               /* fromUser.setId(fromId);
                fromUser.setName(fromName);
                fromUser.setEmail(fromEmail);
                fromUser.setPhone(fromPhone);
                fromUser.setBalance(fromTotalBalance);
                fromUser.setUpi(fromUpi); */

                mySqliteHandler.updateUser(fromUser);


                int toBalance = Integer.parseInt(users.get(position).getBalance());
                String toFinalBalance = String.valueOf(toBalance + TransferMoneyActivity.sendBalance);

                User toUser = new User(
                        users.get(position).getId(),
                users.get(position).getName(),
                users.get(position).getEmail(),
                users.get(position).getPhone(),
                toFinalBalance,
                users.get(position).getUpi()
                );

                mySqliteHandler.updateUser(toUser);



                LocalDate date = LocalDate.now(); // Create a date object
                System.out.println(date.toString());

                LocalTime time = LocalTime.now();
                System.out.println(time.toString());

                TransferDetails transferDetails = new TransferDetails(TransferMoneyActivity.name,TransferMoneyActivity.id
                ,users.get(position).getName(),users.get(position).getId(),TransferMoneyActivity.sendBalance+"",date.toString(),time.toString());

                mySqliteHandler.addTransfer(transferDetails);

                Toast.makeText(context, "Successfully transfered", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,ViewAllUsers.class);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
