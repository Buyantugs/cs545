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
public class CarController {

    @PostMapping("/add")
    public ModelAndView add( HttpSession session, @ModelAttribute("car") Car car) {
        Map<String, Object> params = new HashMap<>();
        if (car != null) {
            //get the carlist from the session
            Map<String, Car> carList = (Map<String, Car>) session.getAttribute("carList");
            //if there is no carlist in the session, create one.
            if (carList == null) {
                carList = new HashMap<String, Car>();
                session.setAttribute("carList", carList);
            }
            //add the car to the carlist
            carList.put(car.getLicense(), car);
            params.put("carList", carList.values());
        }
        return new ModelAndView("cars", params);
    }

    @GetMapping("/cars")
    public ModelAndView init(HttpSession session) {
        //get the carlist from the session
        Map<String, Car> carList = (Map<String, Car>) session.getAttribute("carList");
        //if there is no carlist in the session, create one.
        if (carList == null) {
            carList = new HashMap<String, Car>();
            session.setAttribute("carList", carList);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("carList", carList.values());
        return new ModelAndView("cars", params);
    }

    @PostMapping("/addcar")
    public ModelAndView addcar(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("car", new Car());
        return new ModelAndView("addcar", params);
    }

    @PostMapping("/removecar")
    public ModelAndView removecar(@RequestParam("licence") String license, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        if (license != null) {
            //get the carlist from the session
            Map<String, Car> carList = (Map<String, Car>) session.getAttribute("carList");
            //if there is no carlist in the session, create one.
            if (carList == null) {
                carList = new HashMap<String, Car>();
                session.setAttribute("carList", carList);
            }
            //add the car to the carlist
            carList.remove(license);
            params.put("carList", carList.values());
        }
        return new ModelAndView("cars", params);
    }
}
