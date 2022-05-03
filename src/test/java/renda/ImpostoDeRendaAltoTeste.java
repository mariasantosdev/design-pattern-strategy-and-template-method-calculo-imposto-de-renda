package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ImpostoDeRendaAltoTeste {
    @ParameterizedTest
    @CsvSource({
            "3751.06",
            "3751.07",
            "4664.67",
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo e maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo_e_maior_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.deveAplicarPara(salario)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "4664.69",
            "4664.68"
    })
    @DisplayName("deve retornar falso se salario for maior ou igual que o valor maximo")
    void aplica__deve_retornar_falso_se_salario_for_maior__ou_igual_que_o_valor_maximo(BigDecimal salario) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.05",
            "1903.90"
    })
    @DisplayName("deve retornar falso se salario for menor que o valor minimo")
    void aplica__deve_retornar_falso_se_salario_for_menor_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.06, 843.99",
            "3751.07, 843.99",
            "4294.94, 966.36",
            "4664.67, 1049.55",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario, BigDecimal valorDoDesconto) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.calcula(salario)).isEqualTo(valorDoDesconto);
    }

    @ParameterizedTest
    @CsvSource({
            "0.00",
            "3751.05",
            "4664.68",
    })
    @DisplayName("deve lancar excecao se o salario for maior que o valor maximo ou menor que o valor minimo")
    void calcula__deve_lancar_excecao_se_o_salario_for_maior_que_o_valor_maximo_ou_menor_que_o_valor_minimo(BigDecimal salario) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new ImpostoDeRendaAlto().calcula(salario))
                .withMessage("Salario não se aplica para essa regra");
    }
}
