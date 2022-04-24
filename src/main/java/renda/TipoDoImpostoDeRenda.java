package renda;

import java.math.BigDecimal;
import java.util.Arrays;

public enum TipoDoImpostoDeRenda {

    BAIXO(new ImpostoDeRendaIsento()),
    MEDIO_BAIXO(new ImpostoDeRendaMedioBaixo()),
    MEDIO_ALTO(new ImpostoDeRendaMedioAlto()),
    ALTO(new ImpostoDeRendaAlto()),
    TETO(new ImpostoDeRendaTeto());

    private final CalculadoraImpostoDeRenda calculadoraImpostoDeRenda;

    TipoDoImpostoDeRenda(CalculadoraImpostoDeRenda calculadoraImpostoDeRenda) {
        this.calculadoraImpostoDeRenda = calculadoraImpostoDeRenda;
    }

    public static BigDecimal calcularImpostoDeRenda(BigDecimal valor) {
        return Arrays.stream(TipoDoImpostoDeRenda.values())
                .filter(t -> t.aplica(valor))
                .findFirst()
                .map(i -> i.calcula(valor))
                .orElseThrow();
    }

    private boolean aplica(BigDecimal salario) {
        return calculadoraImpostoDeRenda.aplica(salario);
    }

    private BigDecimal calcula(BigDecimal salario) {
        return calculadoraImpostoDeRenda.calcula(salario);
    }
}
