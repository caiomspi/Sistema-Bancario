import java.time.LocalDate;

public class Movimentacao {

    private LocalDate data;
    private double valor;
    private String tipo;
    private String descricao;

    public Movimentacao(double valor, String tipo, String descricao){
        this.valor=valor;
        this.tipo=tipo;
        this.descricao=descricao;
    }

    public double getValor(){
        return valor;
    }

    public String getTipo(){
        return tipo;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setValor(double Valor){
        this.valor=valor;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
}