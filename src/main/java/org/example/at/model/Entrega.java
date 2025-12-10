package org.example.at.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.example.at.constants.TipoFrete;
import org.example.at.exceptions.EntregaInvalidaException;

import java.math.BigDecimal;


@Getter
public final class Entrega {
    @NonNull
    private final String destinatario;
    @NonNull
    private final String endereco;
    @NonNull
    private final BigDecimal pesoEmKg;
    @NonNull
    private final TipoFrete tipoFrete;

    public Entrega(@NonNull String destinatario,
                   @NonNull String endereco,
                   @NonNull BigDecimal pesoEmKg,
                   @NonNull TipoFrete tipoFrete) {

        if (destinatario.isBlank()) {
            throw new EntregaInvalidaException("Destinatário é obrigatório.");
        }
        if (endereco.isBlank()) {
            throw new EntregaInvalidaException("Endereço é obrigatório.");
        }
        if (pesoEmKg.compareTo(BigDecimal.ZERO) <= 0) {
            throw new EntregaInvalidaException("Peso deve ser maior que zero.");
        }

        this.destinatario = destinatario;
        this.endereco = endereco;
        this.pesoEmKg = pesoEmKg;
        this.tipoFrete = tipoFrete;
    }
}
