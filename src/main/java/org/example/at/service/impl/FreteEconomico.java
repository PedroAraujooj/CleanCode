package org.example.at.service.impl;

import org.example.at.constants.TipoFrete;
import org.example.at.model.Entrega;
import org.example.at.service.CalculadoraFrete;

import java.math.BigDecimal;

public class  FreteEconomico implements CalculadoraFrete {

    @Override
    public TipoFrete tipoSuportado() {
        return TipoFrete.ECONOMICO;
    }

    @Override
    public BigDecimal calcular(Entrega entrega) {
        // peso * 1.1 - 5
        BigDecimal valor = entrega.getPesoEmKg()
                .multiply(BigDecimal.valueOf(1.1))
                .subtract(BigDecimal.valueOf(5));

        // Evita frete negativo
        return valor.max(BigDecimal.ZERO);
    }
}