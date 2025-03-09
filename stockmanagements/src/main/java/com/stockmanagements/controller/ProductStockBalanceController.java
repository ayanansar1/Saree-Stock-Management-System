package com.stockmanagements.controller;

import com.stockmanagements.entity.ProductStockBalance;
import com.stockmanagements.service.ProductStockBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-balance")
public class ProductStockBalanceController {

    @Autowired
    private ProductStockBalanceService productStockBalanceService;

    /**
     * Retrieves the stock balance for a specific product.
     *
     * @param productItemCategoryId The ID of the product item category.
     * @param banaTypeCategoryId    The ID of the bana type category.
     * @param designTypeCategoryId  The ID of the design type category.
     * @return The ProductStockBalance entity.
     */
    @GetMapping
    public ProductStockBalance getStockBalance(
            @RequestParam Long productItemCategoryId,
            @RequestParam Long banaTypeCategoryId,
            @RequestParam Long designTypeCategoryId) {
        return productStockBalanceService.getStockBalance(productItemCategoryId, banaTypeCategoryId, designTypeCategoryId);
    }

    /**
     * Retrieves all stock balances.
     *
     * @return A list of all ProductStockBalance entities.
     */
    @GetMapping("/all")
    public List<ProductStockBalance> getAllStockBalances() {
        return productStockBalanceService.getAllStockBalances();
    }
}