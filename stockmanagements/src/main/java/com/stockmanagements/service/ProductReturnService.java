//package com.stockmanagements.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.stockmanagements.dto.ProductReturnDTO;
//import com.stockmanagements.entity.ProductReturn;
//import com.stockmanagements.entity.ProductSell;
//import com.stockmanagements.mapper.ProductReturnMapper;
//import com.stockmanagements.repository.*;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductReturnService {
//    @Autowired
//    private ProductReturnRepository productReturnRepository;
//    @Autowired
//    private ProductSellRepository productSellRepository;
//    @Autowired
//    private SellerRepository sellerRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ProductItemCategoryRepository productItemCategoryRepository;
//    @Autowired
//    private BanaTypeCategoryRepository banaTypeCategoryRepository;
//    @Autowired
//    private DesignTypeCategoryRepository designTypeCategoryRepository;
//
//    @Transactional
//    public ProductReturnDTO createProductReturn(ProductReturnDTO dto) {
//        // Check if the product was sold before allowing a return
//        Optional<ProductSell> optionalProductSell = productSellRepository.findByProductItemCategoryId(dto.getProductItemCategoryId());
//        if (optionalProductSell.isEmpty()) {
//            throw new RuntimeException("Cannot return a product that was never sold.");
//        }
//        ProductSell productSell = optionalProductSell.get();
//
//        // Ensure the returned product matches the originally sold product
//        if (!productSell.getBanaTypeCategory().getBana_id().equals(dto.getBanaTypeCategoryId()) ||
//                !productSell.getDesignTypeCategory().getDesign_id().equals(dto.getDesignTypeCategoryId())) {
//            throw new RuntimeException("Returned product does not match the originally sold product.");
//        }
//
//        // Check if the return quantity is not greater than the sold quantity
//        int totalReturnedQuantity = productReturnRepository.getTotalReturnedQuantity(dto.getProductItemCategoryId()).orElse(0);
//        int availableSellQuantity = productSell.getProductQuantity() - totalReturnedQuantity;
//
//        if (dto.getProductQuantity() > availableSellQuantity) {
//            throw new RuntimeException("Cannot return more than the available sold quantity. Available to return: " + availableSellQuantity);
//        }
//
//        // Convert DTO to Entity and save
//        ProductReturn productReturn = ProductReturnMapper.toEntity(dto, sellerRepository, userRepository,
//                productItemCategoryRepository, banaTypeCategoryRepository, designTypeCategoryRepository);
//        return ProductReturnMapper.toDTO(productReturnRepository.save(productReturn));
//    }
//
//    @Transactional(readOnly = true)
//    public List<ProductReturnDTO> getAllProductReturns() {
//        List<ProductReturn> returns = productReturnRepository.findAll();
//        return returns.stream().map(ProductReturnMapper::toDTO).collect(Collectors.toList());
//    }
//
//    @Transactional(readOnly = true)
//    public ProductReturnDTO getProductReturnById(Long id) {
//        ProductReturn productReturn = productReturnRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Product return not found with ID: " + id));
//        return ProductReturnMapper.toDTO(productReturn);
//    }
//
//    @Transactional
//    public ProductReturnDTO updateProductReturn(Long id, ProductReturnDTO dto) {
//        ProductReturn existingReturn = productReturnRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Product return not found with ID: " + id));
//
//        existingReturn.setProductQuantity(dto.getProductQuantity());
//        existingReturn.setReturnReason(dto.getReturnReason());
//        existingReturn.setReturnDate(dto.getReturnDate());
//
//        return ProductReturnMapper.toDTO(productReturnRepository.save(existingReturn));
//    }
//
//    @Transactional
//    public void deleteProductReturn(Long id) {
//        if (!productReturnRepository.existsById(id)) {
//            throw new RuntimeException("Product return not found with ID: " + id);
//        }
//        productReturnRepository.deleteById(id);
//    }
//}
