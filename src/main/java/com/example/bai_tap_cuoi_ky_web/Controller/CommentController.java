package com.example.bai_tap_cuoi_ky_web.Controller;

import com.example.bai_tap_cuoi_ky_web.Entity.Comment;
import com.example.bai_tap_cuoi_ky_web.Entity.Order;
import com.example.bai_tap_cuoi_ky_web.Entity.Product;
import com.example.bai_tap_cuoi_ky_web.Entity.User;
import com.example.bai_tap_cuoi_ky_web.Service.CommentService;
import com.example.bai_tap_cuoi_ky_web.Service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    ProductService productService;

    @Autowired
    CommentService commentService;


    @PostMapping("/comment")
    public String postComment(Model model, HttpSession session,
                              @RequestParam("comment") String comment,
                              @RequestParam("productID") int productID){
        Comment comment1=new Comment();
        User user=null;
        Object o=session.getAttribute("NAME");
        if(o!=null){
            user=(User) o;
            Product product=productService.getProductById(productID);
            comment1.setCm(comment);
            comment1.setProduct(product);
            comment1.setUser(user);
            commentService.addComment(comment1);
            return "redirect:/detail/" + Integer.toString(productID);
        }
        else {
            return "redirect:/Login";
        }
    }
}
