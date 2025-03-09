package com.stockmanagements.mapper;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.category.ProductItemCategory;
import com.stockmanagements.dto.AddProductDto;
import com.stockmanagements.entity.AddProduct;
import com.stockmanagements.repository.BanaTypeCategoryRepository;
import com.stockmanagements.repository.DesignTypeCategoryRepository;
import com.stockmanagements.repository.ProductItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductMapper {

    @Autowired
    private ProductItemCategoryRepository productItemCategoryRepository;

    @Autowired
    private BanaTypeCategoryRepository banaTypeCategoryRepository;

    @Autowired
    private DesignTypeCategoryRepository designTypeCategoryRepository;

    public AddProduct toEntity(AddProductDto dto) {
        AddProduct addProduct = new AddProduct();

        addProduct.setProductId(dto.getProductId());
        addProduct.setProductItemCategory(productItemCategoryRepository.findById(dto.getProductItemCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ProductItemCategory ID")));
        addProduct.setBanaTypeCategory(banaTypeCategoryRepository.findById(dto.getBanaTypeCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid BanaTypeCategory ID")));
        addProduct.setDesignTypeCategory(designTypeCategoryRepository.findById(dto.getDesignTypeCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid DesignTypeCategory ID")));
        addProduct.setMeterOfCloth(dto.getMeterOfCloth());
        addProduct.setProductQuantity(dto.getProductQuantity());
        addProduct.setDate(dto.getDate()); // Changed here

        return addProduct;
    }

    public AddProductDto toDto(AddProduct addProduct) {
        AddProductDto dto = new AddProductDto();

        dto.setProductId(addProduct.getProductId());
        dto.setProductItemCategoryId(addProduct.getProductItemCategory().getProduct_item_id());
        dto.setBanaTypeCategoryId(addProduct.getBanaTypeCategory().getBana_id());
        dto.setDesignTypeCategoryId(addProduct.getDesignTypeCategory().getDesign_id());
        dto.setMeterOfCloth(addProduct.getMeterOfCloth());
        dto.setProductQuantity(addProduct.getProductQuantity());
        dto.setDate(addProduct.getDate()); // Changed here

        return dto;
    }
}


