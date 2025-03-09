//package com.stockmanagements.controller;
//
//import com.stockmanagements.dto.ProductSellDTO;
//import com.stockmanagements.service.ProductSellService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/product-sell")
//
//public class ProductSellController {
//
//    @Autowired
//    private ProductSellService productSellService;
//
//    // Create or Update Product Sell
//    @PostMapping("/save")
//    public ResponseEntity<ProductSellDTO> saveProductSell(@RequestBody ProductSellDTO productSellDTO) {
//        ProductSellDTO savedProductSell = productSellService.saveProductSell(productSellDTO);
//        return ResponseEntity.ok(savedProductSell);
//    }
//
//    // Get all Product Sells
//    @GetMapping("/all")
//    public ResponseEntity<List<ProductSellDTO>> getAllProductSells() {
//        List<ProductSellDTO> productSells = productSellService.getAllProductSells();
//        return ResponseEntity.ok(productSells);
//    }
//
//    // Get Product Sell by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductSellDTO> getProductSellById(@PathVariable Long id) {
//        ProductSellDTO productSell = productSellService.getProductSellById(id);
//        return productSell != null ? ResponseEntity.ok(productSell) : ResponseEntity.notFound().build();
//    }
//
//    // Delete Product Sell by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteProductSell(@PathVariable Long id) {
//        boolean deleted = productSellService.deleteProductSell(id);
//        return deleted ? ResponseEntity.ok("Product Sell deleted successfully.")
//                : ResponseEntity.notFound().build();
//    }
//}
