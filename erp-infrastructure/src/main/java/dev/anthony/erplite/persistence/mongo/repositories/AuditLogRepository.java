package dev.anthony.erplite.persistence.mongo.repositories;

import dev.anthony.erplite.persistence.mongo.documents.AuditLogDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditLogRepository extends MongoRepository<AuditLogDocument, ObjectId> {
}
