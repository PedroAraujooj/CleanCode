package org.example.tp3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.NonNull;
import org.example.tp3.constants.ChangeType;
public record TaskChangeRecord(
        @NonNull
        UUID id,
        @NonNull
        UUID taskId,
        @NonNull
        ChangeType type,
        @NonNull
        String description,
        @NonNull
        String authorEmail,
        @NonNull
        BigDecimal estimatedImpactHours,
        @NonNull
        LocalDateTime createdAt) {
}
