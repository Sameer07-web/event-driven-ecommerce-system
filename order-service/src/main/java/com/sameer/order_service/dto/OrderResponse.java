package com.sameer.order_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Response payload representing an order")
public class OrderResponse {
    @Schema(description = "Order ID", example = "1001")
    private Long id;
    @Schema(description = "Product Name", example = "MacBook Pro")
    private String productName;
    @Schema(description = "Quantity ordered", example = "2")
    private Integer quantity;
    @Schema(description = "Total Price", example = "5000.0")
    private Double price;
    @Schema(description = "Current Order Status", example = "CREATED")
    private String status;
    @Schema(description = "Creation Timestamp")
    private LocalDateTime createdAt;
}
