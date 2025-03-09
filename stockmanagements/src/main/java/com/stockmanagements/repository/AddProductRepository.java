package com.stockmanagements.repository;

//import com.stockmanagements.dto.ProductSummaryDTO;
import com.stockmanagements.entity.AddProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddProductRepository extends JpaRepository<AddProduct,Long> {
//    @Query("SELECT new com.stockmanagements.dto.ProductSummaryDTO(" +
//            "u.user_id, u.user_name, dtc.design_name, btc.bana_name, pic.product_item_name, " +
//            "SUM(ap.product_quantity)) " +
//            "FROM AddProduct ap " +
//            "JOIN ap.bana_type_category btc " +
//            "JOIN ap.design_type_category dtc " +
//            "JOIN ap.product_item_category pic " +
//            "JOIN ap.user u " +
//            "GROUP BY u.userId, u.user_name, dtc.design_name, btc.bana_name, pic.product_item_name")

//    List<ProductSummaryDTO> getProductSummary();


    // Filter by banaTypeCategoryName and productItemCategoryName
    @Query("SELECT p FROM AddProduct p WHERE " +
            "(:banaTypeCategoryName IS NULL OR p.banaTypeCategory.bana_name = :banaTypeCategoryName) AND " +
            "(:productItemCategoryName IS NULL OR p.productItemCategory.product_item_name = :productItemCategoryName)")
    List<AddProduct> filterByBanaAndProductItemCategory(
            @Param("banaTypeCategoryName") String banaTypeCategoryName,
            @Param("productItemCategoryName") String productItemCategoryName
    );

    @Query("SELECT COALESCE(SUM(p.productQuantity), 0) FROM AddProduct p WHERE " +
            "(:banaTypeCategoryName IS NULL OR p.banaTypeCategory.bana_name = :banaTypeCategoryName) AND " +
            "(:productItemCategoryName IS NULL OR p.productItemCategory.product_item_name = :productItemCategoryName)")
    Long sumProductQuantities(
            @Param("banaTypeCategoryName") String banaTypeCategoryName,
            @Param("productItemCategoryName") String productItemCategoryName
    );
}
