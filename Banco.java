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

        if (clientes.isEmpty()) {
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
        String descricao=null;
        contas.get(conta-1).setSaldo(contas.get(conta-1).getSaldo()+valor);
        System.out.print("Digite descrição para a transação: ");
        descricao=Main.sc.nextLine();
        contas.get(conta-1).criarExtrato(valor,"D",descricao);
    }

    public void Sacar(double valor, int conta){
        String descricao=null;
        if(valor>contas.get(conta-1).getSaldo()){
            System.out.println("Saldo insuficiente!");
            return;
        }
        else{
            contas.get(conta-1).setSaldo(contas.get(conta-1).getSaldo()-valor);
            System.out.println("Digite uma descrição para a transação: ");
            descricao=Main.sc.nextLine();
            contas.get(conta-1).criarExtrato(valor,"S",descricao);
            System.out.println("Saque feito com sucesso");
        }
    }

    public void criarExtrato(int id_cliente, int id_conta, double valor, String tipo, String descricao){
        clientes.get(id_cliente).getContas().get(id_conta).getExtrato().add(valor, tipo, descricao);
    }

    public void listarExtrato(int id, int conta){
        String tipagem="Sem informação";
        id=id-1;
        conta=conta-1;
        for(int i=0;i<clientes.get(id).getContas().get(conta).getExtrato().size();i++){
            if(clientes.get(id).getContas().get(conta).getExtrato().get(i).getTipo().equals("D")){
                tipagem="Depósito";
            }
            else{
                tipagem="Saque";
            }
            System.out.println("\nValor: " + clientes.get(id).getContas().get(conta).getExtrato().get(i).getValor() + " - Tipo: " + tipagem);
            if(clientes.get(id).getContas().get(conta).getExtrato().get(i).getDescricao().equals("\n")){
                System.out.println("Descrição: " + clientes.get(id).getContas().get(conta).getExtrato().get(i).getDescricao());
            }
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