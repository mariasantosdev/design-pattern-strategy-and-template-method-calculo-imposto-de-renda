package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ImpostoDeRendaTetoTeste {

    @ParameterizedTest
    @CsvSource({
            "4664.68, true",
            "4664.69, true",
            "15000.00, true",
    })
    @DisplayName("deve retornar verdadeiro se salario for maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_maior_que_o_valor_minimo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaTeto impostoDeRendaTeto = new ImpostoDeRendaTeto();
        Assertions.assertThat(impostoDeRendaTeto.aplica(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "4664.67, false",
            "1903.90, false",
    })
    @DisplayName("deve retornar falso se salario for menor que o valor minimo")
    void aplica__deve_retornar_falso_se_salario_for_menor_que_o_valor_minimo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaTeto impostoDeRendaTeto = new ImpostoDeRendaTeto();
        Assertions.assertThat(impostoDeRendaTeto.aplica(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "4664.68",
            "4664.69",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario) {
        ImpostoDeRendaTeto impostoDeRendaTeto = new ImpostoDeRendaTeto();
        Assertions.assertThat(impostoDeRendaTeto.calcula(salario)).isEqualTo(new BigDecimal("869.36"));
    }

    @ParameterizedTest
    @CsvSource({
            "4664.67",
            "0.00",
            "4664.60",
    })
    @DisplayName("deve lancar excecao se o salario for maior que o valor maximo ou menor que o valor minimo")
    void calcula__deve_lancar_excecao_se_o_salario_for_maior_que_o_valor_maximo_ou_menor_que_o_valor_minimo(BigDecimal salario) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new ImpostoDeRendaTeto().calcula(salario))
                .withMessage("Salario não se aplica para essa regra");
    }
}
