package com.targa.lab.myboutique.resources;

import com.targa.lab.myboutique.dto.CustomerDto;
import com.targa.lab.myboutique.services.CustomerService;
import com.targa.lab.myboutique.utilities.Web;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/customers")
public class CustomerResource {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id) {
        return this.customerService.findById(id);
    }

    @GetMapping("/active")
    public List<CustomerDto> findAllActive() {
        return this.customerService.findAllActive();
    }

    @GetMapping("/inactive")
    public List<CustomerDto> findAllInactive() {
        return this.customerService.findAllInactive();
    }

    @PostMapping
    public CustomerDto create(CustomerDto customerDto) {
        return this.customerService.create(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.customerService.delete(id);
    }
}