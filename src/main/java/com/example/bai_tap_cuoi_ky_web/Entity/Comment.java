package com.example.bai_tap_cuoi_ky_web.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmID")
    private int cmID;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_comment_to_product"),
    name = "cmProductID",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_comment_to_user"),
            name = "cmUserID",referencedColumnName = "userID")
    private User user;

    @Column(name = "cm",columnDefinition = "TEXT")
    private String cm;
}
