package at.controller;

import org.example.at.constants.TipoFrete;
import org.example.at.controller.EtiquetaController;
import org.example.at.model.Entrega;
import org.example.at.service.EtiquetaService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EtiquetaControllerTest {

    private static class EtiquetaServiceStub implements EtiquetaService {
        @Override
        public BigDecimal calcularFrete(Entrega entrega) {
            return BigDecimal.valueOf(25);
        }
    }

    @Test
    void gerarEtiquetaDeveConterDestinatarioEnderecoEValorFormatado() {
        EtiquetaService serviceStub = new EtiquetaServiceStub();
        EtiquetaController controller = new EtiquetaController(serviceStub);

        Entrega entrega = new Entrega(
                "João da Silva",
                "Rua A, 123",
                BigDecimal.TEN,
                TipoFrete.EXPRESSO
        );

        String etiqueta = controller.gerarEtiqueta(entrega);

        assertTrue(etiqueta.contains("Destinatário: João da Silva"));
        assertTrue(etiqueta.contains("Endereço: Rua A, 123"));
        assertTrue(etiqueta.contains("Valor do Frete: R$"));
    }

    @Test
    void gerarResumoPedidoDeveConterDestinatarioTipoEFrete() {
        EtiquetaService serviceStub = new EtiquetaServiceStub();
        EtiquetaController controller = new EtiquetaController(serviceStub);

        Entrega entrega = new Entrega(
                "Maria",
                "Av. Central, 500",
                BigDecimal.TEN,
                TipoFrete.ECONOMICO
        );

        String resumo = controller.gerarResumoPedido(entrega);

        assertTrue(resumo.contains("Pedido para Maria"));
        assertTrue(resumo.contains("ECONOMICO"));
        assertTrue(resumo.contains("R$"));
    }
}