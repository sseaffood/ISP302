package com.g5.techdevices.techstore.entity.products;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RelatedProduct")
@IdClass(relatedProductId.class)
public class RelatedProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "RelatedProductId")
    private Product relatedProduct;
}
