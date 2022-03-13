import java.math.BigDecimal;

public class CalculaImpostoDeRenda {
    public BigDecimal calcular(TipoDoImpostoDeRenda tipoDoImpostoDeRenda, PessoaFisica pessoaFisica) {
        return tipoDoImpostoDeRenda.calcularImpostoDeRenda(pessoaFisica);
    }
}
