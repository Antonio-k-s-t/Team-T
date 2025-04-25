package bg.sap.trohar_delivery.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, targetEntity = Restaurant.class)
    private List<Restaurant> restaurants;

    @ManyToMany(mappedBy = "menus", fetch = FetchType.EAGER, targetEntity = Product.class)
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

