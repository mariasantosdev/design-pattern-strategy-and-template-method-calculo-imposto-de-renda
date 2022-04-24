package renda;

import java.math.BigDecimal;

public class ImpostoDeRendaTeto implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("4664.68");

    @Override
    public boolean aplica(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!aplica(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return new BigDecimal("869.36");
    }
}
