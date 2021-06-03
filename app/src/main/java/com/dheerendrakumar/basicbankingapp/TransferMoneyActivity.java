package com.dheerendrakumar.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class TransferMoneyActivity extends AppCompatActivity {

    MySqliteHandler mySqliteHandler;
    List<User> user;
    private RecyclerView transferRecyclerview;
    static String id="";
    static String upi="";
    static int balance=0;
    static int sendBalance=0;
    static String name="";
    static String email="";
    static String phone="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money);

        mySqliteHandler = new MySqliteHandler(TransferMoneyActivity.this);
        user = mySqliteHandler.getAllUser();

        EditText amountEditText = findViewById(R.id.amountEditText);
        EditText upiEditText = findViewById(R.id.upiEditText);
        Button transferTo = findViewById(R.id.transferToButton);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        upi = intent.getStringExtra("upi");
        balance = Integer.parseInt(intent.getStringExtra("balance"));
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        phone  = intent.getStringExtra("phone");

        Log.i("id",id);
        Log.i("name",name);
        Log.i("email",email);
        Log.i("phone",phone);
        Log.i("balance",balance+"");
        Log.i("upi",upi);

        transferTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendBalance = Integer.parseInt(amountEditText.getText().toString());

                if(amountEditText.getText().toString().equals("")) {
                    Toast.makeText(TransferMoneyActivity.this, "Enter amount", Toast.LENGTH_SHORT).show();
                } else if(upiEditText.getText().toString().equals("")) {
                    Toast.makeText(TransferMoneyActivity.this, "Enter upi", Toast.LENGTH_SHORT).show();
                } else if(!upiEditText.getText().toString().equals(upi)) {
                    Toast.makeText(TransferMoneyActivity.this, "WRONG UPI PIN", Toast.LENGTH_SHORT).show();
                } else {
                    transferRecyclerview = findViewById(R.id.transferRecyclerview);
                    transferRecyclerview.setAdapter(new TransferRecyclerAdapter(TransferMoneyActivity.this, user));
                    transferRecyclerview.setLayoutManager(new LinearLayoutManager(TransferMoneyActivity.this));
                }

            }
        });


    }
}