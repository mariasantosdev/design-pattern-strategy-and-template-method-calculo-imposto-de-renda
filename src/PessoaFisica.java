import java.math.BigDecimal;

public class PessoaFisica {
    private BigDecimal salario;

    public PessoaFisica(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
