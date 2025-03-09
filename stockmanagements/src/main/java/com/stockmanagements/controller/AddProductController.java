package com.stockmanagements.controller;

import com.stockmanagements.dto.AddProductDto;
import com.stockmanagements.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/add-product")
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    /**
     * Add a new product
     */
    @PostMapping
    public AddProductDto addProduct(@RequestBody AddProductDto addProductDto) {
        return addProductService.addProduct(addProductDto);
    }

    /**
     * Get all products
     */
    @GetMapping("/all")
    public List<AddProductDto> getAllProducts() {
        return addProductService.getAllProducts();
    }

    /**
     * Get product by ID
     */
    @GetMapping("/{id}")
    public AddProductDto getProductById(@PathVariable Long id) {
        return addProductService.getProductById(id);
    }

    /**
     * Delete a product by ID
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        addProductService.deleteProduct(id);
    }

    /**
     * Update an existing product
     */
    @PutMapping("/{id}")
    public AddProductDto updateProduct(@PathVariable Long id, @RequestBody AddProductDto addProductDto) {
        return addProductService.updateProduct(id, addProductDto);
    }
}
