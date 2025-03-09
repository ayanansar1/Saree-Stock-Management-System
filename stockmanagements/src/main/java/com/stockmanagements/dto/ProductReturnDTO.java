package com.stockmanagements.dto;

import java.time.LocalDateTime;

public class ProductReturnDTO {
    private Long productReturnId;
    private Long sellerId;
    private Long userId;
    private Long productItemCategoryId;
    private Long banaTypeCategoryId;
    private Long designTypeCategoryId;
    private Double meterOfCloth;
    private Integer productQuantity;
    private String returnReason;
    private LocalDateTime returnDate;

    public Long getProductReturnId() {
        return productReturnId;
    }

    public void setProductReturnId(Long productReturnId) {
        this.productReturnId = productReturnId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductItemCategoryId() {
        return productItemCategoryId;
    }

    public void setProductItemCategoryId(Long productItemCategoryId) {
        this.productItemCategoryId = productItemCategoryId;
    }

    public Long getBanaTypeCategoryId() {
        return banaTypeCategoryId;
    }

    public void setBanaTypeCategoryId(Long banaTypeCategoryId) {
        this.banaTypeCategoryId = banaTypeCategoryId;
    }

    public Long getDesignTypeCategoryId() {
        return designTypeCategoryId;
    }

    public void setDesignTypeCategoryId(Long designTypeCategoryId) {
        this.designTypeCategoryId = designTypeCategoryId;
    }

    public Double getMeterOfCloth() {
        return meterOfCloth;
    }

    public void setMeterOfCloth(Double meterOfCloth) {
        this.meterOfCloth = meterOfCloth;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}

