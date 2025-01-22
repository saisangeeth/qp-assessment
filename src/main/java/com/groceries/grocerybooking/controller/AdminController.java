package com.groceries.grocerybooking.controller;

import com.groceries.grocerybooking.entity.GroceryItem;
import com.groceries.grocerybooking.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/items")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<GroceryItem> addItem(@RequestBody GroceryItem item) {
        return ResponseEntity.ok(adminService.addGroceryItem(item));
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(adminService.getAllItems());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return ResponseEntity.ok(adminService.updateGroceryItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        adminService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/inventory")
    public ResponseEntity<GroceryItem> updateInventory(@PathVariable Long id, @RequestParam int quantity) {
        return ResponseEntity.ok(adminService.updateInventory(id, quantity));
    }
}
