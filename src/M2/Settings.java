package src.M2;

public class Settings {
    //region Variaveis

    // Instancia a variavel com oo numero do aluno
    private static int numeroAluno = 1;

    // Instância uma constante para definir os alunos sem nota
    public static final int semNota = -1;

    // Instância uma constante para definir quem não tem nota, versão String
    public static final String semNotaString = "NA";

    //endregion

    //region Metodos

    // Retorna o numero do aluno e incrementa + 1
    public static int getNumeroAluno() {
        return numeroAluno++;
    }

    //endregion
}
