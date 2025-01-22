package com.groceries.grocerybooking.repository;

import com.groceries.grocerybooking.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
