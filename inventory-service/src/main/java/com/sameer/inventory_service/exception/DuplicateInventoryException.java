package com.sameer.inventory_service.exception;

import com.sameer.common.exception.BusinessException;

public class DuplicateInventoryException extends BusinessException {
    public DuplicateInventoryException(String message) {
        super(message, "DUPLICATE_INVENTORY");
    }
}
