package edu.miu.Lab3_part3n4.web;


import edu.miu.Lab3_part3n4.domain.BankAccount;
import edu.miu.Lab3_part3n4.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BankController {

    //Map<Integer, BankAccount> bankAccounts=new HashMap<Integer, BankAccount>();
    @Autowired
    BankService bankService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody BankAccount bankAccount){

        bankService.addBankAccount(bankAccount);

        //int t=1/0; tested by exception

        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @GetMapping("/getAccount/{accNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Integer accNumber){
        BankAccount bankAccount= bankService.getBankAccount(accNumber);

        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{accNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accNumber){
        BankAccount bankAccount= bankService.getBankAccount(accNumber);

        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }
        bankService.deleteBankAccount(accNumber);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @PostMapping("/deposit/{accNumber}")
    public ResponseEntity<?> deposit(@PathVariable Integer accNumber, @RequestParam Double amount){

        BankAccount bankAccount=bankService.getBankAccount(accNumber);
        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }

        bankService.bankDeposit(accNumber,amount);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }

    @PostMapping("/withdraw/{accNumber}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accNumber, @RequestParam Double amount){

        BankAccount bankAccount=bankService.getBankAccount(accNumber);
        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }

        bankService.bankWithdraw(accNumber, amount);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("error", exception.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
