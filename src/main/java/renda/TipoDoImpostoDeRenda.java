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
                .filter(t -> t.aplica(valor))
                .findFirst()
                .map(i -> i.calcular(valor))
                .orElseThrow();
    }

    private boolean aplica(BigDecimal salario) {
        return calculadoraImpostoDeRenda.deveAplicarPara(salario);
    }

    private BigDecimal calcular(BigDecimal salario) {
        return calculadoraImpostoDeRenda.efetuarCalculo(salario);
    }
}
