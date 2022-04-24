package renda;

import java.math.BigDecimal;

public class ImpostoDeRendaAlto implements CalculadoraImpostoDeRenda {

    private final BigDecimal VALOR_MINIMO = new BigDecimal("3751.06");
    private final BigDecimal VALOR_MAXIMO = new BigDecimal("4664.68");

    @Override
    public boolean aplica(BigDecimal salario) {
        return salario.compareTo(VALOR_MINIMO) >= 0 && salario.compareTo(VALOR_MAXIMO) <= -1;
    }

    @Override
    public BigDecimal calcula(BigDecimal salario) {
        if(!aplica(salario)) throw new RuntimeException("Salario não se aplica para essa regra");
        return new BigDecimal("636.13");
    }
}
