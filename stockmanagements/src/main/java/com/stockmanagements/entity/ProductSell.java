package com.stockmanagements.entity;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.category.ProductItemCategory;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@Entity
@Table(name = "product_sell")
public class ProductSell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_sell_id")
    private Long productSellId;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_item_category_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductItemCategory productItemCategory;

    @ManyToOne
    @JoinColumn(name = "bana_type_category_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BanaTypeCategory banaTypeCategory;

    @ManyToOne
    @JoinColumn(name = "design_type_category_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DesignTypeCategory designTypeCategory;

    @Column(name = "meter_of_cloth", nullable = false)
    private Double meterOfCloth;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Column(name = "product_sell_date", nullable = false)
    private LocalDate productSellDate; // New field for product sell date

    // Getters and Setters
    public Long getProductSellId() {
        return productSellId;
    }

    public void setProductSellId(Long productSellId) {
        this.productSellId = productSellId;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductItemCategory getProductItemCategory() {
        return productItemCategory;
    }

    public void setProductItemCategory(ProductItemCategory productItemCategory) {
        this.productItemCategory = productItemCategory;
    }

    public BanaTypeCategory getBanaTypeCategory() {
        return banaTypeCategory;
    }

    public void setBanaTypeCategory(BanaTypeCategory banaTypeCategory) {
        this.banaTypeCategory = banaTypeCategory;
    }

    public DesignTypeCategory getDesignTypeCategory() {
        return designTypeCategory;
    }

    public void setDesignTypeCategory(DesignTypeCategory designTypeCategory) {
        this.designTypeCategory = designTypeCategory;
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