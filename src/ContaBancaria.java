public class ContaBancaria {
    private String numeroDaConta;
    private String numeroDaAgencia;

    private String titularDaConta;
    private double saldo;
    private String cpf;

    public ContaBancaria(String titularDaConta, String cpf, double saldo) {
        this.numeroDaConta = gerarNumeroConta();
        this.numeroDaAgencia = gerarNumeroAgencia();
        this.titularDaConta = titularDaConta;
        this.saldo = saldo;
        this.cpf = cpf;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) return false;
        if (valor > saldo) return false;

        saldo -= valor;
        return true;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    private static String gerarNumeroConta() {
        int numero = (int) (Math.random() * 90000000) + 10000000;
        return String.valueOf(numero);
    }

    private static String gerarNumeroAgencia() {
        int numero = (int) (Math.random() * 9000) + 1000;
        return String.valueOf(numero);
    }


    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getNumeroDaAgencia() {
        return numeroDaAgencia;
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }


}
