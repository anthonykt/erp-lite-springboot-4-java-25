package dev.anthony.erplite.persistence.jpa.repositories;

import dev.anthony.erplite.persistence.jpa.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
