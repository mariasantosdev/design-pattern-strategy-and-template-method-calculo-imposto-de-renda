package main.java.br.com.maria.imposto.renda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoDeRendaTeto implements CalculadoraImpostoDeRenda {

    private final static BigDecimal VALOR_MINIMO = new BigDecimal("4664.68");

    @Override
    public boolean deveAplicarPara(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) > 0;
    }

    @Override
    public BigDecimal efetuarCalculo(BigDecimal salario) {
        return (salario.multiply(new BigDecimal("0.275"))
                .subtract(new BigDecimal("869.36"))
                .setScale(2, RoundingMode.HALF_UP));
    }
}
