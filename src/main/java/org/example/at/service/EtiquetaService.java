package org.example.at.service;

import org.example.at.model.Entrega;

import java.math.BigDecimal;

public interface EtiquetaService {
    BigDecimal calcularFrete(Entrega entrega);
}
