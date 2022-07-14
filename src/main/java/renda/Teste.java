package renda;

import java.math.BigDecimal;

public class Teste {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica("2453");
        BigDecimal calcular = pessoaFisica.calcularSalarioLiquido();
        System.out.println(calcular);
    }
}
