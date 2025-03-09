package com.stockmanagements.service;

import com.stockmanagements.dto.AddProductDto;
import com.stockmanagements.entity.AddProduct;
import com.stockmanagements.mapper.AddProductMapper;
import com.stockmanagements.repository.AddProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddProductService {

    @Autowired
    private AddProductRepository addProductRepository;

    @Autowired
    private ProductStockBalanceService productStockBalanceService;

    @Autowired
    private AddProductMapper addProductMapper;

    /**
     * Add a new product
     */
    @Transactional
    public AddProductDto addProduct(AddProductDto dto) {
        // Convert DTO to Entity
        AddProduct addProduct = addProductMapper.toEntity(dto);
        addProduct.setDate(LocalDateTime.now()); // Automatically set the current date/time

        // Save Product
        AddProduct savedProduct = addProductRepository.save(addProduct);

        // Automatically update stock balance
        productStockBalanceService.updateStockBalance(savedProduct);

        // Convert back to DTO
        return addProductMapper.toDto(savedProduct);
    }


    /**
     * Get all products
     */
    public List<AddProductDto> getAllProducts() {
        List<AddProduct> products = addProductRepository.findAll();
        return products.stream()
                .map(addProductMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Get product by ID
     */
    public AddProductDto getProductById(Long productId) {
        AddProduct product = addProductRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));
        return addProductMapper.toDto(product);
    }

    /**
     * Delete a product by ID
     */

    /**
     * Deletes a product and updates the stock balance accordingly.
     */
    @Transactional
    public void deleteProduct(Long productId) {
        // Check if the product exists
        AddProduct product = addProductRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));

        // Reverse stock balance before deleting the product
        productStockBalanceService.reverseStockBalance(product);

        // Delete the product
        addProductRepository.deleteById(productId);
    }

    /**
     * Update an existing product
     */
    @Transactional
    public AddProductDto updateProduct(Long productId, AddProductDto dto) {
        AddProduct existingProduct = addProductRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));

        // Update the product fields
        existingProduct.setProductItemCategory(addProductMapper.toEntity(dto).getProductItemCategory());
        existingProduct.setBanaTypeCategory(addProductMapper.toEntity(dto).getBanaTypeCategory());
        existingProduct.setDesignTypeCategory(addProductMapper.toEntity(dto).getDesignTypeCategory());
        existingProduct.setMeterOfCloth(dto.getMeterOfCloth());
        existingProduct.setProductQuantity(dto.getProductQuantity());
        existingProduct.setDate(LocalDateTime.now()); // Update the date

        AddProduct updatedProduct = addProductRepository.save(existingProduct);
        return addProductMapper.toDto(updatedProduct);
    }
}
