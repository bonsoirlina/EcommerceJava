package com.example.demo.service;

import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public ShopService(@Qualifier("userRepositoryWithInitData") UserRepository userRepository,
                       @Qualifier("cartRepositoryWithInitData") CartRepository cartRepository,
                       @Qualifier("productRepositoryWithInitData") ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }
}
