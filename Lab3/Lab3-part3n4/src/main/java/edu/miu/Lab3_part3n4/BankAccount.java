package edu.miu.Lab3_part3n4;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private  int accountNumber;
    private String accountHolder;
    private double balance;
    private List<BankAccountTransaction> transactions;

    public BankAccount() {}
    public BankAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance=0.0;
        this.transactions=new ArrayList<>();
    }

    public BankAccount(int accountNumber, String accountHolder, double balance, List<BankAccountTransaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = transactions;
    }

    public List<BankAccountTransaction> getTransactions() {
        return transactions;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount){
        balance=balance+amount;
        transactions.add(new BankAccountTransaction("Deposit",amount));
    }

    public void withdraw(double amount){
        if(balance>=amount){
            balance=balance-amount;
            transactions.add(new BankAccountTransaction("withdrawal",amount));
        } else{
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance(){
        return balance;
    }

    public void addTransaction(BankAccountTransaction txn){
        transactions.add(txn);
    }
}
