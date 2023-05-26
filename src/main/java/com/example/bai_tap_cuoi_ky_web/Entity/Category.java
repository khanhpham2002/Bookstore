package com.example.bai_tap_cuoi_ky_web.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private int cid;

    @Column(name = "category")
    private String category;
}
