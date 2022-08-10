package renda;

import java.math.BigDecimal;
import java.util.Arrays;

public enum TipoDoImpostoDeRenda {

    ISENTO(new ImpostoDeRendaIsento()),
    SETE_E_MEIO(new ImpostoDeRendaMedioBaixo()),
    QUINZE(new ImpostoDeRendaMedioAlto()),
    VINTE_E_DOIS_E_MEIO(new ImpostoDeRendaAlto()),
    VINTE_E_SETE_E_MEIO(new ImpostoDeRendaTeto());

    private final CalculadoraImpostoDeRenda calculadoraImpostoDeRenda;

    TipoDoImpostoDeRenda(CalculadoraImpostoDeRenda calculadoraImpostoDeRenda) {
        this.calculadoraImpostoDeRenda = calculadoraImpostoDeRenda;
    }

    public static BigDecimal calcularImpostoDeRenda(BigDecimal valor) {
        return Arrays.stream(TipoDoImpostoDeRenda.values())
                .map(i -> i.calcular(valor))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    private BigDecimal calcular(BigDecimal salario) {
        return calculadoraImpostoDeRenda.calcular(salario);
    }
}
