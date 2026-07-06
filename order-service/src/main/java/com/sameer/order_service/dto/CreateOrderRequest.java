package com.sameer.order_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating a new order")
public class CreateOrderRequest {

    @Schema(description = "Name of the product", example = "MacBook Pro")
    @NotBlank(message = "Product name is required")
    private String productName;

    @Schema(description = "Quantity of the product", example = "2", minimum = "1")
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @Schema(description = "Price per unit", example = "2500.0", minimum = "1")
    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;
}
