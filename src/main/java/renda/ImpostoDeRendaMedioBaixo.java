package renda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoDeRendaMedioBaixo implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("1903.98");
    private final BigDecimal VALOR_MAXIMO = new BigDecimal("2826.65");

    @Override
    public boolean deveAplicarPara(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0 && salario.compareTo(VALOR_MAXIMO) <= -1;
    }

    @Override
    public BigDecimal efetuarCalculo(BigDecimal salario) {
        return (salario.multiply(new BigDecimal("0.075")).setScale(2, RoundingMode.HALF_UP));
    }
}
