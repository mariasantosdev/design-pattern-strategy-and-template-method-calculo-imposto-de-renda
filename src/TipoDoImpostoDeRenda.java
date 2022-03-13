import java.math.BigDecimal;

public enum TipoDoImpostoDeRenda {

    BAIXO("Não há", new BigDecimal("0"), new BigDecimal("1903.98")) {
        @Override
        public BigDecimal calcularImpostoDeRenda(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("0"));
        }
    },
    MEDIO_BAIXO("7,5", new BigDecimal("1903.99"), new BigDecimal("2826.65")) {
        @Override
        public BigDecimal calcularImpostoDeRenda(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("142.80"));
        }
    },
    MEDIO_ALTO("15", new BigDecimal("2826.66"), new BigDecimal("3751.05")) {
        @Override
        public BigDecimal calcularImpostoDeRenda(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("354.80"));
        }
    },
    ALTO("22.5", new BigDecimal("3751.06"), new BigDecimal("4664.68")) {
        @Override
        public BigDecimal calcularImpostoDeRenda(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("636.13"));
        }
    },
    TETO("27,5", new BigDecimal("4664.68"),new BigDecimal("1000000.00")) {
        @Override
        public BigDecimal calcularImpostoDeRenda(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("869.36"));
        }
    };

    private final String aliquiota;
    private final BigDecimal valorMinimo;
    private final BigDecimal valorMaximo;

    TipoDoImpostoDeRenda(String aliquiota, BigDecimal valorMinimo, BigDecimal valorMaximo) {
        this.aliquiota = aliquiota;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
    }

    abstract BigDecimal calcularImpostoDeRenda(PessoaFisica pessoaFisica);
}
