package renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {

    default BigDecimal calcular(BigDecimal salario) {
        if (!deveAplicarPara(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        else return efetuarCalculo(salario);
    }

    boolean deveAplicarPara(BigDecimal salario);

    BigDecimal efetuarCalculo(BigDecimal salario);
}
