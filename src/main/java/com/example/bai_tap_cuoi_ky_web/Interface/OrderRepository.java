package com.example.bai_tap_cuoi_ky_web.Interface;

import com.example.bai_tap_cuoi_ky_web.Entity.Order;
import com.example.bai_tap_cuoi_ky_web.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT * FROM orders WHERE customerID = ?1",nativeQuery = true)
    List<Order> findByCustomerID(Integer customerID);

    @Query(value = "SELECT * FROM orders WHERE productID = ?1",nativeQuery = true)
    List<Order> findByProductID(Integer productID);

}
