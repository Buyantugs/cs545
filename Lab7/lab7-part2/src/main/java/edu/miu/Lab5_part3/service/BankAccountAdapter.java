package edu.miu.Lab5_part3.service;

import edu.miu.Lab5_part3.domain.BankAccount;

public class BankAccountAdapter {
    public static BankAccount getBank(BankAccountDTO bankDTO){

        BankAccount bankAccount=new BankAccount();

        if(bankAccount!=null){
            bankAccount=new BankAccount(
                    bankDTO.getAccountNumber(),
                    bankDTO.getAccountHolder(),
                    bankDTO.getBalance(),
                    bankDTO.getTransactionList()
            );
        }

        return bankAccount;
    }

    public  static BankAccountDTO getBankDTO(BankAccount bankAccount){
        BankAccountDTO bankAccountDTO=new BankAccountDTO();

        if(bankAccount!=null){
            bankAccountDTO=new BankAccountDTO(
                    bankAccount.getAccountNumber(),
                    bankAccount.getAccountHolder(),
                    bankAccount.getBalance(),
                    bankAccount.getTransactions()
            );
        }

        return bankAccountDTO;
    }
}
