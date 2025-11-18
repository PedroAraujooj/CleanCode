package org.example.tp2;

public class RelatorioService {

    public void gerarRelatorio(String tipo) {
        RelatorioFactory factory = criarFactory(tipo);
        factory.gerarRelatorio();
    }

    private RelatorioFactory criarFactory(String tipo) {
        return switch (tipo) {
            case "PDF" -> new RelatorioPdfFactory();
            case "CSV" -> new RelatorioCsvFactory();
            case "JSON" -> new RelatorioJsonFactory();
            default -> throw new IllegalArgumentException("Tipo de relatório desconhecido: " + tipo);
        };
    }
}

interface RelatorioFactory {
    void gerarRelatorio();
}

class RelatorioPdfFactory implements RelatorioFactory {
    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em PDF...");
        gerarCabecalhoPDF();
        gerarCorpoPDF();
        gerarRodapePDF();
    }

    private void gerarCabecalhoPDF() {}
    private void gerarCorpoPDF() {}
    private void gerarRodapePDF() {}
}

class RelatorioCsvFactory implements RelatorioFactory {
    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em CSV...");
        gerarCabecalhoCSV();
        gerarCorpoCSV();
        gerarRodapeCSV();
    }

    private void gerarCabecalhoCSV() {}
    private void gerarCorpoCSV() {}
    private void gerarRodapeCSV() {}
}

class RelatorioJsonFactory implements RelatorioFactory {
    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em JSON...");
        gerarCabecalhoJSON();
        gerarCorpoJSON();
        gerarRodapeJSON();
    }

    private void gerarCabecalhoJSON() {}
    private void gerarCorpoJSON() {}
    private void gerarRodapeJSON() {}
}