package org.example.at.controller;

import lombok.RequiredArgsConstructor;
import org.example.at.model.Entrega;
import org.example.at.service.EtiquetaService;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@RequiredArgsConstructor
public class EtiquetaController {
    private final EtiquetaService etiquetaService;
    private final NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));


    public String gerarEtiqueta(Entrega entrega) {
        BigDecimal valorFrete = etiquetaService.calcularFrete(entrega);

        return new StringBuilder()
                .append("Destinatário: ").append(entrega.getDestinatario()).append("\n")
                .append("Endereço: ").append(entrega.getEndereco()).append("\n")
                .append("Valor do Frete: ").append(formatadorMoeda.format(valorFrete))
                .toString();
    }

    public String gerarResumoPedido(Entrega entrega) {
        BigDecimal valorFrete = etiquetaService.calcularFrete(entrega);

        return String.format(
                "Pedido para %s com frete %s no valor de %s",
                entrega.getDestinatario(),
                entrega.getTipoFrete(),
                formatadorMoeda.format(valorFrete)
        );
    }
}
