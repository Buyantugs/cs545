package edu.miu.Lab5_part3.service;

import edu.miu.Lab5_part3.data.BankRepository;
import edu.miu.Lab5_part3.domain.BankAccount;
import edu.miu.Lab5_part3.domain.BankAccountTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public void addBankAccount(BankAccountDTO bankAccountDTO){
        BankAccount bankAccount=BankAccountAdapter.getBank(bankAccountDTO);
        bankRepository.save(bankAccount);

    }

    public void deleteBankAccount(Integer accountId){
        bankRepository.delete(bankRepository.findByAccountNumber(accountId));
    }

    public BankAccountDTO getBankAccount(Integer accountId){

        BankAccount bankAccount=bankRepository.findByAccountNumber(accountId);
        return BankAccountAdapter.getBankDTO(bankAccount);
    }

    public void bankDeposit(Integer accountId, double amount){

        BankAccount bankAccountDTO = bankRepository.findByAccountNumber(accountId);
        if (bankAccountDTO != null) {
            bankAccountDTO.deposit(amount);
            bankRepository.save(bankAccountDTO);
        }
    }

    public void bankWithdraw(Integer accountId, double amount){
        BankAccount bankAccountDTO=bankRepository.findByAccountNumber(accountId);

        if (bankAccountDTO != null) {
            bankAccountDTO.withdraw(amount);
            bankRepository.save(bankAccountDTO);
        }
    }
}
