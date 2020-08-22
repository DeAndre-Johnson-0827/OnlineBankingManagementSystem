package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;

import java.util.*;

import java.util.Map;
import java.util.HashMap;

import java.util.UUID;
public class AccountServices {

    Scanner scanner = new Scanner(System.in);
   //private List<Account> User = new ArrayList<>();

   private Map <String,Account> User =new HashMap<>();

    public Account createAccount(String accountType, String customerName, double amount) {
        UUID uuid=UUID.randomUUID();
        String accountId= Long.toString(uuid.getMostSignificantBits()).substring(1,11).replace("-"," ");


     Account  accountInfo=(new Account(accountId, accountType, customerName, amount));
        User.put(accountId,accountInfo);

        return accountInfo;
    }



    public Account searchAccount(String accountID) {

            return User.get(accountID);


    }

    public void closeAccount(String accountID) {
        if (User.containsKey(accountID)) {
            User.remove(accountID);
        }
    }




  /*  public void printUserList(){
        System.out.println("The User list has "+ User.size() + "amount of customers in the User list.");
        searchAccount()
    }*/
   public Account viewAccount(String accountID){

     // searchAccount(accountID);
        return searchAccount(accountID);


      /* System.out.println("Customer name:"+ User.get(accountID).getCustomerName());
            System.out.println(" Account Type"+User.get(accountID).getAccountType());
            System.out.println("Account ID: "+ User.get(accountID).getAccountID());
            System.out.println("Balance $"+ User.get(accountID).getBalance());*/
/*if (user==null){
    System.out.println("Account Id does not exist");
return null;
}
else{ System.out.println("Customer name:"+ User.get(accountID).getCustomerName());
    System.out.println(" Account Type"+User.get(accountID).getAccountType());
    System.out.println("Account ID: "+ User.get(accountID).getAccountID());
    System.out.println("Balance $"+ User.get(accountID).getBalance());
    return user;*/
}





  public void withdraw(String AccountID,double withdrawal) {
      int index;

      searchAccount(AccountID);

      Double balance = User.get(AccountID).getBalance() - withdrawal;

      if (balance >= 0) {
          User.get(AccountID).setBalance(balance);
          System.out.println(User.get(AccountID).getBalance());
      } else
          while (balance < 0) {
              System.out.println("Is too much money");
          }
  }



public void deposit(String AccountID,double depositedAmount) {
    searchAccount(AccountID);
           if(depositedAmount>0){

               Double balance = User.get(AccountID).getBalance() + depositedAmount;
               User.get(AccountID).setBalance(balance);
            System.out.println(User.get(AccountID).getBalance());  }
           else{
               System.out.println("invalid entry");
           }
}


}











