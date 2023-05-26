package com.example.bai_tap_cuoi_ky_web.Entity;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    private int oid;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_order_to_user"),
            name = "customerID",referencedColumnName = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_order_to_product"),
            name = "productID",referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}
