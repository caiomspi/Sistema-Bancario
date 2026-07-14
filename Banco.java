import java.util.ArrayList;
public class Banco{
    int i;
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Conta> contas = new ArrayList<>();
    public void CriarCliente(String nome, String endereco, int idade){
        if(idade<18){ //validacao de idade
            System.out.println("Idade inválida!");
            return;
        }
        else{
            Cliente cliente = new Cliente(nome, endereco, idade);
            clientes.add(cliente);
        }
    }

    public void ListarCliente(){
        for(i=0;i<clientes.size();i++){
            System.out.println("Nome: "+clientes.get(i).nome+"\nEndereço: "+clientes.get(i).endereco+"\nIdade: "+clientes.get(i).idade);
        }
    }
}