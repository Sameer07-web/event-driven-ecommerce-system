package com.sameer.inventory_service.mapper;

import com.sameer.inventory_service.dto.CreateInventoryRequest;
import com.sameer.inventory_service.dto.InventoryResponse;
import com.sameer.inventory_service.dto.InventorySummaryResponse;
import com.sameer.inventory_service.dto.UpdateInventoryRequest;
import com.sameer.inventory_service.entity.Inventory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-07T23:45:36+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Eclipse Adoptium)"
)
@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public Inventory toEntity(CreateInventoryRequest request) {
        if ( request == null ) {
            return null;
        }

        Inventory.InventoryBuilder inventory = Inventory.builder();

        inventory.productId( request.getProductId() );
        inventory.sku( request.getSku() );
        inventory.totalQuantity( request.getTotalQuantity() );

        return inventory.build();
    }

    @Override
    public InventoryResponse toResponse(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        InventoryResponse inventoryResponse = new InventoryResponse();

        inventoryResponse.setId( inventory.getId() );
        inventoryResponse.setProductId( inventory.getProductId() );
        inventoryResponse.setSku( inventory.getSku() );
        inventoryResponse.setTotalQuantity( inventory.getTotalQuantity() );
        inventoryResponse.setReservedQuantity( inventory.getReservedQuantity() );
        inventoryResponse.setAvailableQuantity( inventory.getAvailableQuantity() );
        inventoryResponse.setStatus( inventory.getStatus() );
        inventoryResponse.setCreatedAt( inventory.getCreatedAt() );
        inventoryResponse.setUpdatedAt( inventory.getUpdatedAt() );

        return inventoryResponse;
    }

    @Override
    public InventorySummaryResponse toSummaryResponse(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        InventorySummaryResponse inventorySummaryResponse = new InventorySummaryResponse();

        inventorySummaryResponse.setProductId( inventory.getProductId() );
        inventorySummaryResponse.setSku( inventory.getSku() );
        inventorySummaryResponse.setAvailableQuantity( inventory.getAvailableQuantity() );
        inventorySummaryResponse.setStatus( inventory.getStatus() );

        return inventorySummaryResponse;
    }

    @Override
    public void updateEntityFromRequest(UpdateInventoryRequest request, Inventory inventory) {
        if ( request == null ) {
            return;
        }

        if ( request.getTotalQuantity() != null ) {
            inventory.setTotalQuantity( request.getTotalQuantity() );
        }
        if ( request.getStatus() != null ) {
            inventory.setStatus( request.getStatus() );
        }
    }
}
