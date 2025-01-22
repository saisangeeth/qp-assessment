package com.groceries.grocerybooking.controller;

import com.groceries.grocerybooking.entity.GroceryItem;
import com.groceries.grocerybooking.entity.Order;
import com.groceries.grocerybooking.entity.OrderItem;
import com.groceries.grocerybooking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(userService.getAllItems());
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestParam Long userId, @RequestBody List<OrderItem> items) {
        return ResponseEntity.ok(userService.placeOrder(userId, items));
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserOrders(userId));
    }
}