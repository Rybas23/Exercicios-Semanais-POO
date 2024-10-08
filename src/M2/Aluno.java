package src.M2;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    //region Atributos

    private int numero;
    private String nome;

    //endregion

    //region Construtores

    /**
     * Construtor Completo alternativo
     * @param numero
     * @param nome
     */
    public Aluno(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    /**
     * Construtor Completo
     * @param nome
     */
    public Aluno(String nome) {
        this.numero = Settings.getNumeroAluno();
        this.nome = nome;
    }

    //endregion

    //region Getters & Setters

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    //endregion

    //region Métodos

    @Override
    public String toString() {
        return "Aluno {numero = " + numero + ", nome = " + nome + '}';
    }

    /**
     * Lê o ficheiro que o utilizador escolher e escreve o seu conteudo, neste caso os varios alunos, na lista alunos
     * @return
     */
    public static ArrayList<Aluno> lerAlunoFicheiro() {
        try {
            // InstÂncia a lista alunos
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();

            // Instância o dialog que vai ser utilizado para escolher o ficheiro
            FileDialog dialog = new FileDialog((Frame)null, "Selecione o ficheiro dos alunos");

            // Define propriedades do dialog, neste caso o modo de load e a visibilidade
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);

            // Instância o ficheiro a partir da localização do ficheiro escolhido
            File file = new File(dialog.getDirectory() + dialog.getFile());

            // Dá "dispose" ao dialog, ou seja, exclui
            dialog.dispose();

            // Tenta ler o que está no ficheiro
            Scanner scanner = new Scanner(file);

            // Lê as linhas do ficheiro enquanto existirem
            while(scanner.hasNextLine()) {
                // Guarda a linha numa string
                String line = scanner.nextLine();

                // Divide a linha em varios items, para termos uma string com o numero e outra com o nome
                String items[] = line.split(" ", 2);

                //  Instância um novo aluno e adiciona-o á lista
                alunos.add(new Aluno(Integer.parseInt(items[0]), items[1]));
            }

            // Fecha o scanner que está a ler o ficheiro
            scanner.close();

            // Retorna a lista alunos
            return alunos;
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro nao encontrado!");

            // Return de null visto que houve exceção
            return null;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro!");

            // Return de null visto que houve exceção
            return null;
        }
    }

    //endregion
}
