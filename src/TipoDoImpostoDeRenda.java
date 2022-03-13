import java.math.BigDecimal;
import java.util.Arrays;

import static java.math.BigDecimal.ZERO;

public enum TipoDoImpostoDeRenda {

    BAIXO(null, ZERO, new BigDecimal("1903.98")) {
        @Override
        public BigDecimal calcularSalarioLiquido(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("0"));
        }
    },
    MEDIO_BAIXO("7.5", new BigDecimal("1903.99"), new BigDecimal("2826.65")) {
        @Override
        public BigDecimal calcularSalarioLiquido(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("142.80"));
        }
    },
    MEDIO_ALTO("15", new BigDecimal("2826.66"), new BigDecimal("3751.05")) {
        @Override
        public BigDecimal calcularSalarioLiquido(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("354.80"));
        }
    },
    ALTO("22.5", new BigDecimal("3751.06"), new BigDecimal("4664.68")) {
        @Override
        public BigDecimal calcularSalarioLiquido(PessoaFisica pessoaFisica) {
            return pessoaFisica.getSalario().subtract(new BigDecimal("636.13"));
        }
    },
    TETO("27.5", new BigDecimal("4664.68"),null) {
        @Override
        public BigDecimal calcularSalarioLiquido(PessoaFisica pessoaFisica) {
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

    public static TipoDoImpostoDeRenda identificarTipoDeCalculo(BigDecimal valor) {
        return Arrays.stream(TipoDoImpostoDeRenda.values())
                .filter(t -> t.eValorSuportado(valor))
                .findFirst()
                .orElseThrow();
    }

    public boolean eValorSuportado(BigDecimal valor) {
        return valor.compareTo(this.valorMinimo) >= 0 && (this.valorMaximo == null || valor.compareTo(this.valorMaximo) <= 0);
    }

    abstract BigDecimal calcularSalarioLiquido(PessoaFisica pessoaFisica);
}
