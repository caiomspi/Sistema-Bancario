import java.util.ArrayList;
public class Conta{
    Cliente dono;
    int id;
    double saldo;
    boolean ativa;
    ArrayList<Movimentacao> extrato = new ArrayList<>();
}