import java.util.ArrayList;

public class Conta {

    private Cliente dono;
    private int id;
    private double saldo;
    private boolean ativa;

    private ArrayList<Movimentacao> extrato = new ArrayList<>();

    public Conta(Cliente dono, int id) {

        this.dono = dono;
        this.id = id;

        saldo = 0;
        ativa = true;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public ArrayList<Movimentacao> getExtrato(){
        return extrato;
    }

    public void setSaldo(double valor){
        saldo=valor;
    }

    public void criarExtrato(double valor, String tipo, String descricao){
        Movimentacao movimentacao = new Movimentacao(valor, tipo, descricao);
        extrato.add(movimentacao);
        System.out.println("Movimentação realizada com sucesso!");
    }
}