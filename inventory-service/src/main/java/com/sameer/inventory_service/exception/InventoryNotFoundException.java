package com.sameer.inventory_service.exception;

import com.sameer.common.exception.ResourceNotFoundException;

public class InventoryNotFoundException extends ResourceNotFoundException {
    public InventoryNotFoundException(String message) {
        super(message);
    }
}
