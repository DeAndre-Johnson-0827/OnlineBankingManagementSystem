package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServices {

    Scanner scanner = new Scanner(System.in);
    private List<Account> User = new ArrayList<>();
User.add(new)
    public Account createAccount(int accountID, String customerName, String accountType, double amount) {
Account newAccounts=new Account(accountID, accountType, customerName, amount));
        User.add(new Account(accountID, accountType, customerName, amount));
   viewAccount(accountID);
        User.add(newAccounts);

return 
    }
    public void printUserList(){
        System.out.println("The User list has "+ User.size() + "amount of customers in the User list.");
        for(int i=0;i<User.size();i++){
            System.out.println((i+1)+" .)"+ User.get(i));
        }
    }
   public Account viewAccount(int accountID){
        int index;
        for (int i=0;i<User.size();i++){

        if (accountID== (User.get(i).getAccountID())){
            index=i;
                System.out.println("Customer name:"+ User.get(index).getCustomerName());
            System.out.println(" Account Type"+User.get(index).getAccountType());


            System.out.println("Account ID: "+ User.get(index).getAccountID());
            System.out.println("Balance "+ User.get(index).getBalance());

break;
       }

   }


  return null;  }

  public void withdraw(int AccountID,double withdrawal){
        int index;

        for(int i=0;i<User.size();i++){

            if(AccountID==(User.get(i).getAccountID())){

             Double balance=  User.get(i).getBalance()-withdrawal;
                System.out.println(balance);
            }
        }

    }
public void deposit(int AccountID,double depositedAmount) {
    for (int i = 0; i < User.size(); i++) {

        if (AccountID == (User.get(i).getAccountID())) {
            Double balance = User.get(i).getBalance() + depositedAmount;
            System.out.println(balance);  }
    }
}
}











