package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ImpostoDeRendaMedioAltoTest {

    @ParameterizedTest
    @CsvSource({
            "2826.66",
            "2826.67",
            "3751.05",
            "3751.04"
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo e maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo_e_maior_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.deveAplicarPara(salario)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.07",
            "2826,65",
            "3751.06",
            "2826.64",
            "1903.90"
    })
    @DisplayName("deve retornar falso se salario nao se encaixar na faixa de valor")
    void aplica__deve_retornar_falso_se_salario_nao_se_encaixar_na_faixa_de_valor(BigDecimal salario) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.05, 207.86",
            "2826.65, 69.20",
            "2826.66, 69.20",
            "3000.80, 95.32",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario, BigDecimal valorDoDesconto) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.efetuarCalculo(salario)).isEqualTo(valorDoDesconto);
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
                .isThrownBy(() -> new ImpostoDeRendaMedioAlto().calcular(salario))
                .withMessage("Salario não se aplica para essa regra");
    }
}
