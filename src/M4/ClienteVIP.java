package src.M4;

public class ClienteVIP extends Cliente{
    public static final int vipValue = 1000;

    //region Atributos

    private double desconto;

    //endregion

    //Construtores

    public ClienteVIP(String nome, String identificacao, double mediaCompras, double desconto) {
        super(nome, identificacao, mediaCompras);
        this.desconto = desconto;
    }

    //endregion

    //region Getters e Setters

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    //endregion

    //region Métodos


    @Override
    public String toString() {
        return "ClienteVIP{" +
                "nome='" + super.getNome() + '\'' +
                ", identificacao='" + super.getIdentificacao() + '\'' +
                ", mediaCompras=" + super.getMediaCompras() +
                ", desconto=" + desconto +
                '}';
    }

    @Override
    public double valorAaPagarComDesconto(double valorPagar) {
        return super.valorAaPagarComDesconto(valorPagar) * desconto;
    }

    //endregion
}
