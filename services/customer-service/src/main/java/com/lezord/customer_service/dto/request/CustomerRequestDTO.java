package com.lezord.customer_service.dto.request;

import com.lezord.customer_service.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequestDTO(

        @NotNull(message = "Customer firstname is required")
        String firstname,

        @NotNull(message = "Customer firstname is required")
        String lastname,

        @NotNull(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        String email,

        Address address
) {}
