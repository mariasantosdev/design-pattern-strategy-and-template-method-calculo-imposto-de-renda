package renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {
    boolean aplica(BigDecimal salario);
    BigDecimal calcula(BigDecimal salario);
}
