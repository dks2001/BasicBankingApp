package com.dheerendrakumar.basicbankingapp;

public class User {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String balance;
    private String upi;

    public User() {
        super();
    }

    public User(String id,String name,String email,String phone,String balance,String upi) {

       /* this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.upi = upi; */
        
        setId(id);
        setName(name);
        setEmail(email);
        setPhone(phone);
        setUpi(upi);
        setBalance(balance);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

}
