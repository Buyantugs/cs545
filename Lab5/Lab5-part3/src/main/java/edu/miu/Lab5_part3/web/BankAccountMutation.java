package edu.miu.Lab5_part3.web;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import edu.miu.Lab5_part3.service.BankAccountDTO;
import edu.miu.Lab5_part3.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;

public class BankAccountMutation implements GraphQLMutationResolver {
    @Autowired
    private BankService bankService;

    public BankAccountDTO createAccount(int accountNumber, String accountHolder) {
        BankAccountDTO accountDTO = new BankAccountDTO(accountNumber, accountHolder,0,null);
        bankService.addBankAccount(accountDTO);
        return accountDTO;
    }
    public void deposit(int accountNumber, Double amount) {
        bankService.bankDeposit(accountNumber ,amount);
    }

    public void withdraw(int accountNumber, Double amount) {
        bankService.bankWithdraw(accountNumber ,amount);
    }
}
