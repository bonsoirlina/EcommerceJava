package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    public void addToCart(Cart cart, Product product) {
        Cart findedCart = carts.stream()
                .filter(cart1 -> cart1.getId().equals(cart.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Caddie non trouvable"));
        findedCart.addProduct(product);
    }
}
