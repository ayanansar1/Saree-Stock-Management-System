package com.stockmanagements.service;

import com.stockmanagements.entity.Seller;
import com.stockmanagements.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    // Add a new seller
    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    // Get all sellers
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    // Get seller by ID
    public Seller getSellerById(Long sellerId) {
        return sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found with ID: " + sellerId));
    }

    // Update seller
    public Seller updateSeller(Long sellerId, Seller updatedSeller) {
        Seller existingSeller = getSellerById(sellerId);
        existingSeller.setSellerName(updatedSeller.getSellerName());
        existingSeller.setMobileNo(updatedSeller.getMobileNo());
        existingSeller.setSellerAddress(updatedSeller.getSellerAddress());
        existingSeller.setGstNO(updatedSeller.getGstNO());
        return sellerRepository.save(existingSeller);
    }

    // Delete seller
    public void deleteSeller(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }
}
