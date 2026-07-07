package com.sameer.product_service.mapper;

import com.sameer.product_service.dto.CreateProductRequest;
import com.sameer.product_service.dto.ProductResponse;
import com.sameer.product_service.dto.ProductSummaryResponse;
import com.sameer.product_service.dto.UpdateProductRequest;
import com.sameer.product_service.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-07T23:45:24+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(CreateProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.sku( request.getSku() );
        product.name( request.getName() );
        product.description( request.getDescription() );
        product.price( request.getPrice() );
        product.category( request.getCategory() );

        return product.build();
    }

    @Override
    public ProductResponse toResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( product.getId() );
        productResponse.setSku( product.getSku() );
        productResponse.setName( product.getName() );
        productResponse.setDescription( product.getDescription() );
        productResponse.setPrice( product.getPrice() );
        productResponse.setCategory( product.getCategory() );
        productResponse.setStatus( product.getStatus() );
        productResponse.setCreatedAt( product.getCreatedAt() );
        productResponse.setUpdatedAt( product.getUpdatedAt() );

        return productResponse;
    }

    @Override
    public ProductSummaryResponse toSummaryResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductSummaryResponse productSummaryResponse = new ProductSummaryResponse();

        productSummaryResponse.setId( product.getId() );
        productSummaryResponse.setName( product.getName() );
        productSummaryResponse.setPrice( product.getPrice() );
        productSummaryResponse.setCategory( product.getCategory() );
        productSummaryResponse.setStatus( product.getStatus() );

        return productSummaryResponse;
    }

    @Override
    public void updateEntityFromRequest(UpdateProductRequest request, Product product) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            product.setName( request.getName() );
        }
        if ( request.getDescription() != null ) {
            product.setDescription( request.getDescription() );
        }
        if ( request.getPrice() != null ) {
            product.setPrice( request.getPrice() );
        }
        if ( request.getCategory() != null ) {
            product.setCategory( request.getCategory() );
        }
        if ( request.getStatus() != null ) {
            product.setStatus( request.getStatus() );
        }
    }
}
