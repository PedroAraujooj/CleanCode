package at.service;

import org.example.at.constants.TipoFrete;
import org.example.at.exceptions.TipoFreteNaoSuportadoException;
import org.example.at.model.Entrega;
import org.example.at.service.CalculadoraFrete;
import org.example.at.service.impl.EtiquetaServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EtiquetaServiceImplTest {

    private static class FreteExpressoFixo implements CalculadoraFrete {
        @Override
        public TipoFrete tipoSuportado() {
            return TipoFrete.EXPRESSO;
        }

        @Override
        public BigDecimal calcular(Entrega entrega) {
            return BigDecimal.valueOf(30);
        }
    }

    private static class FretePadraoFixo implements CalculadoraFrete {
        @Override
        public TipoFrete tipoSuportado() {
            return TipoFrete.PADRAO;
        }

        @Override
        public BigDecimal calcular(Entrega entrega) {
            return BigDecimal.valueOf(20);
        }
    }

    @Test
    void deveUsarCalculadoraCorrespondenteAoTipoDeFrete() {
        EtiquetaServiceImpl service = new EtiquetaServiceImpl(
                List.of(new FreteExpressoFixo(), new FretePadraoFixo())
        );

        Entrega entregaExpresso = new Entrega(
                "João",
                "Rua A, 123",
                BigDecimal.TEN,
                TipoFrete.EXPRESSO
        );

        Entrega entregaPadrao = new Entrega(
                "Maria",
                "Rua B, 456",
                BigDecimal.TEN,
                TipoFrete.PADRAO
        );

        BigDecimal valorExpresso = service.calcularFrete(entregaExpresso);
        BigDecimal valorPadrao = service.calcularFrete(entregaPadrao);

        assertEquals(0, valorExpresso.compareTo(BigDecimal.valueOf(30)));
        assertEquals(0, valorPadrao.compareTo(BigDecimal.valueOf(20)));
    }

    @Test
    void deveLancarExcecaoQuandoNaoExistirCalculadoraParaTipo() {
        EtiquetaServiceImpl service = new EtiquetaServiceImpl(
                List.of(new FreteExpressoFixo())
        );

        Entrega entregaPadrao = new Entrega(
                "Maria",
                "Rua B, 456",
                BigDecimal.TEN,
                TipoFrete.PADRAO
        );

        assertThrows(TipoFreteNaoSuportadoException.class, () ->
                service.calcularFrete(entregaPadrao)
        );
    }
}