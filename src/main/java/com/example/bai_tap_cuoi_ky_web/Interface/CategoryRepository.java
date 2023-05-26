package com.example.bai_tap_cuoi_ky_web.Interface;

import com.example.bai_tap_cuoi_ky_web.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
