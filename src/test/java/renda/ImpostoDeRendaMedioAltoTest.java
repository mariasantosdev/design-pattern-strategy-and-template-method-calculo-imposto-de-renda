package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ImpostoDeRendaMedioAltoTest {
    @ParameterizedTest
    @CsvSource({
            "3751.05",
            "2826.65",
            "2826.66"
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo e maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo_e_maior_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.deveAplicarPara(salario)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.07",
            "3751.06",
    })
    @DisplayName("deve retornar falso se salario for maior ou igual que o valor maximo")
    void aplica__deve_retornar_falso_se_salario_for_maior__ou_igual_que_o_valor_maximo(BigDecimal salario) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "2826.64",
            "1903.90",
    })
    @DisplayName("deve retornar falso se salario for menor que o valor minimo")
    void aplica__deve_retornar_falso_se_salario_for_menor_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.05, 562.66",
            "2826.65, 424.00",
            "2826.66, 424.00",
            "3000.80, 450.12",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario, BigDecimal valorDoDesconto) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.efetuarCalculo(salario)).isEqualTo(valorDoDesconto);
    }
}
