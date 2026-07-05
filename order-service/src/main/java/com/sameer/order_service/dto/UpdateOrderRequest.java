package com.sameer.order_service.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdateOrderRequest {

    private String productName;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;

    private String status;
}
