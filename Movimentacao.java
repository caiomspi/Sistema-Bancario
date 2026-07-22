public class Movimentacao {

    private String data;
    private double valor;
    private String tipo;
    private String descricao;

    public Movimentacao(double valor, String tipo, String descricao, String data){
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

    public String getData(){
        return data;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
}