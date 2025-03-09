package com.stockmanagements.controller;

import com.stockmanagements.category.DesignTypeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.stockmanagements.service.DesignTypeCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/design-type-categories")
public class DesignTypeCategoryController {

    @Autowired
    private DesignTypeCategoryService designTypeCategoryService;

    // Create DesignTypeCategory
    @PostMapping
    public ResponseEntity<DesignTypeCategory> createDesignTypeCategory(@RequestBody DesignTypeCategory designTypeCategory) {
        return ResponseEntity.ok(designTypeCategoryService.createDesignTypeCategory(designTypeCategory));
    }

    // Get All DesignTypeCategories
    @GetMapping
    public ResponseEntity<List<DesignTypeCategory>> getAllDesignTypeCategories() {
        return ResponseEntity.ok(designTypeCategoryService.getAllDesignTypeCategories());
    }

    // Get DesignTypeCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<DesignTypeCategory> getDesignTypeCategoryById(@PathVariable Long id) {
        Optional<DesignTypeCategory> designTypeCategory = designTypeCategoryService.getDesignTypeCategoryById(id);
        return designTypeCategory.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update DesignTypeCategory
    @PutMapping("/{id}")
    public ResponseEntity<DesignTypeCategory> updateDesignTypeCategory(@PathVariable Long id, @RequestBody DesignTypeCategory updatedDesign) {
        return ResponseEntity.ok(designTypeCategoryService.updateDesignTypeCategory(id, updatedDesign));
    }

    // Delete DesignTypeCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignTypeCategory(@PathVariable Long id) {
        designTypeCategoryService.deleteDesignTypeCategory(id);
        return ResponseEntity.noContent().build();
    }
}

