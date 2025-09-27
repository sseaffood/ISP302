package com.g5.techdevices.techstore.entity.products;

import java.io.Serializable;
import java.util.Objects;

public class relatedProductId implements Serializable {
    private String productId;
    private String relatedId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof relatedProductId)) return false;
        relatedProductId that = (relatedProductId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(relatedId, that.relatedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, relatedId);
    }
}