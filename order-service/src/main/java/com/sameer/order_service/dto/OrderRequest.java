package com.sameer.order_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderRequest {

    @NotBlank(message = "Product name is required")
    private String productName;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;
}