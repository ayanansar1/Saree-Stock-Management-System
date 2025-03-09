package com.stockmanagements.repository;

import com.stockmanagements.entity.ProductReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductReturnRepository extends JpaRepository<ProductReturn,Long> {

    @Query("SELECT COALESCE(SUM(pr.productQuantity), 0) FROM ProductReturn pr WHERE pr.productItemCategory.product_item_id = :productItemCategoryId")
    Optional<Integer> getTotalReturnedQuantity(@Param("productItemCategoryId") Long productItemCategoryId);
}
