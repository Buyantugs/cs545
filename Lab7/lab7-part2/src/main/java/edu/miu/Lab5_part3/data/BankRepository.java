package edu.miu.Lab5_part3.data;

import edu.miu.Lab5_part3.domain.BankAccount;
import edu.miu.Lab5_part3.domain.BankAccountTransaction;
import edu.miu.Lab5_part3.service.BankAccountDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<BankAccount, Integer> {
    BankAccount findByAccountNumber(Integer accountNumber);
}
