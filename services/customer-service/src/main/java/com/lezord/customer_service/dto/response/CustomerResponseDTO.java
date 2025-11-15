package com.lezord.customer_service.dto.response;

import com.lezord.customer_service.entity.Address;

public record CustomerResponseDTO(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {}
