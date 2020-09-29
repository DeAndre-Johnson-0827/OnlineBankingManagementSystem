package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Map;
import java.util.Scanner; //importing the scanner class


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static AccountServices accountServices = new AccountServices();
    public static Account user;
    String accountID;

    public static void main(String[] args) throws AccountNotFoundException, com.codeintelx.bank.exceptions.AccountNotFoundException {
        boolean quit = false;
        int option;
        System.out.println("Welcome to Online Banking Management");
        printInstruction();
        while (!quit) {

            System.out.println("Enter option");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("What is your name ?");
                    String username = scanner.next();
                    double depositedAmount = 0;
                    System.out.println("What type of account do you want to create checking/saving?");
                    String accountType = scanner.next();
                    if (accountType.equals("checking")) {
                        System.out.println("Enter the amount you want to deposit into your checking account.");
                        depositedAmount = scanner.nextDouble();

                    } else if (accountType.equals("saving")) {
                        System.out.println("Enter the amount you want to deposit into your saving account.");
                        depositedAmount = scanner.nextDouble();

                    } else {
                        System.out.println("Invalid Account");

                    }

                    user=accountServices.createAccount(accountType, username, depositedAmount);
                    System.out.println("Welcome "+user.getCustomerName() + " you've created a "+user.getAccountType()+"s account."+'\n'+
                            "Thank you for opening the account "+ user.getAccountID() + " with balance of $"+ user.getBalance());
                    break;

                case 2:// Allows existing bank user to view banking information


                    System.out.println("What is the user's account ID?");
                    String accountID = scanner.next();
                    user = accountServices.searchAccount((accountID));

                    System.out.println("Name :" + user.getCustomerName() + '\n' +
                            "Account Identification :" + user.getAccountID() + '\n' +
                            "Account Type :" + user.getAccountType() + '\n' +
                            "Balance :$" + user.getBalance());
                    break;


                case 3: //allows existing user to withdraw money from account
                    withdraw();
                    break;

                case 4:// allows existing user to deposit money to account.
                    deposit();
                    break;
                case 5://
                    printInstruction();
                    break;
                case 6:
                    System.out.println("Viewing all accounts");
                    for (Map.Entry<String, Account> masterView : accountServices.viewAllAccounts().entrySet()) {
                        System.out.println("Account ID :" + masterView.getKey() + '\n' +
                                "Customer Name :" + masterView.getValue().getCustomerName() + '\n' +
                                "Account Type :" + masterView.getValue().getAccountType() + '\n' +
                                " Balance :$" + masterView.getValue().getBalance() + '\n');

                    }
                    break;


                case 7:
                    quit = true;
                    break;

                case 0:

                    System.out.println("Enter the Account ID for the account that you want to close!");
                    accountID = scanner.nextLine();
                    accountServices.closeAccount(accountID);


                    break;


            }
        }

    }

    public static void printInstruction() {
        System.out.println("Press" + '\n' +
                "0-Close Account" + '\n' +
                "1-Create Account" + '\n' +
                "2-View Account" + '\n' +
                "3-Withdraw from an Account" + '\n' +
                "4-Deposit to an account" + '\n' +
                "5-Display Options" + '\n' +
                "6-Print All Bankers" + '\n' +
                "7-QUIT");
    }


    public static void viewAccount() throws AccountNotFoundException, com.codeintelx.bank.exceptions.AccountNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the user's account ID?");
        String accountID = scanner.nextLine();
        user = accountServices.searchAccount((accountID));

        System.out.println("Name :" + user.getCustomerName() + '\n' +
                "Account Identification:" + user.getAccountID() + '\n' +
                "Account Type :" + user.getAccountType() + '\n' +
                "Balance :$" + user.getBalance());



    }

    public static void withdraw() throws AccountNotFoundException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Account ID");
            String AccountId = scanner.nextLine();
            System.out.println("Enter the amount you want withdraw");
            double withdrawal = scanner.nextDouble();

            user = accountServices.withdraw(AccountId, withdrawal);
            System.out.println(" $" + user.getBalance());
        } catch (Exception e) {
            System.out.println("$" + user.getBalance());
        }

    }

    public static void deposit() throws com.codeintelx.bank.exceptions.AccountNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account ID");
        String AccountId = scanner.nextLine();
        System.out.println("Enter the Amount you want to deposit");
        double deposit = scanner.nextDouble();

        accountServices.deposit(AccountId, deposit);
        System.out.println(" $" + user.getBalance());


    }

    public static void closeAccount() throws com.codeintelx.bank.exceptions.AccountNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Account ID for the account that you want to close!");
        String AccountId = scanner.nextLine();
        accountServices.closeAccount(AccountId);


    }
}
