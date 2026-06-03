package dev.anthony.erplite.persistence.mongo.documents;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogDocument {

    @Id
    private ObjectId id;

    private String className;

    private String endPoint;

    private String errorMessage;

    private long executionTimeMs;

    private String ipAddress;

    private String methodName;

    private boolean success;

    private Instant timestamp;

    private String userId;
}
