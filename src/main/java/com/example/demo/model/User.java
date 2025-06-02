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
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    public void addToCart(Product product) {
        if (carts.isEmpty()) {
            carts.add(new Cart("04d37b37-7b08-45cf-8224-dec9f58029eb", List.of(product), null));
        }
        carts.get(0).addProduct(product);
    }
}
