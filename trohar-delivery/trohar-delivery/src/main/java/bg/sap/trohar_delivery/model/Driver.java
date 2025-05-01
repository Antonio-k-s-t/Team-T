package bg.sap.trohar_delivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver extends User {

    @NotNull
    @Column
    private String name;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER, targetEntity = Order.class)
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
