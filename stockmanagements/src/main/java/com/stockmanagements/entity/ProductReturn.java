package com.stockmanagements.entity;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.category.ProductItemCategory;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_return")
public class ProductReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_return_id")
    private Long productReturnId;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_item_category_id", nullable = false)
    private ProductItemCategory productItemCategory;

    @ManyToOne
    @JoinColumn(name = "bana_type_category_id", nullable = false)
    private BanaTypeCategory banaTypeCategory;

    @ManyToOne
    @JoinColumn(name = "design_type_category_id", nullable = false)
    private DesignTypeCategory designTypeCategory;

    @Column(name = "meter_of_cloth", nullable = false)
    private Double meterOfCloth;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Column(name = "return_reason", nullable = false)
    private String returnReason;

    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate;

    public Long getProductReturnId() {
        return productReturnId;
    }

    public void setProductReturnId(Long productReturnId) {
        this.productReturnId = productReturnId;
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
