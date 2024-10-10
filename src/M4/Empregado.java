package src.M4;

public class Empregado {

    //region Atributos, Getters e Setters, Construtor

    private String nome;
    private int id;
    public static final double SALARIO_BASE = 800.0;

    public Empregado(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    //endregion

    public double salario(){
        return SALARIO_BASE;
    }

    @Override
    public String toString() {
        return nome + " (" + id + "): " + salario() + " euros";
    }
}
