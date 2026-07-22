import java.time.LocalDateTime;

public class Movimentacao {

    private LocalDateTime data;
    private double valor;
    private String tipo;
    private String descricao;

    public Movimentacao(double valor, String tipo, String descricao, LocalDateTime data){
        this.valor=valor;
        this.tipo=tipo;
        this.descricao=descricao;
        this.data=data;
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

    public LocalDateTime getData(){
        return data;
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