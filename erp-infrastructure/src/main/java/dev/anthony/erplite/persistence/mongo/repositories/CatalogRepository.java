package dev.anthony.erplite.persistence.mongo.repositories;

import dev.anthony.erplite.persistence.mongo.documents.CatalogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogRepository extends MongoRepository<CatalogDocument, String> {
}
