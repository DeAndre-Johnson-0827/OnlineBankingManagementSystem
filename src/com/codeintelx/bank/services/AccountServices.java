package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;

import java.util.ArrayList;
public class AccountServices {
    private String customerName;
    private double balance;
    private ArrayList<Account> accounts;


    public AccountServices(String customerName, String accountType){
        this.customerName=customerName;

    this.accounts= new ArrayList<Account>();
    }

    public String getName() {
        return customerName;
    }




}



