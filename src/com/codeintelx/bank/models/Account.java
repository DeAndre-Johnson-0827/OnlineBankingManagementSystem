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
    public Account(){
        this.customerName=customerName;
        this.accountID=accountID;
        this.accountType=accountType;
        this.balance=balance;
    }
   public void withdraw(double withdrawAmount) {
       System.out.println("Processing withdrawal...........");
        if (balance-withdrawAmount<0) {
            System.out.println("Withdrawal of $" + withdrawAmount + " can not be processed. ");
        }else{
            this.balance-=withdrawAmount;
            System.out.println("we were able to process the withdrawal amount of $"+withdrawAmount+ "." +'\n'+
                    "Remaining balance of $"+ this.balance);
            }
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

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
