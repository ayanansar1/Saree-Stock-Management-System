package com.stockmanagements.entity;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.category.ProductItemCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "product_stock_balance")
public class ProductStockBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_balance_id")
    private Long stockBalanceId;

    @ManyToOne
    @JoinColumn(name = "product_item_category_id", nullable = false)
    private ProductItemCategory productItemCategory;

    @ManyToOne
    @JoinColumn(name = "bana_type_category_id", nullable = false)
    private BanaTypeCategory banaTypeCategory;

    @ManyToOne
    @JoinColumn(name = "design_type_category_id", nullable = false)
    private DesignTypeCategory designTypeCategory;

    @Column(name = "total_meter_of_cloth", nullable = false)
    private Double totalMeterOfCloth;

    @Column(name = "total_product_quantity", nullable = false)
    private Integer totalProductQuantity;

    // Getters and Setters

    public Long getStockBalanceId() {
        return stockBalanceId;
    }

    public void setStockBalanceId(Long stockBalanceId) {
        this.stockBalanceId = stockBalanceId;
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

    public Double getTotalMeterOfCloth() {
        return totalMeterOfCloth;
    }

    public void setTotalMeterOfCloth(Double totalMeterOfCloth) {
        this.totalMeterOfCloth = totalMeterOfCloth;
    }

    public Integer getTotalProductQuantity() {
        return totalProductQuantity;
    }

    public void setTotalProductQuantity(Integer totalProductQuantity) {
        this.totalProductQuantity = totalProductQuantity;
    }
}