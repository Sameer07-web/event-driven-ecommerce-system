package com.sameer.inventory_service.dto;

import com.sameer.inventory_service.enums.InventoryStatus;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class UpdateInventoryRequest {

    @PositiveOrZero(message = "Total quantity must be positive or zero")
    private Integer totalQuantity;

    private InventoryStatus status;
}
