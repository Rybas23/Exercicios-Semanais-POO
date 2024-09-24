package src.M2;

public class Inscricao implements Comparable<Inscricao> {
    //region Atributos

    private final int id;
    private int nota;
    private Aluno aluno;

    //endegion

    //region Construtores

    // Construtor base
    public Inscricao() {
        this.id = Settings.getInscricaoId();
    }

    // Construtor Completo
    public Inscricao(int nota, Aluno aluno) {
        this.id = Settings.getInscricaoId();
        this.nota = nota;
        this.aluno = aluno;
    }

    //endregion

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    //endregion

    //region Métodos

    // Valida se o aluno tem nota
    public boolean temNota() {
        return this.nota != Settings.semNota;
    }

    //endegion

    //region Comparator

    @Override
    public int compareTo(Inscricao otherInscricao) {
        return Integer.compare(otherInscricao.getNota(), getNota());
    }

    //endregion
}
