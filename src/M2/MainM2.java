package src.M2;

import java.util.ArrayList;

public class MainM2 {
    public static void main(String[] args) {
        // Cria 5 alunos
        Aluno a1 = new Aluno("Aluno 1");
        Aluno a2 = new Aluno("Aluno 2");
        Aluno a3 = new Aluno("Aluno 3");
        Aluno a4 = new Aluno("Aluno 4");
        Aluno a5 = new Aluno("Aluno 5");

        // Cria 1 Disciplina
        Disciplina disciplina = new Disciplina("POO", 20, new ArrayList<>());

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
    }
}
