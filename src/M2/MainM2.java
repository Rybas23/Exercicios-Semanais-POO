package src.M2;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.err;
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
        dadosAlunos();

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

        out.println(" ");
        out.println("TESTE 4:");

        // Instância um novo File que irá conter a localização da pasta principal
        File dir = new File(System.getProperty("user.dir") + "/AN/");

        // Chama a função que imprime na consola os ficheiros de uma pasta
        printCollectFilesDir(dir);

        out.println(" ");
        out.println("TESTE 5:");

        // Chama a função que preenche uma lista com os ficheiros de uma pasta e com os ficheiros das sub-pastas
        try {
            printCollectedFiles(dir);
        } catch (IOException e) {
            err.println("Ocorreu um erro!");
        }
    }

    // Imprime os dados dos alunos presentes no ficheiro
    public static void dadosAlunos() {
        try {
            // Instância uma nova lista de alunos que irá conter os alunos presentes no ficheiro selecionado
            ArrayList<Aluno> alunos = Aluno.lerAlunoFicheiro();

            System.out.println("Alunos:");

            // Percorre cada aluno da lista
            for (Aluno aluno : alunos) {
                out.println("- Aluno: Nº " + aluno.getNumero() + " | Nome: " + aluno.getNome());
            }
        } catch (Exception e) {
            err.println("Ocorreu um erro!");
        }
    }

    /**
     * Coleta os ficheiros de uma pasta e imprime-os na consola
     * @param dir
     */
    public static void printCollectFilesDir(File dir) {
        try {
            // Cria um filtro para os ficheiros para que apenas devolva os ficheiros e não as pastas
            FileFilter fileFilter = new FileFilter() {
                public boolean accept(File file) {
                    return file.isFile();
                }
            };

            out.println("java ListFiles " + dir.getName());

            // Cria um array com os ficheiros presentes no diretorio
            File[] files = dir.listFiles(fileFilter);

            // Verifica se existem ficheiros na pasta
            if(files != null) {
                // Passa por cada ficheiro
                for (File file : files) {
                    // Guarda o falor do path do ficheiro numa variavel
                    String filePath = file.getPath();
                    out.println(filePath.substring(filePath.indexOf("\\" + dir.getName())));
                }
            }
        } catch (Exception e) {
            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Coleta os ficheiros de cada pasta recursivamente
     * @param dir
     * @param list
     */
    private static void collectFilesRec(File dir, ArrayList<File> list) {
        try {
            // Instância um array com os ficheiros presentes no diretorio
            File[] files = dir.listFiles();

            // Verifica se existem ficheiros na pasta
            if(files != null) {
                // Passa por cada ficheiro
                for (File file : files) {
                    // Verifica se o ficheiro é um diretorio, caso seja volta a chamar
                    // a função de forma recursiva, com o diretorio no parametro de entrado
                    // se não adiciona o ficheiro à lista
                    if(file.isDirectory()) {
                        // Volta a chamar a função de forma recursiva
                        collectFilesRec(file, list);
                    } else {
                        // Adiciona o ficheiro à lista de ficheiros
                        list.add(file);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Coleta os ficheiros e as subs-pastas com os respetivos ficheiros de uma pasta
     * @param dir
     * @return
     */
    public static ArrayList<File> collectFiles(File dir) {
        // Instância a lista que vai conter os ficheiros
        ArrayList<File> list = new ArrayList<>();

        try {
            // Chama a função que irá preencher a lista com os ficheiros do diretorio principal e dos subdiretorios
            collectFilesRec(dir, list);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro!");
        }

        // Retorna a lista de ficheiros
        return list;
    }

    public static void printCollectedFiles(File dir) throws IOException {
        // Instância uma nova lista de ficheiros que irá conter todos os ficheiros da pasta principal e da sub-pasta
        ArrayList<File> list = collectFiles(dir);

        out.println("java ListFiles -r " + dir.getName());

        // Verifica se a lista está vazia
        if(!list.isEmpty()) {
            // Passa por cada ficheiro da lista
            for (File file : list) {
                // Guarda o falor do path do ficheiro numa variavel
                String filePath = file.getPath();
                out.println(filePath.substring(filePath.indexOf("\\" + dir.getName())));
            }
        }
    }
}
