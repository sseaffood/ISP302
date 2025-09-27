package com.g5.techdevices.techstore.entity.users;

import com.g5.techdevices.techstore.entity.products.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer quantity;

    @Column(name = "model", length = 10, nullable = false)
    private String model;

    @Column(name = "color", length = 150, nullable = false)
    private String color;

    @Column(name = "price", columnDefinition = "money", nullable = false)
    private BigDecimal price;
}

