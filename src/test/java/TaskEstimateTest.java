import org.example.tp3.model.TaskEstimate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskEstimateTest {

    @Test
    void testTaskEstimation() {
        TaskEstimate original = new TaskEstimate(
                UUID.randomUUID(),
                8,
                new BigDecimal("100.00")
        );
        TaskEstimate atualizado = original.withEstimatedHours(10);

        assertEquals(8, original.getEstimatedHours());
        assertEquals(new BigDecimal("100.00"), original.getHourlyRate());

        assertEquals(10, atualizado.getEstimatedHours());
        assertEquals(new BigDecimal("100.00"), atualizado.getHourlyRate());
    }
}
