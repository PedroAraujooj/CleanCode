package org.example.tp3.model;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
public final class TaskEstimate {

    @NonNull
    private final UUID id;
    @NonNull
    private final Integer estimatedHours;
    @NonNull
    private final BigDecimal hourlyRate;   // valor p hora

    public TaskEstimate(@NonNull UUID id, @NonNull Integer estimatedHours, @NonNull BigDecimal hourlyRate) {
        this.id = id;
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Horas estimadas não podem ser negativas");
        }
        this.estimatedHours = estimatedHours;

        if (hourlyRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor por hora não pode ser negativo");
        }
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getTotalEstimatedCost() {
        return hourlyRate.multiply(BigDecimal.valueOf(estimatedHours));
    }

    public TaskEstimate withEstimatedHours(int newHours) {
        return new TaskEstimate(this.id, newHours, this.hourlyRate);
    }

    public TaskEstimate withHourlyRate(BigDecimal newRate) {
        return new TaskEstimate(this.id, this.estimatedHours, newRate);
    }
}
