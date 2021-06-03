package com.dheerendrakumar.basicbankingapp;

public class TransferDetails {

    private String fromAccount;
    private String fromId;
    private String toAccount;
    private String toId;
    private String amount;
    private String date;
    private String time;

    public TransferDetails() {
        super();
    }

    public TransferDetails(String fromAccount, String fromId, String toAccount, String toId, String amount, String date, String time) {
        this.fromAccount = fromAccount;
        this.fromId = fromId;
        this.toAccount = toAccount;
        this.toId = toId;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
