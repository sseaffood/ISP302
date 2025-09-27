package com.g5.techdevices.techstore.entity.products;

import com.g5.techdevices.techstore.entity.promotions.Promotion;
import com.g5.techdevices.techstore.entity.users.BillDetail;
import com.g5.techdevices.techstore.entity.users.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "product_name", columnDefinition = "nvarchar(max)", nullable = false)
    private String name;

    @Column(name = "product_price", columnDefinition = "money", nullable = false)
    private BigDecimal price;

    @Column(name = "product_describe", columnDefinition = "nvarchar(max)", nullable = false)
    private String description;

    private Integer quantity;

    @Column(name = "img", length = 50, nullable = false)
    private String img;

    @OneToMany(mappedBy = "product")
    private List<BillDetail> billDetails;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;

    @OneToMany(mappedBy = "product")
    private List<ProductColor> colors;

    @OneToMany(mappedBy = "product")
    private List<ProductModel> models;

    @ManyToMany
    @JoinTable(
            name = "product_promotion",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "promo_id")
    )
    private List<Promotion> promotions;
}

