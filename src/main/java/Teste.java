import br.com.maria.imposto.renda.PessoaFisica;

import java.math.BigDecimal;

public class Teste {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica("8745");
        BigDecimal calcular = pessoaFisica.calcularSalarioLiquido();
        System.out.println(calcular);
    }
}
