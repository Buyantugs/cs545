package edu.miu.Lab3_part3n4;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {

    Map<Integer, BankAccount> bankAccounts=new HashMap<Integer, BankAccount>();

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody BankAccount bankAccount){

        bankAccounts.put(bankAccount.getAccountNumber(), new BankAccount(bankAccount.getAccountNumber(), bankAccount.getAccountHolder()));
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @GetMapping("/getAccount/{accNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Integer accNumber){
        BankAccount bankAccount= bankAccounts.get(accNumber);

        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{accNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accNumber){
        BankAccount bankAccount= bankAccounts.get(accNumber);

        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }
        bankAccounts.remove(accNumber);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @PostMapping("/deposit/{accNumber}")
    public ResponseEntity<?> deposit(@PathVariable Integer accNumber, @RequestParam Double amount){

        BankAccount bankAccount=bankAccounts.get(accNumber);
        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }

        bankAccount.deposit(amount);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @PostMapping("/withdraw/{accNumber}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accNumber, @RequestParam Double amount){

        BankAccount bankAccount=bankAccounts.get(accNumber);
        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }

        bankAccount.withdraw(amount);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

}
