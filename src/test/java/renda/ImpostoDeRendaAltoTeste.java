package renda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

public class ImpostoDeRendaAltoTeste {
    @ParameterizedTest
    @CsvSource({
            "3751.06",
            "3751.07",
            "4664.67",
            "4664.68",
    })
    @DisplayName("deve retornar verdadeiro se salario for menor que o valor maximo e maior que o valor minimo")
    void aplica__deve_retornar_verdadeiro_se_salario_for_menor_que_o_valor_maximo_e_maior_que_o_valor_minimo(BigDecimal salario) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.deveAplicarPara(salario)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.05",
            "4664.69"
    })
    @DisplayName("deve retornar falso se salario for maior ou igual que o valor maximo")
    void aplica__deve_retornar_falso_se_salario_for_maior__ou_igual_que_o_valor_maximo(BigDecimal salario) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.05",
            "1903.90",
            "4664.69",
    })
    @DisplayName("deve retornar falso se salario nao se encaixar na faixa de valor")
    void aplica__deve_retornar_falso_se_salario_nao_se_encaixar_na_faixa_de_valor(BigDecimal salario) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.deveAplicarPara(salario)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "3751.60, 207.98",
            "3751.07, 207.86",
            "4294.94, 330.23",
            "4664.68, 413.42",
    })
    @DisplayName("deve retornar valor do desconto se deve aplicar desconto")
    void calcula__deve_retornar_valor_do_desconto_se_deve_aplicar_desconto(BigDecimal salario, BigDecimal valorDoDesconto) {
        ImpostoDeRendaAlto impostoDeRendaAlto = new ImpostoDeRendaAlto();
        Assertions.assertThat(impostoDeRendaAlto.efetuarCalculo(salario)).isEqualTo(valorDoDesconto);
    }
}
