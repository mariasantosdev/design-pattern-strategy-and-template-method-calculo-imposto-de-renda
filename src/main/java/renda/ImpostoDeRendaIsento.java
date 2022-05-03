package renda;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class ImpostoDeRendaIsento implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MAXIMO = new BigDecimal("1903.97");

    @Override
    public boolean deveAplicarPara(BigDecimal salario) {
        return salario.compareTo(VALOR_MAXIMO) <= 0;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!deveAplicarPara(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return ZERO;
    }
}
