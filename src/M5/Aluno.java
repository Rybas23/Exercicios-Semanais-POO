package src.M5;

public class Aluno {
    //region Atributos

    int numero;
    String nome;
    int anoMatricula;
    int anoNascimento;

    //endregion

    //region Construtores

    /**
     * Construtor Completo
     * @param numero
     * @param nome
     * @param anoMatricula
     * @param anoNascimento
     */
    public Aluno(int numero, String nome, int anoMatricula, int anoNascimento) {
        this.numero = numero;
        this.nome = nome;
        this.anoMatricula = anoMatricula;
        this.anoNascimento = anoNascimento;
    }

    //endregion

    //region Getters & Setters

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    //endregion

    //region Métodos

    @Override
    public String toString() {
        return "Aluno{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", anoMatricula=" + anoMatricula +
                ", anoNascimento=" + anoNascimento +
                '}';
    }


    //endregion
}
