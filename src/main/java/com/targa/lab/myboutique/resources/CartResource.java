package com.targa.lab.myboutique.resources;

import com.targa.lab.myboutique.dto.CartDto;
import com.targa.lab.myboutique.services.CartService;
import com.targa.lab.myboutique.utilities.Web;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/carts")
public class CartResource {
    private final CartService cartService;

    @GetMapping
    public List<CartDto> findAll() {
        return this.cartService.findAll();
    }

    @GetMapping("/active")
    public List<CartDto> findAllActiveCarts() {
        return this.cartService.findAllActiveCarts();
    }

    @GetMapping("/customer/{id}")
    public CartDto getActiveCartForCustomer(@PathVariable("id") Long customerId) {
        return this.cartService.getActiveCart(customerId);
    }

    @GetMapping("/{id}")
    public CartDto findById(@PathVariable Long id) {
        return this.cartService.findById(id);
    }

    @PostMapping("/customer/{id}")
    public CartDto create(@PathVariable("id") Long customerId) {
        return this.cartService.create(customerId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.cartService.delete(id);
    }
}