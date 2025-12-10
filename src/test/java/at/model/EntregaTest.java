package at.model;

import org.example.at.constants.TipoFrete;
import org.example.at.exceptions.EntregaInvalidaException;
import org.example.at.model.Entrega;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EntregaTest {

    @Test
    void deveCriarEntregaValida() {
        Entrega entrega = new Entrega(
                "João da Silva",
                "Rua A, 123",
                BigDecimal.valueOf(10),
                TipoFrete.EXPRESSO
        );

        assertEquals("João da Silva", entrega.getDestinatario());
        assertEquals("Rua A, 123", entrega.getEndereco());
        assertEquals(0, entrega.getPesoEmKg().compareTo(BigDecimal.valueOf(10)));
        assertEquals(TipoFrete.EXPRESSO, entrega.getTipoFrete());
    }

    @Test
    void naoDevePermitirPesoZero() {
        assertThrows(EntregaInvalidaException.class, () ->
                new Entrega(
                        "Maria",
                        "Av. Central, 500",
                        BigDecimal.ZERO,
                        TipoFrete.PADRAO
                )
        );
    }

    @Test
    void naoDevePermitirPesoNegativo() {
        assertThrows(EntregaInvalidaException.class, () ->
                new Entrega(
                        "Maria",
                        "Av. Central, 500",
                        BigDecimal.valueOf(-1),
                        TipoFrete.PADRAO
                )
        );
    }

    @Test
    void naoDevePermitirDestinatarioEmBranco() {
        assertThrows(EntregaInvalidaException.class, () ->
                new Entrega(
                        "   ",
                        "Rua B, 10",
                        BigDecimal.TEN,
                        TipoFrete.ECONOMICO
                )
        );
    }

    @Test
    void naoDevePermitirEnderecoEmBranco() {
        assertThrows(EntregaInvalidaException.class, () ->
                new Entrega(
                        "João",
                        " ",
                        BigDecimal.TEN,
                        TipoFrete.ECONOMICO
                )
        );
    }
}