package com.example.bai_tap_cuoi_ky_web.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title",unique = true)
    private String title;

    @Lob
    @Column(name = "image",columnDefinition = "MEDIUMBLOB")
    private String image;

    @Column(name = "author")
    private String author;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_product_to_category"),
            name = "cateID",referencedColumnName = "cid")
    private Category category;

    @Column(name = "sold")
    private int sold;
}
