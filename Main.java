import java.util.Scanner;

public class Main {
    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // declaracao de variaveis
        int resposta = 0;
        String login, senha;
        boolean validacao = false, menu = true;
        Cliente cliente;

        // menu do sistema
        while (resposta != 3) {
            while (validacao == false) {
                System.out.print("------- Bem Vindo! -------\n\n1 - Cliente\n2 - Admin\n3 - Sair\n\nResposta: ");
                try {
                    resposta = Integer.valueOf(sc.nextLine());
                    validacao = true;
                } catch (Exception e) {
                    System.out.println("\nDigite um valor válido!\n");
                }
            }
            validacao = false;

            switch (resposta) {

                // menu cliente
                case 1:

                    if (banco.tamanhoClientes() == 0) {
                        System.out.println("Não existem clientes cadastrados!");
                        break;
                    } else {

                        System.out.print("\nLogin: ");
                        login = sc.nextLine();

                        System.out.print("Senha: ");
                        senha = sc.nextLine();

                        cliente = banco.ValidacaoLogin(login, senha);

                        if (cliente != null) {

                            System.out.println("\nLogin verificado!\n");

                            while (menu == true) {

                                System.out.println("------- Bem Vindo! -------");

                                if (banco.tamanhoContas() == 0) {

                                    while (validacao == false) {

                                        System.out.print("1 - Criar Conta\n2 - Sair\n\nResposta: ");

                                        try {
                                            resposta = Integer.valueOf(sc.nextLine());
                                            validacao = true;
                                        } catch (Exception e) {
                                            System.out.println("\nDigite um valor válido!\n");
                                        }
                                    }

                                    validacao = false;

                                    switch (resposta) {

                                        case 1:
                                            banco.criarConta(cliente);
                                            break;

                                        case 2:
                                            menu = false;
                                            break;

                                        default:
                                            System.out.println("Digite um valor valido!");
                                            break;
                                    }

                                } else {

                                    while (validacao == false) {

                                        System.out.print(
                                                "1 - Criar Conta\n2 - Listar Conta\n3 - Consultar saldo\n4 - Depositar\n5 - Sacar\n6 - Extrato\n7 - Sair\n\nResposta: ");

                                        try {
                                            resposta = Integer.valueOf(sc.nextLine());
                                            validacao = true;
                                        } catch (Exception e) {
                                            System.out.println("\nDigite um valor válido!\n");
                                        }
                                    }

                                    validacao = false;

                                    switch (resposta) {

                                        case 1:
                                            banco.criarConta(cliente);
                                            break;

                                        case 2:
                                            banco.listarContas(cliente);
                                            break;

                                        case 3:
                                            break;

                                        case 4:
                                            break;

                                        case 5:
                                            break;

                                        case 6:
                                            break;

                                        case 7:
                                            menu = false;
                                            break;

                                        default:
                                            System.out.println("Digite um valor valido!");
                                            break;
                                    }
                                }

                                resposta = 1;
                            }

                        } else {
                            System.out.println("Login ou senha inválido");
                        }

                        break;
                    }

                // menu admin
                case 2:

                    System.out.print("\nLogin: ");
                    login = sc.nextLine();

                    System.out.print("Senha: ");
                    senha = sc.nextLine();

                    if (login.equals("admin") && senha.equals("admin")) {

                        while (validacao == false) {

                            try {
                                System.out.print(
                                        "\n------- Bem Vindo -------\n\n1 - Adicionar Cliente\n2 - Listar Cliente\n3 - Sair\n\nResposta: ");

                                resposta = Integer.valueOf(sc.nextLine());
                                validacao = true;

                            } catch (Exception e) {
                                System.out.println("\nDigite um valor válido!\n");
                            }
                        }

                        validacao = false;

                        switch (resposta) {

                            case 1:
                                MenuCadastroCliente();
                                break;

                            case 2:
                                banco.listarCliente();
                                break;

                            case 3:
                                break;
                        }
                    }

                    resposta = 2;
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Digite um valor válido!");
            }
        }
    }

    public void MenuCliente() {
        System.out.println("");
    }

    public void MenuAdmin() {
        System.out.print("Bem Vindo ao Menu Admin!");
    }

    public static void MenuCadastroCliente() {

        int idade;
        String nome, endereco, senha, usuario = null;
        boolean validacao = false;

        System.out.print("Digite o nome: ");
        nome = sc.nextLine();

        while (validacao == false) {

            System.out.print("Digite o nome de usuário da conta: ");
            usuario = sc.nextLine();

            if (banco.validacaoUser(usuario) == false) {
                System.out.println("Nome de usuário já escolhido!");
            } else {
                validacao = true;
            }
        }

        validacao = false;

        System.out.print("Digite o endereco: ");
        endereco = sc.nextLine();

        System.out.print("Digite a senha da conta: ");
        senha = sc.nextLine();

        while (validacao == false) {

            try {
                System.out.print("Digite a idade: ");
                idade = Integer.valueOf(sc.nextLine());

                validacao = true;
                banco.criarCliente(nome, usuario, endereco, idade, senha);

            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
            }
        }
    }
}