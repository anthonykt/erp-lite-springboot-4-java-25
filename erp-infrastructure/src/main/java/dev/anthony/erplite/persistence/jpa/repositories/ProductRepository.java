package dev.anthony.erplite.persistence.jpa.repositories;

import dev.anthony.erplite.persistence.jpa.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
