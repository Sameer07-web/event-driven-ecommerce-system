package com.sameer.inventory_service.exception;

import com.sameer.common.exception.BusinessException;

public class InvalidInventoryStateException extends BusinessException {
    public InvalidInventoryStateException(String message) {
        super(message, "INVALID_INVENTORY_STATE");
    }
}
