package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class FormController {
    @GetMapping("/form")
    public ModelAndView form() {
        Person person = new Person();

        ModelAndView mav = new ModelAndView();
        mav.addObject("person", person);
        mav.setViewName("form");

        return mav;
    }

    @PostMapping("/form")
    public ModelAndView formSubmit(@Valid Person person, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName("form");
            return mav;
        }
        //if there are no errors, show form success screen
        mav.addObject("person", person);
        mav.setViewName("success");
        return mav;
    }
}

