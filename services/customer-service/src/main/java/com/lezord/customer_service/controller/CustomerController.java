package com.lezord.customer_service.controller;

import com.lezord.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
class CustomerController {

    private final CustomerService service;


}
