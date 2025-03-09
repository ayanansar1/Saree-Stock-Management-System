package com.stockmanagements.dto;

import java.time.LocalDateTime;

public class AddProductDto {
    private Long productId;
    private Long productItemCategoryId;
    private Long banaTypeCategoryId;
    private Long designTypeCategoryId;
    private Double meterOfCloth;
    private Integer productQuantity;
    private LocalDateTime date;  // Renamed from addedDate to date

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
