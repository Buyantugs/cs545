package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class PaymentController {

    @PostMapping("/processpayment")
    public ModelAndView processPayment(@RequestParam(value="name") String name,
                                       @RequestParam(value="creditcardnumber") String creditCardNumber) {
        System.out.println("process order from "+name+" with credit card: "+creditCardNumber);
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("creditcardnumber", creditCardNumber);
        return new ModelAndView("thankyou", params);
    }
    @GetMapping("/entercard")
    public ModelAndView page2() {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("payment", params);
    }

}
