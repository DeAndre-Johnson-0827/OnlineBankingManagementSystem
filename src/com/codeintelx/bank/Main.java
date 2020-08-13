package com.codeintelx.bank;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.HashMap;
import java.util.Scanner; //importing the scanner class
import java.util.Random;

public class Main {

    public static Scanner scanner=new Scanner(System.in);
    public static AccountServices c=new AccountServices();
public static AccountServices d=new AccountServices();
    public static void main(String[] args) {
boolean quit=false;
       int option;
        System.out.println("Welcome to Online Banking Management");
printInstruction();
       while(!quit){

           System.out.println("Enter option");
           option=scanner.nextInt();
           scanner.nextLine();

           switch(option){
               case 1:
                   createAccount1();
                   break;

               case 2:
                   viewAccount();
                   break;

               case 3:
                   withdraw();

                   break;

               case 4:
                    deposit();
                   break;
               case 5:
                    printInstruction();
                   break;
               case 6:
                   quit=true;
                   break;


           }
       }

}
public static void printInstruction(){
    System.out.println("Press"+ '\n'+
            "1- Create Account"+ '\n'+
            "2-View Account"+ '\n'+
            "3-Withdraw from an Account"+ '\n'+
            "4-Deposit to an account" + '\n'+
            "5-Display Options"+'\n'+
            "6-QUIT");
}

public static void createAccount1(){
    AccountServices c=new AccountServices();
     Scanner scanner=new Scanner(System.in);
        Random rand=new Random();
    int AccountID = rand.nextInt(9999999);
    AccountID+=1;
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
    }else{
        System.out.println( "Invalid Account");



}
     d.createAccount(AccountID, username, AccountType,depositedAmount );
    System.out.println("Acount ID:"+AccountID);
  //int j =c.createAccount(AccountID,username,AccountType,depositedAmount);
   // System.out.println(j);
}

public static void viewAccount(){
    Scanner scanner=new Scanner(System.in);
        System.out.println("What the user's account ID?");
        int accountID=scanner.nextInt();
    d.viewAccount(accountID);


}
public static void withdraw(){
        Scanner scanner=new Scanner(System.in);
    System.out.println("Enter Account ID");
       int AccountId=scanner.nextInt();
        System.out.println("Enter the amount you want withdraw");
       double withdrawal=scanner.nextDouble();
        d.withdraw(AccountId,withdrawal);
}
public static void deposit(){
        Scanner scanner= new Scanner(System.in);
    System.out.println("Enter Account ID");
    int AccountID=scanner.nextInt();

    double deposit=scanner.nextDouble();
    System.out.println("Enter the Amount you want to deposit");
    d.deposit(AccountID,deposit);

}
}
