package dev.anthony.erplite.persistence.mongo.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document(collection = "product_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInCatalogDocument {

    @Id
    private UUID id;

    private boolean active;

    private String categoryId;

    private String categoryName;

    private String currency;

    private String description;

    private String imageUrl;

    private String name;

    private BigDecimal price;

    private String sku;

    private ProductSpecifications specifications;

    private int stock;

    private List<String> tags;

    private Instant createdAt;

    private Instant updatedAt;
}
