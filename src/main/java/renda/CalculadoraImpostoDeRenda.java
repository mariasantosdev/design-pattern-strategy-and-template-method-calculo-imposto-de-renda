package renda;

import java.math.BigDecimal;

public interface CalculadoraImpostoDeRenda {
    boolean deveAplicarPara(BigDecimal salario);
    BigDecimal calcula(BigDecimal salario);
}
