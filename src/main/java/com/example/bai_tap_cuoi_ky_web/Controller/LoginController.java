package com.example.bai_tap_cuoi_ky_web.Controller;

import com.example.bai_tap_cuoi_ky_web.Entity.User;
import com.example.bai_tap_cuoi_ky_web.Service.CategoryService;
import com.example.bai_tap_cuoi_ky_web.Service.ProductService;
import com.example.bai_tap_cuoi_ky_web.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class LoginController {
    @Autowired
    ProductService serviceP;

    @Autowired
    CategoryService serviceC;
    @Autowired
    UserService userService;


    @GetMapping("/Login")
    public String getLogin(Model model){
        model.addAttribute("user",new User());
        return "Login";
    }
    @GetMapping("/Register")
    public String getRegister(Model model){
        model.addAttribute("user",new User());
        return "Register";
    }
    @PostMapping("/submit_login")
    public String postLogin(Model model, @ModelAttribute("user") User user, HttpSession session){
        User tmp=userService.getUser(user.getEmail(),user.getPassword());
        if (tmp!=null){
            session.setAttribute("NAME",tmp);
            model.addAttribute("role",tmp.getRole());
            model.addAttribute("products",serviceP.getProducts());
            model.addAttribute("categories",serviceC.getCategorys());
            model.addAttribute("lastProduct",serviceP.getLastProduct());
            return "Home";
        }
        else{
            model.addAttribute("mess1","Wrong user or password");
            return "Login";
        }
    }

    @PostMapping("/submit_register")
    public String getRegister(Model model,@ModelAttribute("user") User user){
        if (userService.getUserByEmail(user.getEmail())==null) {
            userService.addUser(user);
            return "Login";
        }else {
            model.addAttribute("mess2","Email account already exists");
            return "Register";
        }
    }
    @GetMapping("/Logout")
    public String getLogout(HttpSession session,Model model){
        session.removeAttribute("NAME");
        model.addAttribute("products",serviceP.getProducts());
        model.addAttribute("categories",serviceC.getCategorys());
        model.addAttribute("lastProduct",serviceP.getLastProduct());
        return "redirect:/home";
    }
}
