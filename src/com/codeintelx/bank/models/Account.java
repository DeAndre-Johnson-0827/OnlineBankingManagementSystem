package com.codeintelx.bank.models;

public class Account {
    private  String customerName;
    private  int accountID;
    private  String accountType;
    private double balance;

    public Account(int accountID,String accountType, String customerName,double balance){
        this.customerName=customerName;
        this.accountID=accountID;
        this.accountType=accountType;
        this.balance=balance;

    }



    public void deposit(double DepositedAmount){
        this.balance+=DepositedAmount;
    }

    public void withdraw(double WithdrawalAmount){

        if(this.balance-WithdrawalAmount<0){
            System.out.println(WithdrawalAmount+" is more than you have in you current account");
        }
        else if(
            this.balance-WithdrawalAmount>0){
            System.out.println(WithdrawalAmount + " was processed you cureent balance is "+(this.balance-WithdrawalAmount));
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public int getAccountID() {

   return accountID;}

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }
}
