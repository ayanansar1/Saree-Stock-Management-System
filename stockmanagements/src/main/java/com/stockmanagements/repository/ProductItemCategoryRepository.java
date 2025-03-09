package com.stockmanagements.repository;

import com.stockmanagements.category.ProductItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemCategoryRepository extends JpaRepository<ProductItemCategory,Long> {
}
