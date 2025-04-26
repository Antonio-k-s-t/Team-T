package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.enums.DeliveryStatus;
import bg.sap.trohar_delivery.model.Order;
import bg.sap.trohar_delivery.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("order",
                orderService.getOrderById(id)
                        .orElseThrow(() -> new RuntimeException("Order not found")));
        return "orders/details";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order());
        return "orders/create";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("order",
                orderService.getOrderById(id)
                        .orElseThrow(() -> new RuntimeException("Order not found")));
        return "orders/edit";
    }

    @PostMapping("/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute Order order) {
        orderService.updateOrder(id, order);
        return "redirect:/orders/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/customer/{customerId}")
    public String getOrdersByCustomer(@PathVariable Long customerId, Model model) {
        model.addAttribute("orders", orderService.getOrderRepository().findByCustomerId(customerId));
        return "orders/list";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getOrdersByRestaurant(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("orders", orderService.getOrderRepository().findByRestaurantsId(restaurantId));
        return "orders/list";
    }

    @GetMapping("/driver/{driverId}")
    public String getOrdersByDriver(@PathVariable Long driverId, Model model) {
        model.addAttribute("orders", orderService.getOrderRepository().findByDriverId(driverId));
        return "orders/list";
    }

    @PostMapping("/{id}/status")
    public String updateOrderStatus(@PathVariable Long id,
                                    @RequestParam DeliveryStatus status) {
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        orderService.saveOrder(order);
        return "redirect:/orders/" + id;
    }
}