package src.M2;

public class Inscricao implements Comparable<Inscricao> {
    //region Atributos

    private int nota;
    private Aluno aluno;

    //endegion

    //region Construtores

    /**
     * Construtor Completo
     * @param nota
     * @param aluno
     */
    public Inscricao(int nota, Aluno aluno) {
        this.nota = nota;
        this.aluno = aluno;
    }

    //endregion

    //region Getters & Setters

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

    /**
     * Valida se o aluno tem nota
     * @return
     */
    public boolean temNota() {
        return this.nota != Settings.semNota;
    }

    //endegion

    //region Comparator

    /**
     * Override do método compareTo para organizar a lista de inscrições pela nota mais alta
     * @param otherInscricao the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Inscricao otherInscricao) {
        return Integer.compare(otherInscricao.getNota(), getNota());
    }

    //endregion
}
