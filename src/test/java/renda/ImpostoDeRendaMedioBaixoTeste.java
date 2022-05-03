package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ImpostoDeRendaMedioBaixoTeste {

    @ParameterizedTest
    @CsvSource({
            "2826.64",
            "1903.98",
            "1903.99"
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo e maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo_e_maior_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaMedioBaixo impostoDeRendaMedioBaixo = new ImpostoDeRendaMedioBaixo();
        Assertions.assertThat(impostoDeRendaMedioBaixo.deveAplicarPara(salario)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.07",
            "3751.06"
    })
    @DisplayName("deve retornar falso se salario for maior ou igual que o valor maximo")
    void aplica__deve_retornar_falso_se_salario_for_maior__ou_igual_que_o_valor_maximo(BigDecimal salario) {
        ImpostoDeRendaMedioBaixo impostoDeRendaMedioBaixo = new ImpostoDeRendaMedioBaixo();
        Assertions.assertThat(impostoDeRendaMedioBaixo.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "1903.97",
            "1903.90"
    })
    @DisplayName("deve retornar falso se salario for menor que o valor minimo")
    void aplica__deve_retornar_falso_se_salario_for_menor_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaMedioBaixo impostoDeRendaMedioBaixo = new ImpostoDeRendaMedioBaixo();
        Assertions.assertThat(impostoDeRendaMedioBaixo.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "2826.64, 212.00",
            "1903.98, 142.80",
            "1903.99, 142.80",
            "2496.00, 187.20",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario, BigDecimal valorDoDesconto) {
        ImpostoDeRendaMedioBaixo impostoDeRendaMedioBaixo = new ImpostoDeRendaMedioBaixo();
        Assertions.assertThat(impostoDeRendaMedioBaixo.calcula(salario)).isEqualTo(valorDoDesconto);
    }

    @ParameterizedTest
    @CsvSource({
            "1903.97",
            "0.00",
            "3751.06",
            "3751.07",
    })
    @DisplayName("deve lancar excecao se o salario for maior que o valor maximo ou menor que o valor minimo")
    void calcula__deve_lancar_excecao_se_o_salario_for_maior_que_o_valor_maximo_ou_menor_que_o_valor_minimo(BigDecimal salario) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new ImpostoDeRendaMedioBaixo().calcula(salario))
                .withMessage("Salario não se aplica para essa regra");
    }
}
