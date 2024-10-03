package src.M3;


import java.util.Comparator;

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

    //region Comparadores

    /**
     * Comparador por Numero
     */
    public static class AlunoComparatorNumero implements Comparator<Aluno> {
        /**
         * Compara os alunos por numero
         * @param a1 the first object to be compared.
         * @param a2 the second object to be compared.
         * @return
         */
        @Override
        public int compare(Aluno a1, Aluno a2) {
            // Verifica se o numero do primeiro aluno é maior do que o do segundo
            if (a1.getNumero() > a2.getNumero()) {
                // Retorna 1 caso o a1 seja maior que o a2
                return 1;
            } else if (a1.getNumero() < a2.getNumero()) {
                // Retorna -1 caso o a2 seja maior que o a1
                return -1;
            }

            // Retorna 0 caso sejam iguais
            return 0;
        }
    }

    /**
     * Comparador por Nome
     */
    public static class AlunoComparatorNome implements Comparator<Aluno> {
        /**
         * Compara os alunos por nome de forma crescente alfabeticamente
         * @param a1 the first object to be compared.
         * @param a2 the second object to be compared.
         * @return
         */
        @Override
        public int compare(Aluno a1, Aluno a2) {
            // Compara os nomes dos dois alunos
            return String.CASE_INSENSITIVE_ORDER.compare(a1.getNome(), a2.getNome());
        }
    }

    /**
     * Comparador por Ano de Nascimento
     */
    public static class AlunoComparatorAnoNascimento implements Comparator<Aluno> {
        /**
         * Primeiro compara os alunos pelo ano de nascimento para ver quem é mais novo,
         * caso os anos sejam iguais vai comparar pelo ano de matricula mais recente,
         * se os anos forem iguais, vai comparar por nome em ordem alfabetica crescente
         * @param a1 the first object to be compared.
         * @param a2 the second object to be compared.
         * @return
         */
        @Override
        public int compare(Aluno a1, Aluno a2) {
            // Verifica qual dos alunos é mais novo
            if (a1.getAnoNascimento() > a2.getAnoNascimento()) {
                // Retorna -1 caso o a1 seja mais velho que o a2
                return -1;
            } else if (a1.getAnoNascimento() < a2.getAnoNascimento()) {
                // Retorna 1 caso o a1 seja mais novo que o a2
                return 1;
            }

            // Se os alunos tiverem o mesma ano de nascimento vai comparar
            // pelo ano da matricula, e ordenar pela mais recente
            if (a1.getAnoMatricula() > a2.getAnoMatricula()) {
                // Retorna -1 caso a matricula do a1 seja mais antiga que a do a2
                return -1;
            } else if (a1.getAnoMatricula() < a2.getAnoMatricula()) {
                // Retorna 1 caso a matricula do a1 seja mais recente que a do a2
                return 1;
            }

            // Caso o ano de nascimento e o ano da matricula sejam iguais então vai comparar por nome
            return new AlunoComparatorNome().compare(a1, a2);
        }
    }

    //endregion
}
