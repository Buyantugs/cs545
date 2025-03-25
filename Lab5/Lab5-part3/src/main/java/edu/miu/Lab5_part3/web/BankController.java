package edu.miu.Lab5_part3.web;


import edu.miu.Lab5_part3.domain.BankAccount;
import edu.miu.Lab5_part3.service.BankAccountDTO;
import edu.miu.Lab5_part3.service.BankService;
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
    public ResponseEntity<?> createAccount(@RequestBody BankAccountDTO bankAccountDTO){

        bankService.addBankAccount(bankAccountDTO);

        //int t=1/0; tested by exception

        return new ResponseEntity<BankAccountDTO>(bankAccountDTO, HttpStatus.OK);
    }

    @GetMapping("/getAccount/{accNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Integer accNumber){
        BankAccountDTO bankAccountDTO= bankService.getBankAccount(accNumber);

        if(bankAccountDTO==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccountDTO>(bankAccountDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{accNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accNumber){
        BankAccountDTO bankAccountDTO= bankService.getBankAccount(accNumber);

        if(bankAccountDTO==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }
        bankService.deleteBankAccount(accNumber);
        return new ResponseEntity<BankAccountDTO>(bankAccountDTO, HttpStatus.OK);
    }

    @PostMapping("/deposit/{accNumber}")
    public ResponseEntity<?> deposit(@PathVariable Integer accNumber, @RequestParam Double amount){

        BankAccountDTO bankAccountDTO=bankService.getBankAccount(accNumber);
        if(bankAccountDTO==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }

        bankService.bankDeposit(accNumber,amount);
        return new ResponseEntity<BankAccountDTO>(bankAccountDTO, HttpStatus.OK);
    }

    @PostMapping("/withdraw/{accNumber}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accNumber, @RequestParam Double amount){

        BankAccountDTO bankAccount=bankService.getBankAccount(accNumber);
        if(bankAccount==null){
            return new ResponseEntity<CustomErrorType>( new CustomErrorType("The bank account with number="+accNumber+" is not available!"),HttpStatus.NOT_FOUND);
        }

        bankService.bankWithdraw(accNumber, amount);
        return new ResponseEntity<BankAccountDTO>(bankAccount, HttpStatus.OK);
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
