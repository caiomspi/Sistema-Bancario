import java.util.ArrayList;

public class Banco {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();

    private int proxIdCliente = 1;
    private int proxIdConta = 1;

    public void criarCliente(String nome, String usuario, String endereco, int idade, String senha) {

        if (idade < 18) {
            System.out.println("Idade inválida!");
            return;
        }

        Cliente cliente = new Cliente(nome, usuario, endereco, idade, proxIdCliente, senha);
        clientes.add(cliente);

        proxIdCliente++;

        System.out.println("\nCliente cadastrado com sucesso!\n");
    }

    public void listarCliente() {

        if (clientes.size() == 0) {
            System.out.println("Não existem clientes!");
        } else {

            for (int i = 0; i < clientes.size(); i++) {

                System.out.println("\nNome: " + clientes.get(i).getNome()
                        + "\nEndereço: " + clientes.get(i).getEndereco()
                        + "\nIdade: " + clientes.get(i).getIdade()
                        + "\nId: " + clientes.get(i).getId());
            }
        }
    }

    public boolean validacaoUser(String user) {

        if (clientes.size() == 0) {
            return true;
        }

        for (int i = 0; i < clientes.size(); i++) {

            if (user.equals(clientes.get(i).getUser())) {
                return false;
            }
        }

        return true;
    }

    public Cliente ValidacaoLogin(String login, String senha) {

        for (int i = 0; i < clientes.size(); i++) {

            if (login.equals(clientes.get(i).getUser())
                    && clientes.get(i).validacaoSenha(senha)) {

                return clientes.get(i);
            }
        }

        return null;
    }

    public boolean ValidacaoId(Cliente cliente, int id){
        for(int i=0;i<cliente.tamContas();i++){
            if(id==cliente.getContas().get(i).getId()){
                return true;
            }
        }
        return false;
    }

    public void criarConta(Cliente cliente) {

        if (contas.size() == 3) {
            System.out.println("Limite de contas atingido!");
            return;
        }

        Conta conta = new Conta(cliente, proxIdConta);

        contas.add(conta);
        cliente.getContas().add(conta);

        proxIdConta++;

        System.out.println("\nConta criada com sucesso!\n");
    }

    public void listarContas(Cliente cliente) {

        String ativa;

        for (int i = 0; i < cliente.tamContas(); i++) {

            if (contas.get(i).getAtiva()) {
                ativa = "Ativa";
            } else {
                ativa = "Desativada";
            }

            System.out.println("Id: " + contas.get(i).getId()
                    + " - Saldo: " + contas.get(i).getSaldo()
                    + " - " + ativa + "\n");
        }
    }

    public void Depositar(double valor, int conta){
        contas.get(conta-1).setSaldo(contas.get(conta-1).getSaldo()+valor);

    }

    public void Sacar(double valor, int conta){
        if(valor>contas.get(conta-1).getSaldo()){
            System.out.println("Saldo insuficiente!");
            return;
        }
        else{
            contas.get(conta-1).setSaldo(contas.get(conta).getSaldo()-valor);
            System.out.println("Deposito feito com sucesso");
        }
    }

    //getters
    public int tamanhoClientes() {
        return clientes.size();
    }

    public int tamanhoContas() {
        return contas.size();
    }
}