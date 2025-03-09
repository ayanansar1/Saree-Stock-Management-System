package com.stockmanagements.entity;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.category.ProductItemCategory;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "add_product")
public class AddProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

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

    @Column(name = "date", nullable = false) // Changed from added_date to date
    private LocalDateTime date;

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
