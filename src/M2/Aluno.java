package src.M2;

public class Aluno {
    //region Atributos

    private final int id;
    private int numero;
    private String nome;

    //endregion

    //region Construtores

    // Construtor base
    public Aluno() {
        this.id = Settings.getAlunoId();
    }

    // Construtor Completo
    public Aluno(String nome) {
        this.id = Settings.getAlunoId();
        this.numero = Settings.getNumeroAluno();
        this.nome = nome;
    }

    //endregion

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //endregion
}
