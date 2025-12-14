import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static ArrayList<ContaBancaria> contas = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Criar conta");
            System.out.println("2. Entrar na conta");
            System.out.println("3. Sair");
            int opc = scan.nextInt();
            scan.nextLine();

            switch (opc) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    entrarConta();
                    break;
                case 3:
                    return;
            }
        }
    }

    //1 private static void = só essa classe pode usar, não precisa criar obj da classe p usar, nao retorna nada
    private static void criarConta() {
        System.out.print("Nome do titular: ");
        String nome = scan.nextLine();

        System.out.print("CPF do titular: ");
        String cpf = scan.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = scan.nextDouble();

//instanciando o objeto
        ContaBancaria conta = new ContaBancaria(nome, cpf, saldo);
        contas.add(conta);

        System.out.println("\nConta criada com sucesso!");
        System.out.println("Agência: " + conta.getNumeroDaAgencia());
        System.out.println("Número da conta: " + conta.getNumeroDaConta());
    }

    //2
    private static void entrarConta() {
        System.out.print("Digite o número da conta: ");
        String numeroDigitado = scan.nextLine();

        System.out.print("Digite o número da agência: ");
        String agenciaDigitada = scan.nextLine();

        // começa com null. se encontrar, aponta para o objeto correto, se continual null, nao achou nada
        ContaBancaria contaEncontrada = null;

        // PROCURA a conta na memória contas é uma lista, c é cada conta na memória
        for (ContaBancaria c : contas) {
            if (c.getNumeroDaConta().equals(numeroDigitado) &&
                    c.getNumeroDaAgencia().equals(agenciaDigitada)) {

                contaEncontrada = c; //guarda a conta encontrada
                break;
            }
        }

        if (contaEncontrada == null) {
            System.out.println("Conta não encontrada!");
        } else {
            System.out.println("\nBEM-VINDO(A), " + contaEncontrada.getTitularDaConta());
            System.out.println("Agência: " + contaEncontrada.getNumeroDaAgencia());
            System.out.println("Conta: " + contaEncontrada.getNumeroDaConta());
            System.out.println("Saldo: R$ " + contaEncontrada.getSaldo());

            menuConta(contaEncontrada);
        }
    }

    private static void menuConta(ContaBancaria conta) {
        int opcao;

        do {
            System.out.println("\n--- MENU DA CONTA ---");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Pix");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scan.nextInt();
            scan.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do saque: ");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    ServiceConta.sacar(conta, valor);
                }
                case 2 -> {
                    System.out.print("Valor do depósito: ");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    ServiceConta.depositar(conta, valor);
                }

                case 0 -> System.out.println("Saindo da conta...");
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }
}

//    private static void depositar(ContaBancaria origem) {
//
//        System.out.print("Digite a agência destino: ");
//        String agenciaDestino = scan.nextLine();
//
//        System.out.print("Digite a conta destino: ");
//        String contaDestino = scan.nextLine();
//
//        ContaBancaria destino = null;
//
//        for (ContaBancaria c : contas) {
//            if (c.getNumeroDaAgencia().equals(agenciaDestino) &&
//                    c.getNumeroDaConta().equals(contaDestino)) {
//                destino = c;
//                break;
//            }
//        }
//
//        if (destino == null) {
//            System.out.println("Conta destino não encontrada!");
//            return;
//        }
//
//        System.out.print("Digite o valor do depósito: ");
//        double valor = scan.nextDouble();
//        scan.nextLine();
//
//        if (origem.sacar(valor)) {
//            destino.depositar(valor);
//            System.out.println("Depósito realizado com sucesso!");
//            System.out.println("Saldo atual: R$ " + origem.getSaldo());
//        } else {
//            System.out.println("Saldo insuficiente ou valor inválido.");
//        }
//    }
//
//    private static void sacar(ContaBancaria conta) {
//        System.out.print("Digite o valor do saque: ");
//        double valor = scan.nextDouble();
//        scan.nextLine();
//
//        if (conta.sacar(valor)) {
//            System.out.println("Saque realizado com sucesso!");
//            System.out.println("Saldo atual: R$ " + conta.getSaldo());
//        } else {
//            System.out.println("Não foi possível realizar o saque.");
//        }
//    }
//}

