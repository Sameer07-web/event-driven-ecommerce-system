package com.sameer.product_service.exception;

import com.sameer.common.exception.BusinessException;

public class DuplicateProductException extends BusinessException {
    public DuplicateProductException(String message) {
        super(message, "DUPLICATE_PRODUCT");
    }
}
