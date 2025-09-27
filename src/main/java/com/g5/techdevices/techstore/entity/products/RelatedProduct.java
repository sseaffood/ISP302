package com.g5.techdevices.techstore.entity.products;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "related_product")
@IdClass(relatedProductId.class)
public class RelatedProduct {

    @Id
    @Column(name = "product_id", length = 100)
    private String productId;

    @Id
    @Column(name = "related_id", length = 100)
    private String relatedId;

    // Quan hệ
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "related_id", insertable = false, updatable = false)
    private Product relatedProduct;
}