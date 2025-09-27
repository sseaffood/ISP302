package com.g5.techdevices.techstore.entity.promotions;

import com.g5.techdevices.techstore.entity.products.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    private Integer id;

    @Column(name = "promo_name", nullable = false)
    private String name;

    @Column(name = "discount_percent", precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(name = "discount_amount", columnDefinition = "money")
    private BigDecimal discountAmount;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(name = "is_active")
    private Boolean active;

    @ManyToMany(mappedBy = "promotions")
    private List<Product> products;
}

