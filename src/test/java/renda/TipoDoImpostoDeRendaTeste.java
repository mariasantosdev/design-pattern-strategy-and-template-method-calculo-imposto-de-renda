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
            "1903.98, 0",
            "1903.99, 0.00",
            "2826.64, 69.20",
            "1903.99, 0.00",
            "2826.65, 69.20",
            "3751.05, 207.86",
            "2826.65, 69.20",
            "2826.66, 69.20",
            "3000.80, 95.32",
            "3751.60, 207.98",
            "3751.07, 207.86",
            "4294.94, 330.23",
            "4664.68, 413.42",
            "4664.69, 413.43",
            "15000.00, 3255.64"
    })
    @DisplayName("deve calcular imposto de renda se aplicar a regra")
    void deve_calcular_imposto_de_renda_se_o_valor_se_aplica_a_regra(BigDecimal valorASerCalculado, BigDecimal valorDoDesconto) {
        Assertions.assertThat(TipoDoImpostoDeRenda.calcularImpostoDeRenda(valorASerCalculado)).isEqualTo(valorDoDesconto);
    }
}
