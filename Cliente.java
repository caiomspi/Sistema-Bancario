import java.util.ArrayList;

public class Cliente{
    String nome, endereco;
    int id, idade;
    ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String endereco, int idade){
        this.nome=nome;
        this.endereco=endereco;
        this.idade=idade;
    }
}
