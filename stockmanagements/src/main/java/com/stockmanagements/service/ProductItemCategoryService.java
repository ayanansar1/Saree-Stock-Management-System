package com.stockmanagements.service;

import com.stockmanagements.category.ProductItemCategory;
import com.stockmanagements.repository.ProductItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemCategoryService {

    @Autowired
    private ProductItemCategoryRepository productItemCategoryRepository;

    // Create ProductItemCategory
    public ProductItemCategory createProductItemCategory(ProductItemCategory productItemCategory) {
        return productItemCategoryRepository.save(productItemCategory);
    }

    // Get All ProductItemCategories
    public List<ProductItemCategory> getAllProductItemCategories() {
        return productItemCategoryRepository.findAll();
    }

    // Get ProductItemCategory by ID
    public Optional<ProductItemCategory> getProductItemCategoryById(Long id) {
        return productItemCategoryRepository.findById(id);
    }

    // Update ProductItemCategory
    public ProductItemCategory updateProductItemCategory(Long id, ProductItemCategory updatedItem) {
        return productItemCategoryRepository.findById(id)
                .map(item -> {
                    item.setProduct_item_name(updatedItem.getProduct_item_name());
                    return productItemCategoryRepository.save(item);
                })
                .orElseGet(() -> {
                    updatedItem.setProduct_item_id(id);
                    return productItemCategoryRepository.save(updatedItem);
                });
    }

    // Delete ProductItemCategory
    public void deleteProductItemCategory(Long id) {
        productItemCategoryRepository.deleteById(id);
    }
}
