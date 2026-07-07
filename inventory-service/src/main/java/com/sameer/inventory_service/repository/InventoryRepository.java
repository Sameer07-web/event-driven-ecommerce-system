package com.sameer.inventory_service.repository;

import com.sameer.inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
    Optional<Inventory> findByProductId(UUID productId);
    Optional<Inventory> findBySku(String sku);
    boolean existsByProductId(UUID productId);
    boolean existsBySku(String sku);
}
