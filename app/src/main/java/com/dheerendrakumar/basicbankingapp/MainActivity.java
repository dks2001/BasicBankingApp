package com.dheerendrakumar.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MySqliteHandler mySqliteHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySqliteHandler = new MySqliteHandler(MainActivity.this);

        Button button = findViewById(R.id.viewUserButton);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setY(-1000);
        imageView.animate().translationY(50).setDuration(1000).alpha(1);

        List<TransferDetails> transferDetails = mySqliteHandler.getAllTransfer();
        if(transferDetails.size()>0) {

            for(int i=0;i<transferDetails.size();i++) {

                TransferDetails td = transferDetails.get(i);
                Log.i("fromId",td.getFromId());
                Log.i("fromName",td.getFromAccount());
                Log.i("toId",td.getToId());
                Log.i("toName",td.getToAccount());
                Log.i("amount",td.getAmount());
                Log.i("date",td.getDate());
                Log.i("time",td.getTime());

            }
        }



       /* User user1 = new User("101","Dheerendra","dk@gmail.com","9876453201","50000","1234");
        User user2 = new User("102","Raj","raj@gmail.com","9808553745","60000","4321");
        User user3 = new User("103","Jay","jay@gmail.com","6745398201","45000","0987");
        User user4 = new User("104","Nishant","nk@gmail.co","8745349821","75000","6854");
        User user5 = new User("105","Vishal","vishal@gmail.com","9348710065","50000","4008");
        User user6 = new User("106","Hardik","hd@gmail.com","8674510758","90000","9985");
        User user7 = new User("107","Satvik","sat@gmail.com","9030776644","45000","4521");
        User user8 = new User("108","Ishan","ishu@gmail.com","8754224456","60000","0934");
        User user9 = new User("109","Pooja","pooja@gmail.com","9845637289","46000","9912");
        User user10 = new User("110","Reema","reema@gmail.com","8560042536","67000","6510");

        mySqliteHandler.addUser(user1);
        mySqliteHandler.addUser(user2);
        mySqliteHandler.addUser(user3);
        mySqliteHandler.addUser(user4);
        mySqliteHandler.addUser(user5);
        mySqliteHandler.addUser(user6);
        mySqliteHandler.addUser(user7);
        mySqliteHandler.addUser(user8);
        mySqliteHandler.addUser(user9);
        mySqliteHandler.addUser(user10); */

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ViewAllUsers.class);
                startActivity(intent);

            }
        });



    }
}