package edu.miu.Lab5_part3.web;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import edu.miu.Lab5_part3.service.BankAccountDTO;
import edu.miu.Lab5_part3.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankAccountQuery implements GraphQLQueryResolver {
    @Autowired
    private BankService bankService;

    public Optional<BankAccountDTO> getAccount(final int accountNumber) {
        return Optional.of(bankService.getBankAccount(accountNumber));
    }
}
