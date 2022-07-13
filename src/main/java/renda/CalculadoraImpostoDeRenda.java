package renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {

    default boolean deveAplicarPara(BigDecimal salario) {
        if (!deveAplicarPara(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        else return true;
    }
    BigDecimal efetuarCalculo(BigDecimal salario);
}
