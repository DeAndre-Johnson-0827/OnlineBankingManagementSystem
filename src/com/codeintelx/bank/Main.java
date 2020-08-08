package com.codeintelx.bank;
import java.util.Scanner; //aimporting the scanner class

public class Main {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Press 1 to create an account" +'\n'+
                "Press 2 to view an account" + '\n' +
                "Press 3 to withdraw from account " +
                '\n' +"Press 4 to deposit to an account"
        );
        int option=scanner.nextInt();
        scanner.nextLine();

        if(option==1){
            System.out.println("What is your name? ");
           String customerName=scanner.nextLine();
            System.out.println("Do you want to create a Checkings or Savings Account?" + '\n'
            + "Press c OR s");
            String accountType=scanner.nextLine();
            if(accountType.equals(('c'))) {
                System.out.println("Hello "+ customerName +" you selected to open a checking account?");
            }
            else if (accountType.equals(('s'))){
                System.out.println("Hello "+ customerName +" you have selected to open a savings account");
            };





        }
        else if(option==2){
            System.out.println("Whats your account number?");
            int accountNumber=scanner.nextInt();
        }

        else if (option==3){
            System.out.println("What is your account ");
        }

    }



}
