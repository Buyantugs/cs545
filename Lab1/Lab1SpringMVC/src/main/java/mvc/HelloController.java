package mvc;

import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/calc")
    public ModelAndView mycalc( @RequestParam(value="num1") String firstNum,
                        @RequestParam(value="num2") String secondNum,
                        @RequestParam(value="op") String operation) {

        String result= Calculator.calculate(Float.parseFloat(firstNum),Float.parseFloat(secondNum),operation);

        Map<String, Object> params = new HashMap<>();


        params.put("num1", firstNum);
        params.put("num2", secondNum);
        params.put("op", operation);
        params.put("result", result);

        return new ModelAndView("mycalc",params);
    }
}

