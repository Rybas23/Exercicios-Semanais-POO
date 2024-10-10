package src.M4;

public class Cliente {
    //region Atributos

    private String nome;
    private String identificacao;
    private double mediaCompras;

    //endregion

    //region Construtores

    public Cliente(String nome, String identificacao, double mediaCompras) {
        this.nome = nome;
        this.identificacao = identificacao;
        this.mediaCompras = mediaCompras;
    }

    //endregion

    //region Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public double getMediaCompras() {
        return mediaCompras;
    }

    public void setMediaCompras(double mediaCompras) {
        this.mediaCompras = mediaCompras;
    }

    //endregion

    //region Métodos


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", identificacao='" + identificacao + '\'' +
                ", mediaCompras=" + mediaCompras +
                '}';
    }

    public double valorAaPagarComDesconto(double valorPagar) {
        return valorPagar;
    }

    //endregion
}
