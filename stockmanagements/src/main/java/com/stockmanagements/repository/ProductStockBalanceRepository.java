package com.stockmanagements.repository;

import com.stockmanagements.entity.ProductStockBalance;
import com.stockmanagements.category.ProductItemCategory;
import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductStockBalanceRepository extends JpaRepository<ProductStockBalance, Long> {
    Optional<ProductStockBalance> findByProductItemCategoryAndBanaTypeCategoryAndDesignTypeCategory(
            ProductItemCategory productItemCategory, BanaTypeCategory banaTypeCategory, DesignTypeCategory designTypeCategory);
}