package br.com.maria.imposto.renda;

import java.math.BigDecimal;
import java.util.Arrays;

public enum TipoDoImpostoDeRenda {

    ISENTO(new ImpostoDeRendaIsento()),
    MEDIO_BAIXO(new ImpostoDeRendaMedioBaixo()),
    MEDIO_ALTO(new ImpostoDeRendaMedioAlto()),
    ALTO(new ImpostoDeRendaAlto()),
    TETO(new ImpostoDeRendaTeto());

    private final CalculadoraImpostoDeRenda calculadoraImpostoDeRenda;

    TipoDoImpostoDeRenda(CalculadoraImpostoDeRenda calculadoraImpostoDeRenda) {
        this.calculadoraImpostoDeRenda = calculadoraImpostoDeRenda;
    }

    public static BigDecimal calcularImpostoDeRenda(BigDecimal salario) {
        return Arrays.stream(TipoDoImpostoDeRenda.values())
                .filter(t -> t.deveAplicarPara(salario))
                .findFirst()
                .map(i -> i.efetuarCalculo(salario))
                .orElseThrow(() -> new RuntimeException("Tipo de imposto de renda não encontrado"));
    }
    private boolean deveAplicarPara(BigDecimal salario) {
        return calculadoraImpostoDeRenda.deveAplicarPara(salario);
    }

    private BigDecimal efetuarCalculo(BigDecimal salario) {
        return calculadoraImpostoDeRenda.efetuarCalculo(salario);
    }
}
