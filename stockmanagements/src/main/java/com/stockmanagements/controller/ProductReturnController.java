//package com.stockmanagements.controller;
//
//import com.stockmanagements.dto.ProductReturnDTO;
//import com.stockmanagements.service.ProductReturnService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/product-returns")
//public class ProductReturnController {
//
//    @Autowired
//    private ProductReturnService productReturnService;
//
//    // Create a new product return
//    @PostMapping
//    public ResponseEntity<ProductReturnDTO> createProductReturn(@RequestBody ProductReturnDTO dto) {
//        try {
//            ProductReturnDTO createdReturn = productReturnService.createProductReturn(dto);
//            return new ResponseEntity<>(createdReturn, HttpStatus.CREATED);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // Get all product returns
//    @GetMapping
//    public ResponseEntity<List<ProductReturnDTO>> getAllProductReturns() {
//        List<ProductReturnDTO> returns = productReturnService.getAllProductReturns();
//        return new ResponseEntity<>(returns, HttpStatus.OK);
//    }
//
//    // Get product return by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductReturnDTO> getProductReturnById(@PathVariable Long id) {
//        try {
//            ProductReturnDTO productReturn = productReturnService.getProductReturnById(id);
//            return new ResponseEntity<>(productReturn, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Update an existing product return
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductReturnDTO> updateProductReturn(@PathVariable Long id, @RequestBody ProductReturnDTO dto) {
//        try {
//            ProductReturnDTO updatedReturn = productReturnService.updateProductReturn(id, dto);
//            return new ResponseEntity<>(updatedReturn, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Delete a product return
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProductReturn(@PathVariable Long id) {
//        try {
//            productReturnService.deleteProductReturn(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
