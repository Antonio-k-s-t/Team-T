package bg.sap.trohar_delivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name="customers")
public class Customer extends User {

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String phone;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, targetEntity = Order.class)
    private List<Order> orders;

    @OneToOne
    private Cart cart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
