package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StudentController {
    @PostMapping("/process")
    public ModelAndView processEntry(@ModelAttribute("student") Student student){
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("firstname", student.getFirstName());
        modelandview.addObject("newsletter", student.isReceiveNewsletter());
        modelandview.addObject("sex", student.getSex());
        modelandview.addObject("house", student.getHouse());
        modelandview.setViewName("result");
        return modelandview;
    }

    @GetMapping("/entry")
    public ModelAndView showEntry(){
        Student student = new Student();
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("student", student);
        modelandview.setViewName("entry");
        return modelandview;
    }

}
