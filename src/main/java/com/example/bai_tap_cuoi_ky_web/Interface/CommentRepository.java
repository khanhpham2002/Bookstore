package com.example.bai_tap_cuoi_ky_web.Interface;

import com.example.bai_tap_cuoi_ky_web.Entity.Comment;
import com.example.bai_tap_cuoi_ky_web.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query(value = "SELECT * FROM comments WHERE cm_productID = ?1",nativeQuery = true)
    List<Comment> cmFindByProductID(Integer productID);

}
