package org.example.at.service;

import org.example.at.constants.TipoFrete;
import org.example.at.model.Entrega;

import java.math.BigDecimal;

public interface CalculadoraFrete {

    TipoFrete tipoSuportado();

    BigDecimal calcular(Entrega entrega);
}