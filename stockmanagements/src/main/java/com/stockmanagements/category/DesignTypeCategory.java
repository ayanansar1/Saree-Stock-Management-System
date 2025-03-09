package com.stockmanagements.category;

import com.stockmanagements.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "design_type_category")
public class DesignTypeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long design_id;

    private String design_name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User table
    private User user;

    private String status; // "active" or "inactive"

    // Getters and Setters
    public Long getDesign_id() {
        return design_id;
    }

    public void setDesign_id(Long design_id) {
        this.design_id = design_id;
    }

    public String getDesign_name() {
        return design_name;
    }

    public void setDesign_name(String design_name) {
        this.design_name = design_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
