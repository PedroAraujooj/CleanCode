package org.example.at.service.impl;

import lombok.NonNull;
import org.example.at.constants.TipoFrete;
import org.example.at.exceptions.TipoFreteNaoSuportadoException;
import org.example.at.model.Entrega;
import org.example.at.service.CalculadoraFrete;
import org.example.at.service.EtiquetaService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EtiquetaServiceImpl implements EtiquetaService {

    @NonNull
    private final Map<TipoFrete, CalculadoraFrete> calculadorasPorTipo;
    public EtiquetaServiceImpl(@NonNull List<CalculadoraFrete> calculadoras) {
        this.calculadorasPorTipo =
                toMap(calculadoras);
    }

    private Map<TipoFrete, CalculadoraFrete> toMap(List<CalculadoraFrete> calculadoras) {
        return calculadoras.stream().collect(Collectors.toMap(
                CalculadoraFrete::tipoSuportado, c -> c));
    }

    @Override
    public BigDecimal calcularFrete(Entrega entrega) {
        CalculadoraFrete calculadora = calculadorasPorTipo.get(entrega.getTipoFrete());
        if (calculadora == null) {
            throw new TipoFreteNaoSuportadoException("Tipo de frete não suportado: " + entrega.getTipoFrete());
        }
        return calculadora.calcular(entrega);
    }
}