/*
Task 3 ATM interface #OasisInfobyte
Account , Withdraw , Deposit and Transfer amount
*/

import java.text.DecimalFormat;
import java.util.Scanner;


public class Account {
    Scanner input = new Scanner(System.in);
DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
private int customerNumber;
private int pinNumber;
private double currentBalance = 0;
private double savingBalance = 0;

// set the customer number 
public int setCustomerNumber (int customerNumber){
    this.customerNumber = customerNumber;
    return customerNumber;
}
// get customer number
public int getCustomerNumber(){
    return customerNumber;
}
// set Pin Number
public int setPinNumber (int pinNumber){
    this.pinNumber = pinNumber;
    return pinNumber;
}
// get Pin Number
public int getPinNumber (){
    return pinNumber;
}
// get Current account balance
public double getCurrentBalance (){
    return currentBalance;
}
// get saving account balance
public double getSavingBalance(){
    return savingBalance;
}

// calculate current account withdrawal
public double calCurrentWithdrawal (double amount){
    currentBalance = (currentBalance-amount);
    return currentBalance;
}

// calculate saving account withdrawal
public double calSavingWithdrawal (double amount){
    savingBalance = (savingBalance - amount);
    return savingBalance;
}

// current account deposite
public double calCurrentDeposite(double amount){
    currentBalance = (currentBalance+ amount);
    return currentBalance;
}

// saving account deposite
public double calSavingDeposite(double amount){
    savingBalance = (savingBalance + amount);
    return savingBalance;
}

// transfer amount from saving account
public double calSavingTransfer(double amount){
    savingBalance = (savingBalance-amount);
    return savingBalance;
}

// customer transfer amount from saving to current account
public double calCurrentTransfer(double amount){
    currentBalance = (currentBalance + amount);
    return currentBalance;
}

// Current account withdrawal input

public void getCurrentWithdrawInput(){
    System.out.println("Current Account Balance : "+ moneyFormat.format(currentBalance));
    System.out.print("Amount you want to withdraw from current Account : ");
    double amount = input.nextDouble();

    if((currentBalance - amount) >= 0){
        calCurrentWithdrawal(amount);
        System.out.println("Updated Account Balance : "+ moneyFormat.format(currentBalance) + "\n");
    }else{
        System.out.println("Balance cannot be negative\n");
    }
}

// customer saving account withdraw input

public void getSavingWithdrawInput(){
    System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
    System.out.print("Amount you want to withdraw from saving account : ");
    double amount = input.nextDouble();

    if((savingBalance - amount) >= 0){
        calSavingWithdrawal(amount);
        System.out.println("Updated Saving account balance : " + savingBalance + "\n");
    }else{
        System.out.println("Balance cannot be negative\n");
    }
}

// current account deposite input
public void getCurrentDepositeInput(){
    System.out.println("Current account balance : "+ moneyFormat.format(currentBalance));
    System.out.print("Amount you want to deposite in current account : ");
    double amount = input.nextDouble();

    if((currentBalance + amount)>= 0){
        calCurrentDeposite(amount);
        System.out.println("New current account balance : "+ moneyFormat.format(currentBalance));
    } else{
        System.out.println("Balance cannot be negative");
    }
}

// saving account deposite
public void getSavingDepositeInput(){
    System.out.println("Saving account balance : "+ moneyFormat.format(savingBalance));
    System.out.print("Amount you want to deposite in saving account : ");
    double amount = input.nextDouble();

    if((savingBalance + amount)>= 0){
        calSavingDeposite(amount);
        System.out.println("New saving account balance : "+ moneyFormat.format(savingBalance));
    } else{
        System.out.println("Balance cannot be negative\n");
    }
}

public void getSavingTransferInput(){
    System.out.println("Saving account balance : "+ moneyFormat.format(savingBalance));
    System.out.print("Amount you want to transfer from saving account : ");
    double amount = input.nextDouble();

    if(savingBalance >= 0){
        calSavingTransfer(amount);
        System.out.println("New saving account balance : "+ moneyFormat.format(savingBalance));
        calCurrentTransfer(amount);
        System.out.println("New current account balance : "+ moneyFormat.format(currentBalance));
    } else{
        System.out.println("Balance cannot be negative\n");
    }
}

}
