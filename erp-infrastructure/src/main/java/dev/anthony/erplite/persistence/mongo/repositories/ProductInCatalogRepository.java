package dev.anthony.erplite.persistence.mongo.repositories;

import dev.anthony.erplite.persistence.mongo.documents.ProductInCatalogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInCatalogRepository extends MongoRepository<ProductInCatalogDocument, String> {
}
