package com.dheerendrakumar.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class ViewAllUsers extends AppCompatActivity {

    MySqliteHandler mySqliteHandler;
    List<User> user;
    private RecyclerView userRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);



        mySqliteHandler = new MySqliteHandler(ViewAllUsers.this);
        user = mySqliteHandler.getAllUser();

        //User userss = new User(user);

        userRecyclerview = findViewById(R.id.ecyclerview);
        userRecyclerview.setAdapter(new UserRecyclerAdapter(this,user));
        userRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        if(user.size()>0) {

            for(int i=0;i<user.size();i++) {

                User userr = user.get(i);
                Log.i("id",userr.getId());
                Log.i("name",userr.getName());
                Log.i("email",userr.getEmail());
                Log.i("phone",userr.getPhone());
                Log.i("balance",userr.getBalance());
                Log.i("upi",userr.getUpi());

            }
        }


    }
}