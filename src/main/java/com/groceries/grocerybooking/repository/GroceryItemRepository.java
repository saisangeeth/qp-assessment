package com.groceries.grocerybooking.repository;

import com.groceries.grocerybooking.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}
