package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;

import javax.security.auth.login.AccountNotFoundException;
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



    private Account searchAccount(String accountID) throws AccountNotFoundException {


        Account user;

        if (!User.containsKey(accountID)){

    // throw new AccountNotFoundException();

        }return User.get(accountID);}

    public void closeAccount(String accountID) {
        if (User.containsKey(accountID)) {
            User.remove(accountID);
        }
    }



   public Account viewAccount(String accountID) throws AccountNotFoundException{

        return User.get(accountID);
}





  public Account withdraw(String accountID,double withdrawal)throws AccountNotFoundException
  {
//double balance = User.get(accountID).getBalance() - withdrawal;
      Account user;
      user = searchAccount(accountID);
      if (user != null) {
          double balance = User.get(accountID).getBalance() - withdrawal;
          if (balance >= 0) {
              User.get(accountID).setBalance(balance);
          } else {
              throw new ArithmeticException();
          }

      }
      return user;
  }


public Account deposit(String AccountID,double depositedAmount) throws AccountNotFoundException {
    searchAccount(AccountID);
    Account user;
    user=searchAccount(AccountID);
    if (user != null) {
        if (depositedAmount > 0) {
            Double balance = User.get(AccountID).getBalance() + depositedAmount;
            User.get(AccountID).setBalance(balance);
        } /*else {
            throw new NegativeEntryNotAllowed();

        }*/
    }
    return user;
}
}











