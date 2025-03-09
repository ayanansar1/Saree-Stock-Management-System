package com.stockmanagements.service;

import com.stockmanagements.entity.*;
import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.category.ProductItemCategory;
import com.stockmanagements.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductStockBalanceService {

    @Autowired
    private ProductStockBalanceRepository productStockBalanceRepository;

    @Autowired
    private ProductItemCategoryRepository productItemCategoryRepository;

    @Autowired
    private BanaTypeCategoryRepository banaTypeCategoryRepository;

    @Autowired
    private DesignTypeCategoryRepository designTypeCategoryRepository;

    /**
     * Updates the stock balance when a product is added.
     */
    @Transactional
    public void updateStockBalance(AddProduct addProduct) {
        ProductStockBalance stockBalance = getOrCreateStockBalance(
                addProduct.getProductItemCategory(),
                addProduct.getBanaTypeCategory(),
                addProduct.getDesignTypeCategory()
        );

        stockBalance.setTotalMeterOfCloth(stockBalance.getTotalMeterOfCloth() + addProduct.getMeterOfCloth());
        stockBalance.setTotalProductQuantity(stockBalance.getTotalProductQuantity() + addProduct.getProductQuantity());

        productStockBalanceRepository.save(stockBalance);
    }

    /**
     * Updates the stock balance when a product is sold.
     */
    @Transactional
    public void updateStockBalance(ProductSell productSell) {
        ProductStockBalance stockBalance = getOrCreateStockBalance(
                productSell.getProductItemCategory(),
                productSell.getBanaTypeCategory(),
                productSell.getDesignTypeCategory()
        );

        stockBalance.setTotalMeterOfCloth(stockBalance.getTotalMeterOfCloth() - productSell.getMeterOfCloth());
        stockBalance.setTotalProductQuantity(stockBalance.getTotalProductQuantity() - productSell.getProductQuantity());

        productStockBalanceRepository.save(stockBalance);
    }

    /**
     * Updates the stock balance when a product is returned.
     */
    @Transactional
    public void updateStockBalance(ProductReturn productReturn) {
        ProductStockBalance stockBalance = getOrCreateStockBalance(
                productReturn.getProductItemCategory(),
                productReturn.getBanaTypeCategory(),
                productReturn.getDesignTypeCategory()
        );

        stockBalance.setTotalMeterOfCloth(stockBalance.getTotalMeterOfCloth() + productReturn.getMeterOfCloth());
        stockBalance.setTotalProductQuantity(stockBalance.getTotalProductQuantity() + productReturn.getProductQuantity());

        productStockBalanceRepository.save(stockBalance);
    }

    /**
     * Reverses the stock balance update when a product is deleted.
     */
    @Transactional
    public void reverseStockBalance(AddProduct addProduct) {
        ProductStockBalance stockBalance = getOrCreateStockBalance(
                addProduct.getProductItemCategory(),
                addProduct.getBanaTypeCategory(),
                addProduct.getDesignTypeCategory()
        );

        stockBalance.setTotalMeterOfCloth(stockBalance.getTotalMeterOfCloth() - addProduct.getMeterOfCloth());
        stockBalance.setTotalProductQuantity(stockBalance.getTotalProductQuantity() - addProduct.getProductQuantity());

        productStockBalanceRepository.save(stockBalance);
    }
    /**
     * Retrieves the stock balance for a specific product.
     */
    public ProductStockBalance getStockBalance(Long productItemCategoryId, Long banaTypeCategoryId, Long designTypeCategoryId) {
        ProductItemCategory productItemCategory = productItemCategoryRepository.findById(productItemCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Product Item Category ID: " + productItemCategoryId));

        BanaTypeCategory banaTypeCategory = banaTypeCategoryRepository.findById(banaTypeCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Bana Type Category ID: " + banaTypeCategoryId));

        DesignTypeCategory designTypeCategory = designTypeCategoryRepository.findById(designTypeCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Design Type Category ID: " + designTypeCategoryId));

        return productStockBalanceRepository.findByProductItemCategoryAndBanaTypeCategoryAndDesignTypeCategory(
                productItemCategory, banaTypeCategory, designTypeCategory
        ).orElseThrow(() -> new IllegalArgumentException("Stock Balance not found for the provided categories."));
    }

    /**
     * Retrieves all stock balances.
     */
    public List<ProductStockBalance> getAllStockBalances() {
        return productStockBalanceRepository.findAll();
    }

    /**
     * Retrieves or creates a ProductStockBalance entity for the given categories.
     */
    private ProductStockBalance getOrCreateStockBalance(ProductItemCategory productItemCategory, BanaTypeCategory banaTypeCategory, DesignTypeCategory designTypeCategory) {
        return productStockBalanceRepository.findByProductItemCategoryAndBanaTypeCategoryAndDesignTypeCategory(
                productItemCategory, banaTypeCategory, designTypeCategory
        ).orElseGet(() -> {
            ProductStockBalance newStockBalance = new ProductStockBalance();
            newStockBalance.setProductItemCategory(productItemCategory);
            newStockBalance.setBanaTypeCategory(banaTypeCategory);
            newStockBalance.setDesignTypeCategory(designTypeCategory);
            newStockBalance.setTotalMeterOfCloth(0.0);
            newStockBalance.setTotalProductQuantity(0);
            return newStockBalance;
        });
    }
}
