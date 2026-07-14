import java.util.Scanner;
public class Main {
    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int resposta=0;
        while(resposta!=3){
            System.out.print("------- Bem Vindo! -------\n\n1 - Cliente\n2 - Admin\n3 - Sair\n\nResposta: ");
            resposta=Integer.valueOf(sc.nextLine());
            switch(resposta){
                case(1):
                    System.out.print("\nLogin: ");
                    System.out.print("\nSenha: ");
                    break;
                
                case(2):
                    System.out.print("\nLogin: ");
                    System.out.print("\nSenha: ");
                    System.out.print("\n------- Bem Vindo -------\n\n1 - Adicionar Cliente\n2 - Listar Cliente\n3 - Sair\n\nResposta: ");
                    resposta=Integer.valueOf(sc.nextLine());
                    switch(resposta){
                        case(1):
                            MenuCadastroCliente();
                            break;

                        case(2):
                            banco.ListarCliente();
                            break;

                        case(3):
                            break;

                    }
                    break;
                
                case(3):
                    return;
                
                default:
                    System.out.println("Digite um valor válido!");
            }
        }
    }
    public void MenuCliente(){
        System.out.println("");
    }

    public void MenuAdmin(){
        System.out.print("Bem Vindo ao Menu Admin!");

    }
    public static void MenuCadastroCliente(){
        int idade;
        String nome, endereco;
        boolean validacao=false;
        System.out.print("Digite o nome: ");
        nome=sc.nextLine();
        System.out.print("Digite o endereco: ");
        endereco=sc.nextLine();
        while(validacao==false){
            try {
                System.out.print("Digite a idade: ");
                idade=Integer.valueOf(sc.nextLine());
                validacao=true;
                banco.CriarCliente(nome, endereco, idade);
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
            }
        }
        validacao=false;
    }
}