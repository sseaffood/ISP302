package com.g5.techdevices.techstore.entity.users;

import com.g5.techdevices.techstore.entity.products.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "product_img", nullable = false, length = 255)
    private String productImg;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    private Double total;

    private Integer quantity;
}

