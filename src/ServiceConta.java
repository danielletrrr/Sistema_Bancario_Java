public class ServiceConta {
    public static void sacar(ContaBancaria conta, double valor) {
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public static void depositar(ContaBancaria conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }
}
