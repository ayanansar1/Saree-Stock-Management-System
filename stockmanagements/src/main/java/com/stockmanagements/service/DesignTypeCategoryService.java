package com.stockmanagements.service;

import com.stockmanagements.category.DesignTypeCategory;
import com.stockmanagements.repository.DesignTypeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignTypeCategoryService {

    @Autowired
    private DesignTypeCategoryRepository designTypeCategoryRepository;

    // Create DesignTypeCategory
    public DesignTypeCategory createDesignTypeCategory(DesignTypeCategory designTypeCategory) {
        return designTypeCategoryRepository.save(designTypeCategory);
    }

    // Get All DesignTypeCategories
    public List<DesignTypeCategory> getAllDesignTypeCategories() {
        return designTypeCategoryRepository.findAll();
    }

    // Get DesignTypeCategory by ID
    public Optional<DesignTypeCategory> getDesignTypeCategoryById(Long id) {
        return designTypeCategoryRepository.findById(id);
    }

    // Update DesignTypeCategory
    public DesignTypeCategory updateDesignTypeCategory(Long id, DesignTypeCategory updatedDesign) {
        return designTypeCategoryRepository.findById(id)
                .map(design -> {
                    design.setDesign_name(updatedDesign.getDesign_name());
                    return designTypeCategoryRepository.save(design);
                })
                .orElseGet(() -> {
                    updatedDesign.setDesign_id(id);
                    return designTypeCategoryRepository.save(updatedDesign);
                });
    }

    // Delete DesignTypeCategory
    public void deleteDesignTypeCategory(Long id) {
        designTypeCategoryRepository.deleteById(id);
    }
}
