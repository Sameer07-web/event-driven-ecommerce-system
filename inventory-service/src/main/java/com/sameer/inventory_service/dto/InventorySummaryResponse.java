package com.sameer.inventory_service.dto;

import com.sameer.inventory_service.enums.InventoryStatus;
import lombok.Data;
import java.util.UUID;

@Data
public class InventorySummaryResponse {
    private UUID productId;
    private String sku;
    private Integer availableQuantity;
    private InventoryStatus status;
}
