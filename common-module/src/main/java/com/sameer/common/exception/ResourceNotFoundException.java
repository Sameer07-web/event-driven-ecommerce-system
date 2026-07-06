package com.sameer.common.exception;

import com.sameer.common.constant.ErrorCodes;

public abstract class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message) {
        super(message, ErrorCodes.RESOURCE_NOT_FOUND);
    }
}
