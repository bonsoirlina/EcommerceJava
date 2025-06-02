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
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    @ManyToOne
    private User user;

    public void addProduct(Product product) {
        products.add(product);
    }

    private double totalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
