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

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column
    private String phone;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER, targetEntity = Order.class)
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
