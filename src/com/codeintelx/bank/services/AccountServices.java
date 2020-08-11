package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServices {

    Scanner scanner =new Scanner(System.in);
    private List<Account> User= new ArrayList<>();

    public String createAccount(int accountID,String customerName,String accountType, double amount) {

        User.add(new Account(accountID, accountType,customerName,amount));
return accountType;
    }




    }










