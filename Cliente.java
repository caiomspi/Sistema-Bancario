import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String endereco;
    private String senha;
    private String usuario;

    private int idade;
    private int id;

    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String usuario, String endereco, int idade, int id, String senha) {

        this.nome = nome;
        this.usuario = usuario;
        this.endereco = endereco;
        this.idade = idade;
        this.id = id;
        this.senha = senha;
    }

    public boolean validacaoSenha(String senha) {
        return senha.equals(this.senha);
    }

    public String getNome() {
        return nome;
    }

    public String getUser() {
        return usuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}