package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Order;
import bg.sap.trohar_delivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderRepository getOrderRepository() {
        return this.orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    existingOrder.setCustomer(updatedOrder.getCustomer());
                    existingOrder.setDriver(updatedOrder.getDriver());
                    existingOrder.setRestaurants(updatedOrder.getRestaurants());
                    existingOrder.setTotal(updatedOrder.getTotal());
                    existingOrder.setStatus(updatedOrder.getStatus());
                    existingOrder.setCreatedDate(updatedOrder.getCreatedDate());
                    existingOrder.setFinishedDate(updatedOrder.getFinishedDate());
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }
}
