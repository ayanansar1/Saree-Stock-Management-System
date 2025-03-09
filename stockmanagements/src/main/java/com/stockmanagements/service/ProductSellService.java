//package com.stockmanagements.service;
//
//import com.stockmanagements.dto.ProductSellDTO;
//import com.stockmanagements.entity.*;
//import com.stockmanagements.mapper.ProductSellMapper;
//import com.stockmanagements.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductSellService {
//
//    @Autowired
//    private ProductSellRepository productSellRepository;
//
//    @Autowired
//    private SellerRepository sellerRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ProductItemCategoryRepository productItemCategoryRepository;
//
//    @Autowired
//    private BanaTypeCategoryRepository banaTypeCategoryRepository;
//
//    @Autowired
//    private DesignTypeCategoryRepository designTypeCategoryRepository;
//
//    // Create or Update Product Sell
//    public ProductSellDTO saveProductSell(ProductSellDTO productSellDTO) {
//        ProductSell productSell = ProductSellMapper.toEntity(productSellDTO,
//                sellerRepository, userRepository,
//                productItemCategoryRepository, banaTypeCategoryRepository,
//                designTypeCategoryRepository);
//
//        productSell = productSellRepository.save(productSell);
//        return ProductSellMapper.toDTO(productSell);
//    }
//
//    // Get all Product Sells
//    public List<ProductSellDTO> getAllProductSells() {
//        List<ProductSell> productSells = productSellRepository.findAll();
//        return productSells.stream().map(ProductSellMapper::toDTO).collect(Collectors.toList());
//    }
//
//    // Get Product Sell by ID
//    public ProductSellDTO getProductSellById(Long id) {
//        Optional<ProductSell> productSell = productSellRepository.findById(id);
//        return productSell.map(ProductSellMapper::toDTO).orElse(null);
//    }
//
//    // Delete Product Sell
//    public boolean deleteProductSell(Long id) {
//        if (productSellRepository.existsById(id)) {
//            productSellRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//}
