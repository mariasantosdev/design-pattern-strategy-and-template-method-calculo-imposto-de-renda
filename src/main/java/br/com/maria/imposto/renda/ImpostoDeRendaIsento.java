package br.com.maria.imposto.renda;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class ImpostoDeRendaIsento implements CalculadoraImpostoDeRenda {

    private final static BigDecimal VALOR_MAXIMO = new BigDecimal("1903.98");

    @Override
    public boolean deveAplicarPara(BigDecimal salario) {
        return salario.compareTo(VALOR_MAXIMO) <= 0;
    }

    @Override
    public BigDecimal efetuarCalculo(BigDecimal salario) {
        if(!deveAplicarPara(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return ZERO;
    }
}
