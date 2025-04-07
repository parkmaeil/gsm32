package com.example.demo.controller;

import com.example.demo.payload.CustomerCartDTO;
import com.example.demo.service.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    // 특정 고객이 어떤 책을 언제, 몇 권 샀는지를 조회할 수 있는 REST API
    //http://localhost:8081/api/customer/carts/user5
    @GetMapping("/carts/{username}")
    public List<CustomerCartDTO> getCarts(@PathVariable String username){
        return customerService.getCustomersWithCarts(username);
    }
}
