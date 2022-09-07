package br.com.maria.imposto.renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {

    public boolean deveAplicarPara(BigDecimal salario);

    BigDecimal efetuarCalculo(BigDecimal salario);
}
