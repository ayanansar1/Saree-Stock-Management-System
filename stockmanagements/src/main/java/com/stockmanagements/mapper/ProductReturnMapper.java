//package com.stockmanagements.mapper;
//
//import com.stockmanagements.dto.ProductReturnDTO;
//import com.stockmanagements.entity.ProductReturn;
//import com.stockmanagements.entity.Seller;
//import com.stockmanagements.entity.User;
//import com.stockmanagements.category.BanaTypeCategory;
//import com.stockmanagements.category.DesignTypeCategory;
//import com.stockmanagements.category.ProductItemCategory;
//import com.stockmanagements.repository.*;
//
//public class ProductReturnMapper {
//
//    // Convert Entity to DTO
//    public static ProductReturnDTO toDTO(ProductReturn productReturn) {
//        if (productReturn == null) {
//            return null;
//        }
//
//        ProductReturnDTO dto = new ProductReturnDTO();
//        dto.setProductReturnId(productReturn.getProductReturnId());
//        dto.setSellerId(productReturn.getSeller().getSellerId());
//        dto.setUserId(productReturn.getUser().getUserId());
//        dto.setProductItemCategoryId(productReturn.getProductItemCategory().getProduct_item_id());
//        dto.setBanaTypeCategoryId(productReturn.getBanaTypeCategory().getBana_id());
//        dto.setDesignTypeCategoryId(productReturn.getDesignTypeCategory().getDesign_id());
//        dto.setMeterOfCloth(productReturn.getMeterOfCloth());
//        dto.setProductQuantity(productReturn.getProductQuantity());
//        dto.setReturnReason(productReturn.getReturnReason());
//        dto.setReturnDate(productReturn.getReturnDate());
//
//        return dto;
//    }
//
//    // Convert DTO to Entity
//    public static ProductReturn toEntity(ProductReturnDTO dto,
//                                         SellerRepository sellerRepository,
//                                         UserRepository userRepository,
//                                         ProductItemCategoryRepository productItemCategoryRepository,
//                                         BanaTypeCategoryRepository banaTypeCategoryRepository,
//                                         DesignTypeCategoryRepository designTypeCategoryRepository) {
//        if (dto == null) {
//            return null;
//        }
//
//        ProductReturn productReturn = new ProductReturn();
//        productReturn.setProductReturnId(dto.getProductReturnId());
//
//        // Fetching Seller entity from repository
//        Seller seller = sellerRepository.findById(dto.getSellerId())
//                .orElseThrow(() -> new RuntimeException("Seller not found with ID: " + dto.getSellerId()));
//        productReturn.setSeller(seller);
//
//        // Fetching User entity from repository
//        User user = userRepository.findById(dto.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
//        productReturn.setUser(user);
//
//        // Fetching Product Item Category entity
//        ProductItemCategory productItemCategory = productItemCategoryRepository.findById(dto.getProductItemCategoryId())
//                .orElseThrow(() -> new RuntimeException("Product Item Category not found with ID: " + dto.getProductItemCategoryId()));
//        productReturn.setProductItemCategory(productItemCategory);
//
//        // Fetching Bana Type Category entity
//        BanaTypeCategory banaTypeCategory = banaTypeCategoryRepository.findById(dto.getBanaTypeCategoryId())
//                .orElseThrow(() -> new RuntimeException("Bana Type Category not found with ID: " + dto.getBanaTypeCategoryId()));
//        productReturn.setBanaTypeCategory(banaTypeCategory);
//
//        // Fetching Design Type Category entity
//        DesignTypeCategory designTypeCategory = designTypeCategoryRepository.findById(dto.getDesignTypeCategoryId())
//                .orElseThrow(() -> new RuntimeException("Design Type Category not found with ID: " + dto.getDesignTypeCategoryId()));
//        productReturn.setDesignTypeCategory(designTypeCategory);
//
//        // Setting other fields
//        productReturn.setMeterOfCloth(dto.getMeterOfCloth());
//        productReturn.setProductQuantity(dto.getProductQuantity());
//        productReturn.setReturnReason(dto.getReturnReason());
//        productReturn.setReturnDate(dto.getReturnDate());
//
//        return productReturn;
//    }
//}