package br.com.maria.imposto.renda;

import java.math.BigDecimal;

public class PessoaFisica {
    private BigDecimal salario;

    public PessoaFisica(String salario) {
        this.salario = new BigDecimal(salario);
    }

    public BigDecimal calcularSalarioLiquido() {
        return TipoDoImpostoDeRenda.calcularImpostoDeRenda(this.salario);
    }
}
