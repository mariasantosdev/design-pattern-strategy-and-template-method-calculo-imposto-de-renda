package renda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoDeRendaTeto implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("4664.68");

    @Override
    public boolean deveAplicarPara(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!deveAplicarPara(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return (salario.multiply(new BigDecimal("0.275")).setScale(2, RoundingMode.HALF_UP));
    }
}
