package main.java.br.com.maria.imposto.renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {

    default BigDecimal calcular(BigDecimal salario) {
        if (deveAplicarPara(salario)) return efetuarCalculo(salario);
        else throw new RuntimeException("Salario não se aplica para essa regra");
    }

    boolean deveAplicarPara(BigDecimal salario);

    BigDecimal efetuarCalculo(BigDecimal salario);
}
