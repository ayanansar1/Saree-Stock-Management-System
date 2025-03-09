package com.stockmanagements.service;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.repository.BanaTypeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BanaTypeCategoryService {

    @Autowired
    private BanaTypeCategoryRepository banaTypeCategoryRepository;

    // Create BanaTypeCategory
    public BanaTypeCategory createBanaTypeCategory(BanaTypeCategory banaTypeCategory) {
        return banaTypeCategoryRepository.save(banaTypeCategory);
    }

    // Get All BanaTypeCategories
    public List<BanaTypeCategory> getAllBanaTypeCategories() {
        return banaTypeCategoryRepository.findAll();
    }

    // Get BanaTypeCategory by ID
    public Optional<BanaTypeCategory> getBanaTypeCategoryById(Long id) {
        return banaTypeCategoryRepository.findById(id);
    }

    // Update BanaTypeCategory
    public BanaTypeCategory updateBanaTypeCategory(Long id, BanaTypeCategory updatedBana) {
        return banaTypeCategoryRepository.findById(id)
                .map(bana -> {
                    bana.setBana_name(updatedBana.getBana_name());
                    return banaTypeCategoryRepository.save(bana);
                })
                .orElseGet(() -> {
                    updatedBana.setBana_id(id);
                    return banaTypeCategoryRepository.save(updatedBana);
                });
    }

    // Delete BanaTypeCategory
    public void deleteBanaTypeCategory(Long id) {
        banaTypeCategoryRepository.deleteById(id);
    }
}
