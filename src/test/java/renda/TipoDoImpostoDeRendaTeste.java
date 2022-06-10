package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

public class TipoDoImpostoDeRendaTeste {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1903.97, 0",
            "2826.64, 212.00",
            "1903.98, 142.80",
            "3751.05, 562.66",
            "2826.65, 424.00",
            "4294.94, 966.36",
            "4664.67, 1049.55",
            "4664.69, 1282.79",
            "15000.00, 4125.00"
    })
    @DisplayName("deve calcular imposto de renda se aplicar a regra")
    void deve_calcular_imposto_de_renda_se_o_valor_se_aplica_a_regra(BigDecimal valorASerCalculado, BigDecimal valorDoDesconto) {
        Assertions.assertThat(TipoDoImpostoDeRenda.calcularImpostoDeRenda(valorASerCalculado)).isEqualTo(valorDoDesconto);
    }
}
