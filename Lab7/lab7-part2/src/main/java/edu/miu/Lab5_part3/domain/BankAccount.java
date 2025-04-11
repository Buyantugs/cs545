package edu.miu.Lab5_part3.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class BankAccount {

    @Id
    @NotBlank(message="Bank account number is required")
    private  int accountNumber;
    @NotBlank(message="Bank account holder name is required")
    private String accountHolder;

    @NotNull(message = "Balance is required")
    @Digits(integer = 10, fraction = 2, message = "Balance must have up to 10 integer digits and 2 decimal places")
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

    public void deposit(double amount) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        balance = balance + amount;
        transactions.add(new BankAccountTransaction("Deposit", amount));
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
