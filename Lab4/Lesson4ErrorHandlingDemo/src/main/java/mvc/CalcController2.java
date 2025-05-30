package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalcController2 {

    @PostMapping("/calc")
    public ResponseEntity<?> calculate(@RequestBody Calculation calculation) {
        double result=0.0;
        switch(calculation.getOperation()){
            case "+" : {result = calculation.getNumber1() + calculation.getNumber2(); break;}
            case "-" : {result = calculation.getNumber1() - calculation.getNumber2(); break;}
            case "*" : {result = calculation.getNumber1() * calculation.getNumber2(); break;}
            case "/" : {result = calculation.getNumber1() / calculation.getNumber2(); break;}
        }
        CalculationResult calculationResult = new CalculationResult(calculation.getNumber1(), calculation.getNumber2(),calculation.getOperation(), result);
        return new ResponseEntity<CalculationResult>(calculationResult, HttpStatus.OK);
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("error", exception.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
