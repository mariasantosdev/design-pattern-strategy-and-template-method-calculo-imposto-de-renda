package renda;

import java.math.BigDecimal;

public class ImpostoDeRendaMedioBaixo implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("1903.98");
    private final BigDecimal VALOR_MAXIMO = new BigDecimal("2826.65");

    @Override
    public boolean aplica(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0 && salario.compareTo(VALOR_MAXIMO) <= -1;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!aplica(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return new BigDecimal("142.80");
    }
}
