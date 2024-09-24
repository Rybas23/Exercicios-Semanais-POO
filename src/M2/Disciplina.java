package src.M2;

import java.util.ArrayList;

import static java.lang.System.out;

public class Disciplina {
    //region Atributos

    private final int id;
    private String sigla;
    private int capacidade;
    private ArrayList<Inscricao> inscricoes;

    //endegion

    //region Construtores

    // Construtor base
    public Disciplina() {
        this.id = Settings.getDisciplinaId();
    }

    // Construtor Completo

    public Disciplina(String sigla, int capacidade, ArrayList<Inscricao> inscricoes) {
        this.id = Settings.getDisciplinaId();
        this.sigla = sigla;
        this.capacidade = capacidade;
        this.inscricoes = inscricoes;
    }

    //endregion

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    //endregion

    //region Métodos

    // Verifica se é possivel inscrever o aluno na disciplina, se for inscreve
    public void inscrever(Aluno aluno) {
        // Valida se ainda existem vagas na disciplina
        if(this.inscricoes.size() < capacidade) {
            // Instância uma nova inscrição
            Inscricao inscricao = new Inscricao(Settings.semNota, aluno);

            // Adiciona a nova inscrição à lista
            this.inscricoes.add(inscricao);
        }
    }

    // Método auxiliar para procurar o aluno desejado na lista de Inscrições
    private int getAlunoInscricoes(Aluno aluno) {
        // Instância uma variavel auxiliar para guardar o index da inscrição
        int index = 0;

        // Percorre a lista de inscrições
        for (Inscricao inscricao : inscricoes) {
            // Verifica se o aluno existe neste index da lista
            if (inscricao.getAluno().equals(aluno)) {
                // retorna o aluno encontrado
                return index;
            }

            // Incrementa +1 no index de inscrições
            index++;
        }

        // Retorna -1 (inscrição não encontrada)
        return -1;
    }

    public void desinscrever(Aluno aluno) {
        // Valida se existem inscrições e se o aluno está inscrito
        if(!this.inscricoes.isEmpty()) {
            // Recebe o index da inscrição do aluno
            int index = getAlunoInscricoes(aluno);

            // Valida se o index é maior de -1, ou seja, se existe
            if(index > -1) {
                // Remove a inscrição do aluno
                this.inscricoes.remove(index);
            }
        }
    }

    // Método auxiliar para procurar o aluno desejado na lista de Inscrições a partir do seu numero
    private int getAlunoInscricoesByNumber(int numeroAluno) {
        // Instância uma variavel auxiliar para guardar o index da inscrição
        int index = 0;

        // Percorre a lista de inscrições
        for (Inscricao inscricao : inscricoes) {
            // Verifica se o aluno existe neste index da lista
            if (inscricao.getAluno().getNumero() == numeroAluno) {
                // retorna o aluno encontrado
                return index;
            }

            // Incrementa +1 no index de inscrições
            index++;
        }

        // Retorna -1 (inscrição não encontrada)
        return -1;
    }

    // lanca a nota a um aluno caso a nota seja valida, e caso a inscrição exista
    public void lancarNota(int nota, int numeroAluno) {
        // Valida se a nota é válida
        if((nota >= 0 && nota <= 20)) {
            // Recebe o index da inscrição do aluno
            int indexInscricao = getAlunoInscricoesByNumber(numeroAluno);

            // Valida se a inscrição do aluno existe
            if(indexInscricao > -1) {
                // Define a nota do aluno
                this.inscricoes.get(indexInscricao).setNota(nota);
            }
        }
    }

    // Verifica se o aluno tem nota
    public boolean temNota(int numeroAluno) {
        // Recebe o index da inscrição do aluno
        int indexInscricao = getAlunoInscricoesByNumber(numeroAluno);

        // Valida se a inscrição do aluno existe
        if(indexInscricao > -1) {
            // Retorna true ou false, dependendo se o aluno tem nota ou não
            return this.inscricoes.get(indexInscricao).temNota();
        }

        // Retorna false
        return false;
    }

