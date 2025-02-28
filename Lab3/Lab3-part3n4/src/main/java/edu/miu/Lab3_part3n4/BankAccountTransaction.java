package edu.miu.Lab3_part3n4;

import java.util.Date;

public class BankAccountTransaction {
    private static int counter = 1;
    private int txnId;
    private String txnType;
    private double amount;
    private Date date;

    public BankAccountTransaction(String txnType, double amount) {

        this.txnId = counter++;
        this.txnType = txnType;
        this.amount = amount;
        this.date = new Date();
    }

    public int getTxnId() {
        return txnId;
    }

    public String getTxnType() {
        return txnType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
