package edu.miu.Lab5_part3.service;

import edu.miu.Lab5_part3.domain.BankAccountTransaction;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDTO {

    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<BankAccountTransaction> transactionList;

    public BankAccountDTO(){

    }

    public BankAccountDTO(int accountNumber, String accountHolder, double balance, List<BankAccountTransaction> transactionList) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionList = transactionList;
    }

    public void deposit(double amount) {
        if (transactionList == null) {
            transactionList = new ArrayList<>();
        }
        balance = balance + amount;
        transactionList.add(new BankAccountTransaction("Deposit", amount));
    }


    public void withdraw(double amount){
        if(balance>=amount){
            balance=balance-amount;
            transactionList.add(new BankAccountTransaction("withdrawal",amount));
        } else{
            System.out.println("Insufficient balance!");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<BankAccountTransaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<BankAccountTransaction> transactionList) {
        this.transactionList = transactionList;
    }
}
