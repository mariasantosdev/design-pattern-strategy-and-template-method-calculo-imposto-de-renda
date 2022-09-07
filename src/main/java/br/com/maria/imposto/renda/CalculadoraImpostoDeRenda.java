package br.com.maria.imposto.renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {

    boolean deveAplicarPara(BigDecimal salario);

    BigDecimal efetuarCalculo(BigDecimal salario);
}
