package src.M2;

import java.util.ArrayList;

import static java.lang.System.out;

public class MainM2 {
    public static void main(String[] args) {
        out.println("TESTE 1:");

        // Cria 5 alunos
        Aluno a1 = new Aluno("Aluno 1");
        Aluno a2 = new Aluno("Aluno 2");
        Aluno a3 = new Aluno("Aluno 3");
        Aluno a4 = new Aluno("Aluno 4");
        Aluno a5 = new Aluno("Aluno 5");

        // Cria 1 Disciplina
        Disciplina disciplina = new Disciplina("POO", 20);

        // Inscrever os 5 alunos
        disciplina.inscrever(a1);
        disciplina.inscrever(a2);
        disciplina.inscrever(a3);
        disciplina.inscrever(a4);
        disciplina.inscrever(a5);

        // Desinscrever 1 aluno
        disciplina.desinscrever(a4);

        // Lançar 2 notas
        disciplina.lancarNota(18, a1.getNumero());
        disciplina.lancarNota(20, a2.getNumero());

        // Verificar se tem notas
        boolean temNota1 = disciplina.temNota(a1.getNumero());
        boolean temNota2 = disciplina.temNota(a3.getNumero());

        // Obter notas
        int obterNota1 = disciplina.obterNota(a1.getNumero());
        int obterNota2 = disciplina.obterNota(a2.getNumero());
        int obterNota3 = disciplina.obterNota(a3.getNumero());

        // Dados Discilina
        disciplina.dadosDisciplina();

        out.println("TESTE 2:");

        // Lê a lista alunos de um ficheiro e escreve os dados na consola
        //dadosAlunos();

        Disciplina disciplina2 = Disciplina.criarDisciplinaAutoInscricao("Programação Orientada a Objetos", 10);

        for(Inscricao inscricao : disciplina2.getInscricoes()) {
            if(inscricao.getAluno().getNumero() == 2) {
                disciplina2.lancarNota(18, inscricao.getAluno().getNumero());
            }

            if(inscricao.getAluno().getNumero() == 4) {
                disciplina2.lancarNota(15, inscricao.getAluno().getNumero());
            }
        }

        // Dados Discilina
        disciplina2.dadosDisciplina();

        // Escreve a disciplina num ficheiro
        disciplina2.escreverDisciplinaFicheiro("disciplina");

        out.println("TESTE 3:");

        // Instância uma nova disciplina
        Disciplina disciplina3 = Disciplina.criarDisciplina2Ficheiros();

        // Dados Discilina
        disciplina3.dadosDisciplina();
    }

    // Imprime os dados dos alunos presentes no ficheiro
    public static void dadosAlunos() {
        // Instância uma nova lista de alunos que irá conter os alunos presentes no ficheiro selecionado
        ArrayList<Aluno> alunos = Aluno.lerAlunoFicheiro();

        System.out.println("Alunos:");

        // Percorre cada aluno da lista
        for (Aluno aluno : alunos) {
            out.println("- Aluno: Nº " + aluno.getNumero() + " | Nome: " + aluno.getNome());
        }
    }
}
