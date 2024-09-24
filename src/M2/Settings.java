package src.M2;

public class Settings {
    //region Variaveis

    // Instancia as variaveis com os varios ids
    private static int alunoId = 0;
    private static int disciplinaId = 0;
    private static int inscricaoId = 0;

    // Instancia a variavel com oo numero do aluno
    private static int numeroAluno = 1;

    // Instância uma constante para definir os alunos sem nota
    public static final int semNota = -1;

    //endregion

    //region Metodos

    // Retorna o numero do aluno e incrementa + 1
    public static int getNumeroAluno() {
        return numeroAluno++;
    }

    // Retorna o id do aluno e incrementa + 1
    public static int getAlunoId() {
        return alunoId++;
    }

    // Retorna o id da disciplina e incrementa + 1
    public static int getDisciplinaId() {
        return disciplinaId++;
    }

    // Retorna o id da Incricao e incrementa + 1
    public static int getInscricaoId() {
        return inscricaoId++;
    }

    //endregion
}
