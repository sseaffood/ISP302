package promotion;

import java.time.LocalDate;

public class promotionDTO {
    private int promoId;
    private String promoName;
    private double discountPercent;
    private double discountAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;

    public promotionDTO(){

    }
    public promotionDTO(int promoId,String promoName,double discountPercent,double discountAmount,LocalDate startDate,LocalDate endDate,boolean isActive){
        this.promoId = promoId;
        this.promoName = promoName;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }
    public int getPromoId() {
        return promoId;
    }
    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }
    public String getPromoName() {
        return promoName;
    }
    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }
    public double getDiscountPercent() {
        return discountPercent;
    }
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    public double getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
}