    // Retorna a nota do aluno
    public int obterNota(int numeroAluno) {
        // Recebe o index da inscrição do aluno
        int indexInscricao = getAlunoInscricoesByNumber(numeroAluno);

        // Valida se a inscrição do aluno existe
        if(indexInscricao > -1) {
            // Retorna true ou false, dependendo se o aluno tem nota ou não
            return this.inscricoes.get(indexInscricao).getNota();
        }

        // Retorna a constante semNota (-1)
        return Settings.semNota;
    }

    // Calcula e retorna a média das notas atribuidas
    public double notaMedia() {
        // Variavel que vai guardar o total da soma das notas
        double somaNotas = 0;

        // Variavel auxiliar para guardar a quantiadade de notas não atribuidas
        int notasNaoAtribuidasCount = 0;

        // Percorre a lista de inscrições
        for (Inscricao inscricao : inscricoes) {
            // Verifica se o aluno tem uma nota atribuida
            if(inscricao.getNota() != Settings.semNota) {
                // Soma a nota do aluno à soma das notas
                somaNotas += inscricao.getNota();
            } else {
                // Incrementa +1 nas notas não atribuidas
                notasNaoAtribuidasCount++;
            }
        }

        // Calcula e retorna a média das notas atribuidas
        return somaNotas / (this.inscricoes.size() - notasNaoAtribuidasCount);
    }

    // Constroi uma lista com as 3 melhores notas da disciplina
    public ArrayList<Aluno> melhoresAlunos() {
        // Instância uma nova lista que irá conter os melhores alunos da disciplina
        ArrayList<Aluno> melhoresAlunos = new ArrayList<>();

        // Verifica se existem alunos inscritos na disciplina
        if (!this.inscricoes.isEmpty()) {
            // Organiza a lista de inscrições por nota
            this.inscricoes.sort(Inscricao::compareTo);

            // Vai passar por cada incrição até chegar ao top 3
            for (int index = 0; index < 3; index++) {
                // Verifica se o aluno tem nota
                if(this.inscricoes.get(index).temNota()) {
                    // Preenche a lista dos melhores alunos com o top 3 das melhores notas
                    melhoresAlunos.add(this.inscricoes.get(index).getAluno());
                }
            }
        }

        // Retorna a lista de alunos
        return melhoresAlunos;
    }

    // Mostra todos os dados sobre a disciplina
    public void dadosDisciplina() {
        out.println("Disciplina:");
        out.println(" ");
        out.println("Sigla: " + this.sigla);
        out.println("Capacidade: " + this.capacidade);
        out.println(" ");
        out.println("Inscrições: ");

        // Verifica se a lista tem registos
        if(!this.inscricoes.isEmpty()) {
            // Percorre cada registo da lista
            for (Inscricao inscricao : inscricoes) {
                // Verifica se o aluno tem nota
                String nota = (inscricao.temNota()) ? String.valueOf(inscricao.getNota()) : "NA";

                out.println("- Aluno: Nº " + inscricao.getAluno().getNumero() + " | Nome: " + inscricao.getAluno().getNome());
                out.println("- Nota: " + nota);
                out.println(" ");
            }
        }

        out.println("Média: " + notaMedia());
        out.println(" ");
        out.println("Melhores Alunos: ");

        // Raecebe a lista com os melhores alunos
        ArrayList<Aluno> melhoresAlunos = melhoresAlunos();

        // Verifica se a lista tem registos
        if(!melhoresAlunos.isEmpty()) {
            // Percorre cada registo da lista
            for (Aluno aluno : melhoresAlunos) {
                out.println("- Aluno: Nº " + aluno.getNumero() + " | Nome: " + aluno.getNome());
                out.println(" ");
            }
        }
    }

    //endregion
}
