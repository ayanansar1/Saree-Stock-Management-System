package com.stockmanagements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.stockmanagements.category.BanaTypeCategory;

public interface BanaTypeCategoryRepository extends JpaRepository<BanaTypeCategory,Long> {
}
