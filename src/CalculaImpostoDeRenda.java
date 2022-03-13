import java.math.BigDecimal;

public class CalculaImpostoDeRenda {
    public BigDecimal calcular(PessoaFisica pessoaFisica) {
        return TipoDoImpostoDeRenda.identificarTipoDeCalculo(pessoaFisica.getSalario())
                .calcularSalarioLiquido(pessoaFisica);
    }
}
