package com.sameer.product_service.service;

import com.sameer.product_service.dto.CreateProductRequest;
import com.sameer.product_service.dto.ProductResponse;
import com.sameer.product_service.dto.ProductSummaryResponse;
import com.sameer.product_service.dto.UpdateProductRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);
    ProductResponse getProductById(UUID id);
    Page<ProductSummaryResponse> getAllProducts(Pageable pageable);
    ProductResponse updateProduct(UUID id, UpdateProductRequest request);
    void deleteProduct(UUID id);
}
