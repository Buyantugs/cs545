package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
public class CalcController {

    @PostMapping("/calc")
    public ResponseEntity<?> calculate(@RequestBody Calculation calculation) {
        System.out.println("operation = "+calculation.getOperation());
        double result=0.0;
        try{
            switch(calculation.getOperation()){
                case "+" : {result = calculation.getNumber1() + calculation.getNumber2(); break;}
                case "-" : {result = calculation.getNumber1() - calculation.getNumber2(); break;}
                case "*" : {result = calculation.getNumber1() * calculation.getNumber2(); break;}
                case "/" : {result = calculation.getNumber1() / calculation.getNumber2(); break;}
            }
            CalculationResult calculationResult = new CalculationResult(calculation.getNumber1(), calculation.getNumber2(),calculation.getOperation(), result);
            return new ResponseEntity<CalculationResult>(calculationResult, HttpStatus.OK);
        }
        catch (Exception exception){
            System.out.println("exception = "+exception.getMessage());
            return new ResponseEntity<CalculationError>(new CalculationError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
