package com.example.bai_tap_cuoi_ky_web.Interface;

import com.example.bai_tap_cuoi_ky_web.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> getProductByCategory_cid(int cid);
}
