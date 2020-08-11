package com.codeintelx.bank;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.util.HashMap;
import java.util.Scanner; //importing the scanner class
import java.util.Random;

public class Main {

    public static Scanner scanner=new Scanner(System.in);
    public static AccountServices c=new AccountServices();

    public static void main(String[] args) {

        //AccountServices c= new AccountServices();


       /* HashMap map=new HashMap<String,Account>();
map.put("keyString", new Account(new ));*/
       System.out.println("1.) Create an account" +'\n'+
                "2.) View an account" + '\n' +
                "3.) Withdraw from account " + '\n' +
               "4.) Deposit to an account"+'\n'+
               "5.) Exit window."
        );
        int option=scanner.nextInt();

while(option<1 || option >5){
    System.out.println("Invalid Input");
    option=scanner.nextInt();
}

        switch(option){
            case 1:

            createAccount1();
         // Programs needs help!

        break;
    case 2:


break;

            case 3:


break;
    case 4:


break;
            case 5:







}}
public static void  createAccount1(){
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
        System.out.println("How much do you want to deposit into your checking account?");
        depositedAmount=scanner.nextDouble();

    }else if(AccountType.equals("saving")){
        System.out.println("How much do you want to deposit into your saving account?");
        depositedAmount=scanner.nextDouble();
    }else{
        System.out.println( "Invalid Account");



}
     c.createAccount(AccountID, username, AccountType,depositedAmount );
    String j =c.createAccount(AccountID,username,AccountType,depositedAmount);
    System.out.println(j);
}}
