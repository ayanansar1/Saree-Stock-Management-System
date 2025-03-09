package com.stockmanagements.controller;

import com.stockmanagements.category.BanaTypeCategory;
import com.stockmanagements.service.BanaTypeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bana-type-categories")
public class BanaTypeCategoryController {

    @Autowired
    private BanaTypeCategoryService banaTypeCategoryService;

    // Create BanaTypeCategory
    @PostMapping
    public ResponseEntity<BanaTypeCategory> createBanaTypeCategory(@RequestBody BanaTypeCategory banaTypeCategory) {
        return ResponseEntity.ok(banaTypeCategoryService.createBanaTypeCategory(banaTypeCategory));
    }

    // Get All BanaTypeCategories
    @GetMapping
    public ResponseEntity<List<BanaTypeCategory>> getAllBanaTypeCategories() {
        return ResponseEntity.ok(banaTypeCategoryService.getAllBanaTypeCategories());
    }

    // Get BanaTypeCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<BanaTypeCategory> getBanaTypeCategoryById(@PathVariable Long id) {
        Optional<BanaTypeCategory> banaTypeCategory = banaTypeCategoryService.getBanaTypeCategoryById(id);
        return banaTypeCategory.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update BanaTypeCategory
    @PutMapping("/{id}")
    public ResponseEntity<BanaTypeCategory> updateBanaTypeCategory(@PathVariable Long id, @RequestBody BanaTypeCategory updatedBana) {
        return ResponseEntity.ok(banaTypeCategoryService.updateBanaTypeCategory(id, updatedBana));
    }

    // Delete BanaTypeCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanaTypeCategory(@PathVariable Long id) {
        banaTypeCategoryService.deleteBanaTypeCategory(id);
        return ResponseEntity.noContent().build();
    }
}
