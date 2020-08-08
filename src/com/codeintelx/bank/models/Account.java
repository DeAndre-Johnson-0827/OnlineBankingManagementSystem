package com.codeintelx.bank.models;

import java.util.ArrayList;
public class Account {
    private String customerName;
    private String accountID;
    private  String accountType;
    private double balance;

    public Account(String customerName,String accountID,String accountType, double balance){
        this.customerName=customerName;
        this.accountID=accountID;
        this.accountType=accountType;
        this.balance=balance;
    }


}
