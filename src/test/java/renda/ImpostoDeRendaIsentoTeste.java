package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ImpostoDeRendaIsentoTeste {

    @ParameterizedTest
    @CsvSource({
            "1800.00, true",
            "1903.00, true",
            "1903.97, true",
            "0, true"
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaIsento impostoDeRendaIsento = new ImpostoDeRendaIsento();
        Assertions.assertThat(impostoDeRendaIsento.deveAplicarPara(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "1903.98, false",
            "2003.99, false",
    })
    @DisplayName("deve retornar falso se salario for maior ou igual que o valor maximo")
    void aplica__deve_retornar_falso_se_salario_for_maior_ou_igual_que_o_valor_maximo(BigDecimal salario, boolean deveSerAplicado) {
        ImpostoDeRendaIsento impostoDeRendaIsento = new ImpostoDeRendaIsento();
        Assertions.assertThat(impostoDeRendaIsento.deveAplicarPara(salario)).isEqualTo(deveSerAplicado);
    }

    @ParameterizedTest
    @CsvSource({
            "1800.00",
            "1903.00",
            "1903.97",
            "0"
    })
    @DisplayName("deve retornar zero se nao deve se aplicar desconto")
    void calcula__deve_retornar_zero_se_nao_deve_se_aplicar_desconto(BigDecimal salario) {
        ImpostoDeRendaIsento impostoDeRendaIsento = new ImpostoDeRendaIsento();
        Assertions.assertThat(impostoDeRendaIsento.calcula(salario)).isZero();
    }

    @ParameterizedTest
    @CsvSource({
            "1903.98",
            "2003.99",
    })
    @DisplayName("deve lancar excecao se o salario for maior que o valor maximo")
    void calcula__deve_lancar_excecao_se_o_salario_for_maior_que_o_valor_maximo(BigDecimal salario) {
       assertThatExceptionOfType(RuntimeException.class)
               .isThrownBy(() -> new ImpostoDeRendaIsento().calcula(salario))
               .withMessage("Salario não se aplica para essa regra");
    }
}
