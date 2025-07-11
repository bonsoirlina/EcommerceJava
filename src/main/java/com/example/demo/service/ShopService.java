package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public ShopService(@Qualifier("userRepositoryWithInitData") UserRepository userRepository,
                       @Autowired CartRepository cartRepository,
                       @Qualifier("productRepositoryWithInitData") ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<Cart> getCartsByUser(String uuidUser) {
        return getUserByUuid(uuidUser).getCarts();
    }

    private User getUserByUuid(String uuidUser) {
        return userRepository.findById(uuidUser).
                orElseThrow(() -> new RuntimeException("User not found with UUID: " + uuidUser));
    }

    private Product getProductByUuid(String uuidProduct) {
        return productRepository.findById(uuidProduct)
                .filter(Product::isAvailable)
                .orElseThrow(() -> new RuntimeException("Product not found with UUID: " + uuidProduct));
    }

    public void addProductToCart(String uuidUser, String uuidProduct) {
        User user = getUserByUuid(uuidUser);
        Product product = getProductByUuid(uuidProduct);
        user.addToCart(product);
    }
}
