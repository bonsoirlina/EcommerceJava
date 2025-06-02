package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShopServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final CartRepository cartRepository = mock(CartRepository.class);
    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final ShopService shopService = new ShopService(userRepository, cartRepository, productRepository);

    @Test
    void getCartsByUser() {
        when(userRepository.findById("a4ae3f6f-f25e-4492-b259-b54507ce1f51")).thenReturn(Optional.of(createUser()));

        List<Cart> carts = shopService.getCartsByUser("a4ae3f6f-f25e-4492-b259-b54507ce1f51");

        assertEquals(1, carts.size());
    }

    @Test
    void getCartsByUser_UserNotFound() {
        when(userRepository.findById("wrong-id")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> shopService.getCartsByUser("wrong-id"));
    }

    private User createUser() {
        Product product = new Product("e9bd76f2-9f98-4f65-abe1-429cb18a39d1", "PS5", 499.99, true, null);
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart("04d37b37-7b08-45cf-8224-dec9f58029eb", List.of(product), null));
        User user = new User("a4ae3f6f-f25e-4492-b259-b54507ce1f51", "Kaci HAMMACHI", null);
        carts.get(0).setUser(user);
        user.setCarts(carts);
        return user;
    }
}