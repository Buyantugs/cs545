package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StudentController {
    @PostMapping("/process")
    public ModelAndView processEntry(@RequestParam(value="firstName") String firstname,
                                     @RequestParam(value="receiveNewsletter", required = false) boolean receiveNewsletter,
                                     @RequestParam(value="sex") String sex,
                                     @RequestParam(value="house") String house
                                     ){
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("firstname", firstname);
        modelandview.addObject("newsletter", receiveNewsletter);
        modelandview.addObject("sex", sex);
        modelandview.addObject("house", house);
        modelandview.setViewName("result");
        return modelandview;
    }

    @GetMapping("/entry")
    public ModelAndView showEntry(){
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("entry");
        return modelandview;
    }

}
