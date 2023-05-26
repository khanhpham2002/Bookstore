package com.example.bai_tap_cuoi_ky_web.Interface;

import com.example.bai_tap_cuoi_ky_web.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM user WHERE email = ?1 and password = ?2",nativeQuery = true)
    User findByUserPassword(String email,String password);

    @Query(value = "SELECT * FROM user WHERE email = ?1",nativeQuery = true)
    User findByEmail(String email);
}
