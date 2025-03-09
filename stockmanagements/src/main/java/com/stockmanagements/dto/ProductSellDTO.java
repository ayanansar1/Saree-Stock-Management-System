package com.stockmanagements.dto;

import java.time.LocalDate;

public class ProductSellDTO {

    private Long productSellId;
    private Long sellerId;
    private Long userId;
    private Long productItemCategoryId;
    private Long banaTypeCategoryId;
    private Long designTypeCategoryId;
    private Double meterOfCloth;
    private Integer productQuantity;
    private LocalDate productSellDate; // Renamed sellDate to productSellDate

    // Getters and Setters
    public Long getProductSellId() {
        return productSellId;
    }

    public void setProductSellId(Long productSellId) {
        this.productSellId = productSellId;
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

    public LocalDate getProductSellDate() {
        return productSellDate;
    }

    public void setProductSellDate(LocalDate productSellDate) {
        this.productSellDate = productSellDate;
    }
}
