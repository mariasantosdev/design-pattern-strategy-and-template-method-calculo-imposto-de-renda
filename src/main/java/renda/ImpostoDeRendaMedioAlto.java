package renda;

import java.math.BigDecimal;

public class ImpostoDeRendaMedioAlto implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("2826.65");
    private final BigDecimal VALOR_MAXIMO = new BigDecimal("3751.06");

    @Override
    public boolean aplica(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0 && salario.compareTo(VALOR_MAXIMO) <= -1;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!aplica(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return new BigDecimal("354.80");
    }
}
