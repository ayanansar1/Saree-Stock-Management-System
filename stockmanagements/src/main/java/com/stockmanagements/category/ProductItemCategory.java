package com.stockmanagements.category;


import jakarta.persistence.*;

@Entity
@Table(name = "product_item_category")
public class ProductItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_item_id;
    private String product_item_name;

    // Getters and Setters


    public Long getProduct_item_id() {
        return product_item_id;
    }

    public void setProduct_item_id(Long product_item_id) {
        this.product_item_id = product_item_id;
    }

    public String getProduct_item_name() {
        return product_item_name;
    }

    public void setProduct_item_name(String product_item_name) {
        this.product_item_name = product_item_name;
    }
}

