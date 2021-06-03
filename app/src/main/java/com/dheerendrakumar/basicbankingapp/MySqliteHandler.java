package com.dheerendrakumar.basicbankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MySqliteHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Bank.db";
    private static final String USER_TABLE = "UserTable";
    private static final String TRANSFER_TABLE = "TransferTablee";
    private static final String CUSTOMER_ID = "id";
    private static final String CUSTOMER_NAME = "customerName";
    private static final String CUSTOMER_EMAIL = "customerEmail";
    private static final String CUSTOMER_PHONE = "customerPhone";
    private static final String CUSTOMER_BALANCE = "currentBalance";
    private static final String CUSTOMER_UPI = "customerUpi";


    String createUserTable = "create table " + USER_TABLE + "(" + CUSTOMER_ID + " text, "
            + CUSTOMER_NAME + " text, " + CUSTOMER_EMAIL + " text, " + CUSTOMER_PHONE +
            " text, " + CUSTOMER_BALANCE + " text, " + CUSTOMER_UPI +  " text" + ")";

    private static final String FROM_ACCOUNT = "fromAccount";
    private static final String TO_ACCOUNT = "toAccount";
    private static final String AMOUNT = "amount";
    private static final String DATE = "date";
    private static final String TIME = "time";
    private static final String FROM_CUSTOMER_ID = "fromCustomerId";
    private static final String TO_CUSTOMER_ID = "toCustomerId";

    String createTransferTablee = "create table " + TRANSFER_TABLE + "(" + FROM_CUSTOMER_ID + " text, " + FROM_ACCOUNT +
    " text, " + TO_CUSTOMER_ID + " text, " +TO_ACCOUNT + " text, " + AMOUNT + " text, " + DATE + " text, " + TIME +
    " text" + ")";


    public MySqliteHandler(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createUserTable);
        db.execSQL(createTransferTablee);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + USER_TABLE);
        db.execSQL("drop table if exists " +TRANSFER_TABLE);
        onCreate(db);
    }


    public void addUser(User user) {

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CUSTOMER_ID,user.getId());
        values.put(CUSTOMER_NAME,user.getName());
        values.put(CUSTOMER_EMAIL,user.getEmail());
        values.put(CUSTOMER_PHONE,user.getPhone());
        values.put(CUSTOMER_BALANCE,user.getBalance());
        values.put(CUSTOMER_UPI,user.getUpi());

        database.insert(USER_TABLE,null,values);
        database.close();

    }

    public List<User> getAllUser() {

        List<User> UsersList = new ArrayList<>();
        String selectQuery = "select * from " + USER_TABLE;
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()) {

            do {
                User user = new User();
                user.setId(cursor.getString(0));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPhone(cursor.getString(3));
                user.setBalance(cursor.getString(4));
                user.setUpi(cursor.getString(5));

                UsersList.add(user);
            } while(cursor.moveToNext());

        }
        return UsersList;
    }

    public int updateUser(User user) {

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CUSTOMER_ID,user.getId());
        values.put(CUSTOMER_NAME,user.getName());
        values.put(CUSTOMER_EMAIL,user.getEmail());
        values.put(CUSTOMER_PHONE,user.getPhone());
        values.put(CUSTOMER_BALANCE,user.getBalance());
        values.put(CUSTOMER_UPI,user.getUpi());

        return database.update(USER_TABLE,values,CUSTOMER_ID + " = ? ",new String[] {String.valueOf(user.getId())});

    }

    public void addTransfer(TransferDetails transferDetails) {

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FROM_CUSTOMER_ID,transferDetails.getFromId());
        values.put(FROM_ACCOUNT,transferDetails.getFromAccount());
        values.put(TO_CUSTOMER_ID,transferDetails.getToId());
        values.put(TO_ACCOUNT,transferDetails.getToAccount());
        values.put(AMOUNT,transferDetails.getAmount());
        values.put(DATE,transferDetails.getDate());
        values.put(TIME,transferDetails.getTime());

        database.insert(TRANSFER_TABLE,null,values);
        database.close();

    }


    public List<TransferDetails> getAllTransfer() {

        List<TransferDetails> TransferList = new ArrayList<>();
        String selectQuery = "select * from " + TRANSFER_TABLE;
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()) {

            do {
                TransferDetails transferDetails = new TransferDetails();
                transferDetails.setFromId(cursor.getString(0));
                transferDetails.setFromAccount(cursor.getString(1));
                transferDetails.setToId(cursor.getString(2));
                transferDetails.setToAccount(cursor.getString(3));
                transferDetails.setAmount(cursor.getString(4));
                transferDetails.setDate(cursor.getString(5));
                transferDetails.setTime(cursor.getString(6));


                TransferList.add(transferDetails);
            } while(cursor.moveToNext());

        }
        return TransferList;
    }
}
