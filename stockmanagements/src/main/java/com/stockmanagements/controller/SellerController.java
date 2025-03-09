package com.stockmanagements.controller;

import com.stockmanagements.entity.Seller;
import com.stockmanagements.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // Add a new seller
    @PostMapping
    public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
        Seller savedSeller = sellerService.addSeller(seller);
        return ResponseEntity.ok(savedSeller);
    }

    // Get all sellers
    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return ResponseEntity.ok(sellers);
    }

    // Get seller by ID
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("id") Long sellerId) {
        Seller seller = sellerService.getSellerById(sellerId);
        return ResponseEntity.ok(seller);
    }

    // Update seller
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable("id") Long sellerId, @RequestBody Seller updatedSeller) {
        Seller updated = sellerService.updateSeller(sellerId, updatedSeller);
        return ResponseEntity.ok(updated);
    }

    // Delete seller
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable("id") Long sellerId) {
        sellerService.deleteSeller(sellerId);
        return ResponseEntity.noContent().build();
    }
}
