package org.example.tp1;

public class e11 {
    static final class ResultadoValidacaoDTO {
        private final boolean valido;
        private final String motivo;

        private ResultadoValidacaoDTO(boolean valido, String motivo) {
            this.valido = valido; this.motivo = motivo;
        }
        public static ResultadoValidacaoDTO ok() { return new ResultadoValidacaoDTO(true, "OK"); }
        public static ResultadoValidacaoDTO erro(String motivo) { return new ResultadoValidacaoDTO(false, motivo); }
        public boolean isValido() { return valido; }
        public String getMotivo() { return motivo; }
    }

    final class ValidadorCPF {
        public ResultadoValidacaoDTO validar(String cpf) {
            if (cpf == null) return ResultadoValidacaoDTO.erro("CPF nulo");
            String digits = cpf.replaceAll("\\D", "");
            if (digits.length() != 11) return ResultadoValidacaoDTO.erro("CPF deve ter 11 dígitos");
            return ResultadoValidacaoDTO.ok();
        }
    }
}
