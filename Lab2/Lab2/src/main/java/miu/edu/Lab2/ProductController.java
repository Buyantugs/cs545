package miu.edu.Lab2;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    @GetMapping("/products")
    public ModelAndView init (HttpSession session){
        Map<String, Product> productList=(Map<String, Product>) session.getAttribute("productList");

        if (productList == null) {
            productList = new HashMap<String, Product>();
            session.setAttribute("productList", productList);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("productList", productList.values());
        return new ModelAndView("products", params);

    }

    @GetMapping("/showcart")
    public ModelAndView showcart(HttpSession session){
        Map<String, Cart> cartList=(Map<String, Cart>) session.getAttribute("cartList");

        Double totalAmount= (Double) session.getAttribute("totalPrice");

        if (cartList == null) {
            cartList = new HashMap<String, Cart>();
            session.setAttribute("cartList", cartList);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("cartList", cartList.values());
        params.put("totalPrice",totalAmount);

        return new ModelAndView("showcart",params);
    }

    @PostMapping("/addproduct")
    public ModelAndView addproduct(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("product", new Product());

        //System.out.println("Serial="+product.getSerial());

        return new ModelAndView("addproduct", params);
    }

    @PostMapping("/addcart")
    public ModelAndView addcart(@RequestParam("serial") String serial, HttpSession session, @ModelAttribute("cart") Cart cart ) {
        Map<String, Object> params = new HashMap<>();
        double totalPrice = 0;

        Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");

       Product p= productList.get(serial);
       Cart c=new Cart(1,p);

        if (cart != null) {

            Map<String, Cart> cartList = (Map<String, Cart>) session.getAttribute("cartList");

            if (cartList == null) {
                cartList = new HashMap<String, Cart>();
                session.setAttribute("cartList", cartList);
            }

            if(cartList.get(serial)!=null) {
                int qty=cartList.get(serial).getQuantity();
                cartList.get(serial).setQuantity(qty+1);
            }else
                cartList.put(serial, c);

            if (cartList != null) {
                for (Cart cart1 : cartList.values()) {
                    totalPrice += cart1.getProduct().getPrice() * cart1.getQuantity();
                }
            }

            session.setAttribute("totalPrice", totalPrice);
            params.put("cartList", cartList.values());
        }

        return new ModelAndView("redirect:showcart", params);
    }

    @PostMapping("/add")
    public ModelAndView add(HttpSession session, @ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        Map<String, Object> params = new HashMap<>();

        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mav.setViewName("addproduct");
            return mav;
        }

        if (product != null) {

            Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");

            if (productList == null) {
                productList = new HashMap<String, Product>();
                session.setAttribute("productList", productList);
            }
            productList.put(product.getSerial(), product);
            params.put("productList", productList.values());
        }

        System.out.println("Serial="+product.getSerial());

        return new ModelAndView("redirect:products", params);
    }

    @PostMapping("/removeproduct")
    public ModelAndView removeproduct(@RequestParam("serial") String serial, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        if (serial != null) {

            Map<String, Product> productList = (Map<String, Product>) session.getAttribute("productList");

            if (productList == null) {
                productList = new HashMap<String, Product>();
                session.setAttribute("productList", productList);
            }

            productList.remove(serial);
            params.put("productList", productList.values());
        }
        return new ModelAndView("redirect:products", params);
    }

    @PostMapping("/removecart")
    public ModelAndView removecart(@RequestParam("serial") String serial, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        double totalPrice = 0;

        if (serial != null) {

            Map<String, Cart> cartList = (Map<String, Cart>) session.getAttribute("cartList");

            if (cartList == null) {
                cartList = new HashMap<String, Cart>();
                session.setAttribute("cartList", cartList);
            }

            if(cartList.get(serial)!=null) {
                int qty=cartList.get(serial).getQuantity();
                if (qty>1)
                    cartList.get(serial).setQuantity(qty-1);
                else
                    cartList.remove(serial);
            }

            if (cartList != null) {
                for (Cart cart : cartList.values()) {
                    totalPrice += cart.getProduct().getPrice() * cart.getQuantity();
                }
            }

            params.put("cartList", cartList.values());
            session.setAttribute("totalPrice", totalPrice);
        }
        return new ModelAndView("redirect:showcart", params);
    }
}
