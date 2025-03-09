package com.stockmanagements.category;
import jakarta.persistence.*;

@Entity
@Table(name = "bana_type_category")
public class BanaTypeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bana_id;
    private String bana_name;

    // Getters and Setters


    public Long getBana_id() {
        return bana_id;
    }

    public void setBana_id(Long bana_id) {
        this.bana_id = bana_id;
    }

    public String getBana_name() {
        return bana_name;
    }

    public void setBana_name(String bana_name) {
        this.bana_name = bana_name;
    }
}