package promotion;

public class productPromotionDTO {
    private String productId;
    private int promoId;

    public productPromotionDTO(){

    }
    public productPromotionDTO(String productId, int promoId) {
        this.productId = productId;
        this.promoId = promoId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public int getPromoId() {
        return promoId;
    }
    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }
}
