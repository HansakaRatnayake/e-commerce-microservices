package com.lezord.customer_service.util;


public record StandardResponseDTO(
        int code,
        String message,
        Object data
) {}
