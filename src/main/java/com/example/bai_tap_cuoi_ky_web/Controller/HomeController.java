package com.example.bai_tap_cuoi_ky_web.Controller;

import com.example.bai_tap_cuoi_ky_web.Entity.Category;
import com.example.bai_tap_cuoi_ky_web.Entity.Order;
import com.example.bai_tap_cuoi_ky_web.Entity.Product;
import com.example.bai_tap_cuoi_ky_web.Entity.User;
import com.example.bai_tap_cuoi_ky_web.Service.CategoryService;
import com.example.bai_tap_cuoi_ky_web.Service.CommentService;
import com.example.bai_tap_cuoi_ky_web.Service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService serviceP;

    @Autowired
    CategoryService serviceC;

    @Autowired
    CommentService commentService;

    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("products",serviceP.getProducts());
        model.addAttribute("categories",serviceC.getCategorys());
        model.addAttribute("lastProduct",serviceP.getLastProduct());
        return "Home";
    }

    @GetMapping("/category/{cid}")
    public String getCategory(@PathVariable("cid") int cid,Model model){
        model.addAttribute("products",serviceP.getProductByCate(serviceC.getCategoryById(cid).getCid()));
        model.addAttribute("categories",serviceC.getCategorys());
        model.addAttribute("lastProduct",serviceP.getLastProduct());
        return "Home";
    }
    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable("id") int id, HttpSession session){
        model.addAttribute("order",new Order());
        model.addAttribute("product",serviceP.getProductById(id));
        model.addAttribute("comments",commentService.cmFindByProductID(id));
        return "Detail";
    }

}
