package org.example.at.service.impl;

import org.example.at.constants.TipoFrete;
import org.example.at.model.Entrega;
import org.example.at.service.CalculadoraFrete;

import java.math.BigDecimal;

public class FreteExpresso implements CalculadoraFrete {

    @Override
    public TipoFrete tipoSuportado() {
        return TipoFrete.EXPRESSO;
    }

    @Override
    public BigDecimal calcular(Entrega entrega) {
        //peso * 1.5 + 10
        return entrega.getPesoEmKg()
                .multiply(BigDecimal.valueOf(1.5))
                .add(BigDecimal.TEN);
    }
}