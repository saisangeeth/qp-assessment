package com.groceries.grocerybooking.service;

import com.groceries.grocerybooking.entity.GroceryItem;
import com.groceries.grocerybooking.entity.Order;
import com.groceries.grocerybooking.entity.OrderItem;
import com.groceries.grocerybooking.repository.GroceryItemRepository;
import com.groceries.grocerybooking.repository.OrderItemRepository;
import com.groceries.grocerybooking.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final GroceryItemRepository groceryItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public UserService(GroceryItemRepository groceryItemRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public Order placeOrder(Long userId, List<OrderItem> items) {
        double totalPrice = 0;
        for (OrderItem item : items) {
            GroceryItem groceryItem = groceryItemRepository.findById(item.getGroceryItem().getId()).orElseThrow();
            if (groceryItem.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for item: " + groceryItem.getName());
            }
            groceryItem.setQuantity(groceryItem.getQuantity() - item.getQuantity());
            groceryItemRepository.save(groceryItem);
            item.setPrice(groceryItem.getPrice() * item.getQuantity());
            totalPrice += item.getPrice();
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(totalPrice);
        order.setItems(items);
        orderRepository.save(order);

        for (OrderItem item : items) {
            item.setOrder(order);
            orderItemRepository.save(item);
        }

        return order;
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
