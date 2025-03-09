//package com.stockmanagements.mapper;
//
//import com.stockmanagements.category.BanaTypeCategory;
//import com.stockmanagements.category.DesignTypeCategory;
//import com.stockmanagements.category.ProductItemCategory;
//import com.stockmanagements.dto.ProductSellDTO;
//import com.stockmanagements.entity.ProductSell;
//import com.stockmanagements.entity.Seller;
//import com.stockmanagements.entity.User;
//import com.stockmanagements.repository.*;
//
//public class ProductSellMapper {
//
//    // Convert Entity to DTO
//    public static ProductSellDTO toDTO(ProductSell productSell) {
//        if (productSell == null) {
//            return null;
//        }
//
//        ProductSellDTO dto = new ProductSellDTO();
//        dto.setProductSellId(productSell.getProductSellId());
//        dto.setSellerId(productSell.getSeller().getSellerId());
//        dto.setUserId(productSell.getUser().getUserId());
//        dto.setProductItemCategoryId(productSell.getProductItemCategory().getProduct_item_id());
//        dto.setBanaTypeCategoryId(productSell.getBanaTypeCategory().getBana_id());
//        dto.setDesignTypeCategoryId(productSell.getDesignTypeCategory().getDesign_id());
//        dto.setMeterOfCloth(productSell.getMeterOfCloth());
//        dto.setProductQuantity(productSell.getProductQuantity());
//        dto.setProductSellDate(productSell.getProductSellDate());
//
//        return dto;
//    }
//
//    // Convert DTO to Entity
//    public static ProductSell toEntity(ProductSellDTO dto,
//                                       SellerRepository sellerRepository,
//                                       UserRepository userRepository,
//                                       ProductItemCategoryRepository productItemCategoryRepository,
//                                       BanaTypeCategoryRepository banaTypeCategoryRepository,
//                                       DesignTypeCategoryRepository designTypeCategoryRepository) {
//        if (dto == null) {
//            return null;
//        }
//
//        ProductSell productSell = new ProductSell();
//        productSell.setProductSellId(dto.getProductSellId());
//
//        // Fetching Seller entity from repository
//        Seller seller = sellerRepository.findById(dto.getSellerId())
//                .orElseThrow(() -> new RuntimeException("Seller not found with ID: " + dto.getSellerId()));
//        productSell.setSeller(seller);
//
//        // Fetching User entity from repository
//        User user = userRepository.findById(dto.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
//        productSell.setUser(user);
//
//        // Fetching Product Item Category entity
//        ProductItemCategory productItemCategory = productItemCategoryRepository.findById(dto.getProductItemCategoryId())
//                .orElseThrow(() -> new RuntimeException("Product Item Category not found with ID: " + dto.getProductItemCategoryId()));
//        productSell.setProductItemCategory(productItemCategory);
//
//        // Fetching Bana Type Category entity
//        BanaTypeCategory banaTypeCategory = banaTypeCategoryRepository.findById(dto.getBanaTypeCategoryId())
//                .orElseThrow(() -> new RuntimeException("Bana Type Category not found with ID: " + dto.getBanaTypeCategoryId()));
//        productSell.setBanaTypeCategory(banaTypeCategory);
//
//        // Fetching Design Type Category entity
//        DesignTypeCategory designTypeCategory = designTypeCategoryRepository.findById(dto.getDesignTypeCategoryId())
//                .orElseThrow(() -> new RuntimeException("Design Type Category not found with ID: " + dto.getDesignTypeCategoryId()));
//        productSell.setDesignTypeCategory(designTypeCategory);
//
//        // Setting other fields
//        productSell.setMeterOfCloth(dto.getMeterOfCloth());
//        productSell.setProductQuantity(dto.getProductQuantity());
//        productSell.setProductSellDate(dto.getProductSellDate());
//
//        return productSell;
//    }
//}
//
////package com.stockmanagements.mapper;
////
////import com.stockmanagements.category.BanaTypeCategory;
////import com.stockmanagements.category.DesignTypeCategory;
////import com.stockmanagements.category.ProductItemCategory;
////import com.stockmanagements.dto.ProductSellDTO;
////import com.stockmanagements.entity.ProductSell;
////import com.stockmanagements.entity.Seller;
////import com.stockmanagements.entity.User;
////import com.stockmanagements.repository.*;
////
////public class ProductSellMapper {
////
////    // Convert Entity to DTO
////    public static ProductSellDTO toDTO(ProductSell productSell) {
////        if (productSell == null) {
////            return null;
////        }
////
////        ProductSellDTO dto = new ProductSellDTO();
////        dto.setProductSellId(productSell.getProductSellId());
////        dto.setSellerId(productSell.getSeller().getSellerId());
////        dto.setUserId(productSell.getUser().getUserId());
////        dto.setProductItemCategoryId(productSell.getProductItemCategory().getProduct_item_id());
////        dto.setBanaTypeCategoryId(productSell.getBanaTypeCategory().getBana_id());
////        dto.setDesignTypeCategoryId(productSell.getDesignTypeCategory().getDesign_id());
////        dto.setMeterOfCloth(productSell.getMeterOfCloth());
////        dto.setProductQuantity(productSell.getProductQuantity());
////        dto.setProductSellDate(productSell.getProductSellDate());
////
////        return dto;
////    }
////
////    // Convert DTO to Entity
////    public static ProductSell toEntity(ProductSellDTO dto,
////                                       SellerRepository sellerRepository,
////                                       UserRepository userRepository,
////                                       ProductItemCategoryRepository productItemCategoryRepository,
////                                       BanaTypeCategoryRepository banaTypeCategoryRepository,
////                                       DesignTypeCategoryRepository designTypeCategoryRepository) {
////        if (dto == null) {
////            return null;
////        }
////
////        ProductSell productSell = new ProductSell();
////        productSell.setProductSellId(dto.getProductSellId());
////
////        // Fetching Seller entity from repository
////        Seller seller = sellerRepository.findById(dto.getSellerId()).orElse(null);
////        productSell.setSeller(seller);
////
////        // Fetching User entity from repository
////        User user = userRepository.findById(dto.getUserId()).orElse(null);
////        productSell.setUser(user);
////
////        // Fetching Product Item Category entity
////        ProductItemCategory productItemCategory = productItemCategoryRepository.findById(dto.getProductItemCategoryId()).orElse(null);
////        productSell.setProductItemCategory(productItemCategory);
////
////        // Fetching Bana Type Category entity
////        BanaTypeCategory banaTypeCategory = banaTypeCategoryRepository.findById(dto.getBanaTypeCategoryId()).orElse(null);
////        productSell.setBanaTypeCategory(banaTypeCategory);
////
////        // Fetching Design Type Category entity
////        DesignTypeCategory designTypeCategory = designTypeCategoryRepository.findById(dto.getDesignTypeCategoryId()).orElse(null);
////        productSell.setDesignTypeCategory(designTypeCategory);
////
////        // Setting other fields
////        productSell.setMeterOfCloth(dto.getMeterOfCloth());
////        productSell.setProductQuantity(dto.getProductQuantity());
////        productSell.setProductSellDate(dto.getProductSellDate());
////
////        return productSell;
////    }
////}
