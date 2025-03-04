package edu.miu.Lab3_part3n4.service;

import edu.miu.Lab3_part3n4.data.BankRepository;
import edu.miu.Lab3_part3n4.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public void addBankAccount(BankAccount bankAccount){
        bankRepository.save(bankAccount);
    }

    public void deleteBankAccount(Integer accountId){
        bankRepository.delete(accountId);
    }

    public BankAccount getBankAccount(Integer accountId){
        return bankRepository.find(accountId);
    }

    public void bankDeposit(Integer accountId, double amount){
        bankRepository.deposit(accountId, amount);
    }

    public void bankWithdraw(Integer accountId, double amount){
        bankRepository.withdraw(accountId, amount);
    }
}
