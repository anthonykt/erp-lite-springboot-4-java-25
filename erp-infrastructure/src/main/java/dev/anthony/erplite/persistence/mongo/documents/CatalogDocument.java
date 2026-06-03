package dev.anthony.erplite.persistence.mongo.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Document(collection = "catalogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogDocument {

    @Id
    private String id;

    @Field(name = "active")
    private boolean active;

    private CatalogType catalogType;

    private String description;

    private String name;

    private List<CatalogItem> items;

    private Instant createdAt;

    private Instant updatedAt;
}
