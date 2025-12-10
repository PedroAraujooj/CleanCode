package org.example.at.service.impl;

import org.example.at.constants.TipoFrete;
import org.example.at.model.Entrega;
import org.example.at.service.CalculadoraFrete;

import java.math.BigDecimal;

public class FretePadrao implements CalculadoraFrete {

    @Override
    public TipoFrete tipoSuportado() {
        return TipoFrete.PADRAO;
    }

    @Override
    public BigDecimal calcular(Entrega entrega) {
        // peso * 1.2
        return entrega.getPesoEmKg()
                .multiply(BigDecimal.valueOf(1.2));
    }
}