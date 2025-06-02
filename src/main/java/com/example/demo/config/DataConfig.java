package com.example.demo.config;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfig {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public DataConfig(UserRepository userRepository,
                      CartRepository cartRepository,
                      ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Bean(name = "productRepositoryWithInitData")
    public ProductRepository productRepository() {
        List<Product> products = productList();
        productRepository.saveAll(products);
        return productRepository;
    }

    @Bean(name = "cartRepositoryWithInitData")
    public CartRepository cartRepository() {
        return cartRepository;
    }

    @Bean(name = "userRepositoryWithInitData")
    public UserRepository userRepository() {
        User user = user();
        userRepository.save(user);
        return userRepository;
    }

    public List<Product> productList() {
        return List.of(
                new Product("61082a4a-ec0a-4365-ab37-960bc6c267ba", "PS5", 499.99, null),
                new Product("fd30b73b-0af0-4b89-9d65-0a6eff61331a", "XBOX", 599.99, null),
                new Product("5c462607-d286-44a5-97e6-86afb1f545b1", "SWITCH 2", 499.99, null)
        );
    }

    public User user() {
        return new User("a4ae3f6f-f25e-4492-b259-b54507ce1f51", "Kaci HAMMACHI", null);
    }
}
