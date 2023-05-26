package com.example.bai_tap_cuoi_ky_web.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private int role;
}
