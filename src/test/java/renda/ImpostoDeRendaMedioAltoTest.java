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
            "3751.05, true",
            "2826.65, true",
            "2826.66, true",
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo e maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo_e_maior_que_o_valor_minimo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.aplica(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "3751.07, false",
            "3751.06, false",
    })
    @DisplayName("deve retornar falso se salario for maior ou igual que o valor maximo")
    void aplica__deve_retornar_falso_se_salario_for_maior__ou_igual_que_o_valor_maximo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.aplica(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "2826.64, false",
            "1903.90, false",
    })
    @DisplayName("deve retornar falso se salario for menor que o valor minimo")
    void aplica__deve_retornar_falso_se_salario_for_menor_que_o_valor_minimo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.aplica(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "3751.05",
            "2826.65",
            "2826.66",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario) {
        ImpostoDeRendaMedioAlto impostoDeRendaMedioAlto = new ImpostoDeRendaMedioAlto();
        Assertions.assertThat(impostoDeRendaMedioAlto.calcula(salario)).isEqualTo(new BigDecimal("354.80"));
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
                .isThrownBy(() -> new ImpostoDeRendaMedioAlto().calcula(salario))
                .withMessage("Salario não se aplica para essa regra");
    }
}
