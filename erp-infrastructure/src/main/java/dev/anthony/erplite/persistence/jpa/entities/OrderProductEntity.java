package dev.anthony.erplite.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_products", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_products_order"), nullable = false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_order_products_product"), nullable = false)
    private ProductEntity product;

    @Column(name = "product_name", length = 200, nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 15, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "subtotal", precision = 15, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @PrePersist
    void prePersist() {
        if (unitPrice != null &&  quantity != null && subtotal == null) {
            subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity.longValue()));
        }
        if (product != null && (productName == null ||  productName.isBlank())) {
            productName = product.getName();
        }
    }
}
