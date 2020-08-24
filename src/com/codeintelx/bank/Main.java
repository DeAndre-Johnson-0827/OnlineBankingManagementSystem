package com.codeintelx.bank;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.Scanner; //importing the scanner class
import java.util.Random;

public class Main {

    public static Scanner scanner=new Scanner(System.in);

public static AccountServices d=new AccountServices();
public static Account user;
String accountID;

    public static void main(String[] args) throws AccountNotFoundException {
boolean quit=false;
       int option;
        System.out.println("Welcome to Online Banking Management");
printInstruction();
       while(!quit){

           System.out.println("Enter option");
           option=scanner.nextInt();
           scanner.nextLine();

           switch(option){
               case 1: //Opens an account with the bank
                   createAccount1();
                   break;

               case 2:// Allows existing bank user to view banking information
                viewAccount();
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
                   quit=true;
                   break;

               case 0:
                   closeAccount();
                   break;


           }
       }

}
public static void printInstruction(){
    System.out.println("Press"+ '\n'+
            "0-Close Account"+ '\n'+
            "1- Create Account"+ '\n'+
            "2-View Account"+ '\n'+
            "3-Withdraw from an Account"+ '\n'+
            "4-Deposit to an account" + '\n'+
            "5-Display Options"+'\n'+
            "6-QUIT");
}

public static void createAccount1(){
       // Account accountInfo;

    AccountServices d=new AccountServices();
     Scanner scanner=new Scanner(System.in);
    double depositedAmount=0 ;
    String AccountType;

    System.out.println("What is your name ?");

    String username = scanner.nextLine();

    System.out.println("What type of account do you want to create checking or saving");
    AccountType=scanner.nextLine();

    if (AccountType.equals("checking")){
        System.out.println("Enter the amount you want to deposit into your checking account.");
        depositedAmount=scanner.nextDouble();

    }else if(AccountType.equals("saving")){
        System.out.println("Enter the amount you want to deposit into your saving account.");
        depositedAmount=scanner.nextDouble();
       // accountInfo = d.createAccount(AccountType, username, depositedAmount);
       // System.out.println(accountInfo.getAccountID() + accountInfo.getCustomerName());
    }else{
        System.out.println( "Invalid Account");




}
   // Account accountInfo;
    user = d.createAccount(AccountType, username, depositedAmount);
    // accountInfo=d.createAccount( AccountType, username ,depositedAmount );
    System.out.println("Account ID:"+user.getAccountID()+'\n' +"Customer Name:"+user.getCustomerName()+'\n'
                    +"Account Type: "+user.getAccountType()+ '\n'+
            "Balance: $"+user.getBalance());


}

public static void viewAccount() throws AccountNotFoundException {
    Scanner scanner=new Scanner(System.in);
    //String accountID=scanner.nextLine();
    System.out.println("What is the user's account ID?");
        String accountID=scanner.nextLine();
       d.viewAccount((accountID));

    System.out.println("Name :"+ user.getCustomerName()+'\n'+
           "Account Identification:"+ user.getAccountID()+'\n'+
           "Account Type :"+ user.getAccountType()+'\n'+
            "Balance :$"+user.getBalance());
    //System.out.println(user);




}
public static void withdraw() throws AccountNotFoundException {
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account ID");
        String AccountId = scanner.nextLine();
        System.out.println("Enter the amount you want withdraw");
        double withdrawal = scanner.nextDouble();

        user = d.withdraw(AccountId, withdrawal);
        System.out.println(" $"+ user.getBalance());
    } catch (Exception e) {
        System.out.println("$" + user.getBalance());
    }

}
public static void deposit()  {
        Scanner scanner= new Scanner(System.in);
    System.out.println("Enter Account ID");
    String AccountId=scanner.nextLine();

    double deposit=scanner.nextDouble();
    System.out.println("Enter the Amount you want to deposit");
   // d.deposit(AccountId,deposit);

}
public static void closeAccount(){
Scanner scanner= new Scanner(System.in);
System.out.println("Enter the Account ID for the account that you want to close!");
String AccountId =scanner.nextLine();
d.closeAccount(AccountId);


}
}
