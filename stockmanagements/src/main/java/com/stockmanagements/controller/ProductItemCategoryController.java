package com.stockmanagements.controller;

import com.stockmanagements.category.ProductItemCategory;
import com.stockmanagements.service.ProductItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-item-categories")
public class ProductItemCategoryController {

    @Autowired
    private ProductItemCategoryService productItemCategoryService;

    // Create ProductItemCategory
    @PostMapping
    public ResponseEntity<ProductItemCategory> createProductItemCategory(@RequestBody ProductItemCategory productItemCategory) {
        return ResponseEntity.ok(productItemCategoryService.createProductItemCategory(productItemCategory));
    }

    // Get All ProductItemCategories
    @GetMapping
    public ResponseEntity<List<ProductItemCategory>> getAllProductItemCategories() {
        return ResponseEntity.ok(productItemCategoryService.getAllProductItemCategories());
    }

    // Get ProductItemCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductItemCategory> getProductItemCategoryById(@PathVariable Long id) {
        Optional<ProductItemCategory> productItemCategory = productItemCategoryService.getProductItemCategoryById(id);
        return productItemCategory.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update ProductItemCategory
    @PutMapping("/{id}")
    public ResponseEntity<ProductItemCategory> updateProductItemCategory(@PathVariable Long id, @RequestBody ProductItemCategory updatedItem) {
        return ResponseEntity.ok(productItemCategoryService.updateProductItemCategory(id, updatedItem));
    }

    // Delete ProductItemCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductItemCategory(@PathVariable Long id) {
        productItemCategoryService.deleteProductItemCategory(id);
        return ResponseEntity.noContent().build();
    }
}

