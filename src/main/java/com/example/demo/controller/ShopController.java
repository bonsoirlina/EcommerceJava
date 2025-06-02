package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/shop", "/shop/"})
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/cart/{uuidUser}")
    public ResponseEntity<List<Cart>> showCart(@PathVariable String uuidUser) {
        try {
            List<Cart> carts = shopService.getCartsByUser(uuidUser);
            return ResponseEntity.ok(carts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/cart/{uuidUser}/{uuidProduct}")
    public ResponseEntity<Void> showCart(@PathVariable String uuidUser, @PathVariable String uuidProduct) {
        try {
            shopService.addProductToCart(uuidUser, uuidProduct);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
