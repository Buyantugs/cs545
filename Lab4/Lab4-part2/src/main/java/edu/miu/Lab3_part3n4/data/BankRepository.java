package edu.miu.Lab3_part3n4.data;

import edu.miu.Lab3_part3n4.domain.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {
    private Map<Integer, BankAccount> bankAccounts=new HashMap<>();

    public void save (BankAccount bankAccount){
        bankAccounts.put(bankAccount.getAccountNumber(), bankAccount);
    }

    public BankAccount find(Integer bankAccId){
        return bankAccounts.get(bankAccId);
    }

    public void delete(Integer bankAccId){
        bankAccounts.remove(bankAccId);
    }

    public void deposit(Integer bankAccId, double amount){
        BankAccount bankAccount=bankAccounts.get(bankAccId);
        bankAccount.deposit(amount);
    }

    public void withdraw(Integer bankAccId, double amount){
        BankAccount bankAccount=bankAccounts.get(bankAccId);
        bankAccount.withdraw(amount);
    }
}
