package com.codeintelx.bank.models;

public class Account {
    private  String customerName;
    private  String accountType;
    private double balance;
    private String accountID;
    public Account(String accountID, String accountType, String customerName,double balance){
        this.customerName=customerName;
        this.accountType=accountType;
        this.balance=balance;
        this.accountID=accountID;
    }
    public Account(){
        this.customerName=customerName;

        this.accountType=accountType;
        this.balance=balance;
    }


   public void deposit(double depositedAmount) {
        this.balance+=depositedAmount;
   }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }



    public String getAccountID()
    {
        return accountID;
}


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
