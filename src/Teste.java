import java.math.BigDecimal;

public class Teste {
    public static void main(String[] args) {
        CalculaImpostoDeRenda calculaImpostoDeRenda = new CalculaImpostoDeRenda();
        PessoaFisica pessoaFisica = new PessoaFisica(new BigDecimal("3000.00"));
        BigDecimal calcular = calculaImpostoDeRenda.calcular(TipoDoImpostoDeRenda.MEDIO_ALTO,pessoaFisica);
        System.out.println(calcular);
    }
}
