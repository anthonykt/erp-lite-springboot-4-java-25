package dev.anthony.erplite.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "products",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_products_sku",
                        columnNames = "sku"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "sku", length = 50, nullable = false)
    private String sku;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price", precision = 15, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    @ColumnDefault("0")
    private Integer stock = 0;

    @Column(name = "category_id", length = 100)
    private String categoryId;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "active", nullable = false)
    @ColumnDefault("true")
    private boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (createdAt == null) {
            createdAt = now;
        }
        if (updatedAt == null) {
            updatedAt = now;
        }
        if (stock == null) {
            stock = 0;
        }
        if (!active) {
            active = true;
        }
    }

    @PreUpdate
    void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
