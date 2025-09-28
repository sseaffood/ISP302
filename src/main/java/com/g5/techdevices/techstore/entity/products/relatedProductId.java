package com.g5.techdevices.techstore.entity.products;
import java.io.Serializable;
import java.util.Objects;

public class relatedProductId implements Serializable {
    private Long productId;
    private Long relatedProductId;

    public relatedProductId() {}

    public relatedProductId(Long productId, Long relatedProductId) {
        this.productId = productId;
        this.relatedProductId = relatedProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof relatedProductId)) return false;
        relatedProductId that = (relatedProductId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(relatedProductId, that.relatedProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, relatedProductId);
    }
}
