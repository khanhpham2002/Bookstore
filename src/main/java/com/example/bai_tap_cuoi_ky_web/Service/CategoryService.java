package com.example.bai_tap_cuoi_ky_web.Service;

import com.example.bai_tap_cuoi_ky_web.Entity.Category;
import com.example.bai_tap_cuoi_ky_web.Entity.Product;
import com.example.bai_tap_cuoi_ky_web.Interface.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<Category> getCategorys() {
        return repo.findAll();
    }


    public Category getCategoryById(int cid){
        try {
            return repo.findById(cid).get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
