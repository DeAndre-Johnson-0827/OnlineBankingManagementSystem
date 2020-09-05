package com.codeintelx.bank.services;

import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import java.util.UUID;

public class AccountServices {

    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String accountType, String customerName, double amount) {
        UUID uuid = UUID.randomUUID();
        String accountId =
                Long.toString(uuid.getMostSignificantBits()).substring(1, 11).replace("-", " ");

        Account accountInfo = new Account(accountId, accountType, customerName, amount);
        accounts.put(accountId, accountInfo);
        return accountInfo;
    }


    public Account searchAccount(String accountID) throws AccountNotFoundException {
        if (!accounts.containsKey(accountID)) {
            throw new AccountNotFoundException("Account number: " + accountID + " was not found. ");
        }
        return accounts.get(accountID);
    }


    public void closeAccount(String accountID) throws AccountNotFoundException {
        Account account = searchAccount(accountID);
        accounts.remove(account.getAccountID());


    }

    public Account viewAccount(String accountID) throws AccountNotFoundException {
        return searchAccount(accountID);
    }

    public Account withdraw(String accountID, double withdrawal) throws AccountNotFoundException,
            InsufficientFundsException {

        Account userAccount = searchAccount(accountID);

        double balance = userAccount.getBalance() - withdrawal;
        if (balance >= 0) {
            userAccount.setBalance(balance);
        } else {
            throw new InsufficientFundsException("The account you want to withdraw from only has " +
                    userAccount.getBalance());
        }

        return userAccount;
    }

    public Account deposit(String accountID, double depositedAmount) throws AccountNotFoundException {
        Account userAccount = searchAccount(accountID);
        if (depositedAmount > 0) {
            double balance = userAccount.getBalance() + depositedAmount;
            userAccount.setBalance(balance);
        }
        return userAccount;
    }

    public Map<String, Account> viewAllAccounts() {


        return accounts;
    }
}











