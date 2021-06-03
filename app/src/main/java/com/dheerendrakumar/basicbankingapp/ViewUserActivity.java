package com.dheerendrakumar.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        Intent intent = getIntent();
        String id = intent.getStringExtra("user_id");
        String name = intent.getStringExtra("user_name");
        String email = intent.getStringExtra("user_email");
        String phone = intent.getStringExtra("user_phone");
        String balance = intent.getStringExtra("user_balance");
        String upi = intent.getStringExtra("user_upi");

        Log.i("id",id);
        Log.i("name",name);
        Log.i("email",email);
        Log.i("phone",phone);
        Log.i("balance",balance);
        Log.i("upi",upi);

        TextView nametextview = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView balanceTextView = findViewById(R.id.balanceTextView);
        Button checkBalance = findViewById(R.id.checkBalancButton);
        Button transferButton = findViewById(R.id.transferMoneyButton);

        nametextview.setText(name);
        emailTextView.setText(email);
        phoneTextView.setText(phone);

        checkBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balanceTextView.setText("Rs " + balance+".00");
            }
        });


        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(ViewUserActivity.this,TransferMoneyActivity.class);
                intent1.putExtra("id",id);
                intent1.putExtra("upi",upi);
                intent1.putExtra("balance",balance);
                intent1.putExtra("name",name);
                intent1.putExtra("email",email);
                intent1.putExtra("phone",phone);
                startActivity(intent1);
            }
        });
    }
}