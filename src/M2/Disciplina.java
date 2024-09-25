package src.M2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Disciplina {
    //region Atributos

    private String sigla;
    private int capacidade;
    private ArrayList<Inscricao> inscricoes;

    //endegion

    //region Construtores

    /**
     * Construtor sem inscrições
     * @param sigla
     * @param capacidade
     */
    public Disciplina(String sigla, int capacidade) {
        this.sigla = sigla;
        this.capacidade = capacidade;
        this.inscricoes = new ArrayList<>();
    }

    /**
     * Construtor Completo
     * @param sigla
     * @param capacidade
     * @param inscricoes
     */
    public Disciplina(String sigla, int capacidade, ArrayList<Inscricao> inscricoes) {
        this.sigla = sigla;
        this.capacidade = capacidade;
        this.inscricoes = inscricoes;
    }

    //endregion

    //region Getters & Setters

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

    /**
     * Verifica se é possivel inscrever o aluno na disciplina, se for inscreve
     * @param aluno
     */
    public void inscrever(Aluno aluno) {
        try {
            // Valida se ainda existem vagas na disciplina
            if(this.inscricoes.size() < capacidade) {
                // Instância uma nova inscrição
                Inscricao inscricao = new Inscricao(Settings.semNota, aluno);

                // Adiciona a nova inscrição à lista
                this.inscricoes.add(inscricao);
            }
        } catch  (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Método auxiliar para procurar o aluno desejado na lista de Inscrições
     * @param aluno
     * @return
     */
    private int getAlunoInscricoes(Aluno aluno) {
        try {
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
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }

        // Retorna -1 (inscrição não encontrada)
        return -1;
    }

    /**
     * Desinscreve um aluno da Disciplina
     * @param aluno
     */
    public void desinscrever(Aluno aluno) {
        try {
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
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Método auxiliar para procurar o aluno desejado na lista de Inscrições a partir do seu numero
     * @param numeroAluno
     * @return
     */
    private int getAlunoInscricoesByNumber(int numeroAluno) {
        try {
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
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }

        // Retorna -1 (inscrição não encontrada)
        return -1;
    }

    /**
     * lanca a nota a um aluno caso a nota seja valida, e caso a inscrição exista
     * @param nota
     * @param numeroAluno
     */
    public void lancarNota(int nota, int numeroAluno) {
        try {
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
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Verifica se o aluno tem nota
     * @param numeroAluno
     * @return
     */
    public boolean temNota(int numeroAluno) {
        try {
            // Recebe o index da inscrição do aluno
            int indexInscricao = getAlunoInscricoesByNumber(numeroAluno);

            // Valida se a inscrição do aluno existe
            if(indexInscricao > -1) {
                // Retorna true ou false, dependendo se o aluno tem nota ou não
                return this.inscricoes.get(indexInscricao).temNota();
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }

        // Retorna false
        return false;
    }

    /**
     * Retorna a nota do aluno
     * @param numeroAluno
     * @return
     */
    public int obterNota(int numeroAluno) {
        try {
            // Recebe o index da inscrição do aluno
            int indexInscricao = getAlunoInscricoesByNumber(numeroAluno);

            // Valida se a inscrição do aluno existe
            if(indexInscricao > -1) {
                // Retorna true ou false, dependendo se o aluno tem nota ou não
                return this.inscricoes.get(indexInscricao).getNota();
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }

        // Retorna a constante semNota (-1)
        return Settings.semNota;
    }

    /**
     * Calcula e retorna a média das notas atribuidas
     * @return
     */
    public String notaMedia() {
        try {
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

            // Verifica se a soma das notas é diferente de 0, caso seja faz o cálculo
            if(somaNotas != 0) {
                // Calcula e retorna a média das notas atribuidas
                return String.valueOf(somaNotas / (this.inscricoes.size() - notasNaoAtribuidasCount));
            } else {
                // Retorna "NA" visto que não existem notas
                return Settings.semNotaString;
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");

            // Retorna "NA" caso ocorra algum erro
            return Settings.semNotaString;
        }
    }

    /**
     * Constroi uma lista com as 3 melhores notas da disciplina
     * @return
     */
    public ArrayList<Aluno> melhoresAlunos() {
        // Instância uma nova lista que irá conter os melhores alunos da disciplina
        ArrayList<Aluno> melhoresAlunos = new ArrayList<>();

        try {
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
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }

        // Retorna a lista de alunos
        return melhoresAlunos;
    }

    /**
     * Mostra todos os dados sobre a disciplina
     */
    public void dadosDisciplina() {
        try {
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
                    // Verifica se o aluno tem nota e escreve o valor correspondente
                    String nota = (inscricao.temNota()) ? String.valueOf(inscricao.getNota()) : Settings.semNotaString;

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
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Determina a Sigla da Disciplina a partir do seu nome
     * @param nomeDisciplina
     * @return
     */
    private static String determinarSigla(String nomeDisciplina) {
        switch (nomeDisciplina) {
            case "Programação Orientada a Objetos":
                return "POO";
            case "Bases de Dados":
                return "BD";
            case "Probabilidades e Processos Estocásticos":
                return "PPE";
            case "Teoria da Computação":
                return "TC";
            case "Tópicos de Matemática para Computação":
                return "TMC";
        }

        // retorna null caso a disciplina não exista
        return null;
    }

    /**
     * Auto inscreve os alunos do ficheiro na disciplina
     * @return
     */
    private static ArrayList<Inscricao> autoInscreverAlunos(){
        // Instância uma nova lista de inscrições que irá conter as inscrições da disciplina
        ArrayList<Inscricao> inscricoes = new ArrayList<>();

        try {
            // Instância uma lista de alunos a partir do ficheiro selecionado pelo utilizador
            ArrayList<Aluno> alunos = Aluno.lerAlunoFicheiro();

            // Percorre a lista de alunos
            for (Aluno aluno : alunos) {
                // Cria uma inscriçõa para cada aluno encontrado e adiciona-a à lista
                inscricoes.add(new Inscricao(Settings.semNota, aluno));
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");
        }

        // Retorna a lista de inscrições
        return inscricoes;
    }

    /**
     * Cria uma Disciplina com os alunos ja inscritos
     * @param nomeDisciplina
     * @param capacidade
     */
    public static Disciplina criarDisciplinaAutoInscricao(String nomeDisciplina, int capacidade) {
        try {
            // Cria e retorna a disciplina
            return new Disciplina(determinarSigla(nomeDisciplina), capacidade, autoInscreverAlunos());
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");

            // Retorna null visto que ocorreu um erro
            return null;
        }
    }

    /**
     * Determina a Nome da Disciplina a partir da sigla
     * @param siglaDisciplina
     * @return
     */
    private static String determinarNome(String siglaDisciplina) {
        switch (siglaDisciplina) {
            case "POO":
                return "Programação Orientada a Objetos";
            case "BDs":
                return "Bases de Dado";
            case "PPE":
                return "Probabilidades e Processos Estocásticos";
            case "TC":
                return "Teoria da Computação";
            case "TMC":
                return "Tópicos de Matemática para Computação";
        }

        // retorna null caso a disciplina não exista
        return null;
    }

    /**
     * Lê o ficheiro que o utilizador escolher e escreve o seu conteudo, neste caso os varios alunos, na lista alunos
     * @return
     */
    private static Disciplina lerDisciplinaFicheiro() {
        try {
            // Instância uma nova String que irá guardar a sigla da Disciplina
            String siglaDisciplina = "";

            // Insatância um novo int que irá guardar o valor da capacidade
            int capacidade = 0;

            // Instância o dialog que vai ser utilizado para escolher o ficheiro
            FileDialog dialog = new FileDialog((Frame)null, "Selecione o ficheiro da disciplina");

            // Define propriedades do dialog, neste caso o modo de load e a visibilidade
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);

            // Instância o ficheiro a partir da localização do ficheiro escolhido
            File file = new File(dialog.getDirectory() + dialog.getFile());

            // Dá "dispose" ao dialog, ou seja, exclui
            dialog.dispose();

            // Tenta ler o que está no ficheiro
            Scanner scanner = new Scanner(file);

            // Guarda o indice da linha
            int lineIndex = 0;

            // Lê as linhas do ficheiro enquanto existirem
            while(scanner.hasNextLine()) {
                // Guarda a linha do ficheiro numa String
                String line = scanner.nextLine();

                if(lineIndex == 0) {
                    siglaDisciplina = determinarSigla(line);
                } else if (lineIndex == 1) {
                    capacidade = Integer.parseInt(line);
                }

                // Avança no index da linha
                lineIndex++;
            }

            // Instância uma nova disciplina a partir dos dados obtidos do ficheiro
            Disciplina disciplina = new Disciplina(siglaDisciplina, capacidade);

            // Fecha o scanner que está a ler o ficheiro
            scanner.close();

            // Retorna a disciplina
            return disciplina;
        } catch (FileNotFoundException e) {
            System.err.println("Ficheiro nao encontrado!");

            // Return de null visto que houve exceção
            return null;
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");

            // Return de null visto que houve exceção
            return null;
        }
    }

    /**
     * Escreve a Disciplina num ficheiro
     * @param nomeFicheiro
     */
    public void escreverDisciplinaFicheiro(String nomeFicheiro) {
        try {
            // Cria o filePath para a pasta download a partir do nome do ficheiro
            File file = new File(System.getProperty("user.home") + "\\Downloads\\" + nomeFicheiro + ".txt");

            // Instância o PrintWritter para poder escrever no ficheiro
            PrintWriter writer = new PrintWriter(file);

            // Escreve o nome da Disciplina no ficheiro
            writer.println(determinarNome(this.sigla));

            // Escreve a Capacidade da Disciplina no ficheiro
            writer.println(this.capacidade);

            for(Inscricao inscricao : this.inscricoes) {
                // Verifica se o aluno tem nota e escreve o valor correspondente
                String nota = (inscricao.temNota()) ? String.valueOf(inscricao.getNota()) : Settings.semNotaString;

                // Escreve o número de aluno e a nota correspondente
                writer.println(inscricao.getAluno().getNumero() + " " + nota);
            }

            // Fecha o PrintWritter
            writer.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Problema ao escrever no ficheiro!");
        }
    }

    /**
     * Cria uma Disciplina com os alunos ja inscritos
     */
    public static Disciplina criarDisciplina2Ficheiros() {
        try {
            // Cria a disciplina
            Disciplina disciplina = lerDisciplinaFicheiro();

            // Preenche a lista de inscrições da disciplina
            disciplina.setInscricoes(autoInscreverAlunos());

            // Retorna a disciplina
            return disciplina;
        } catch (Exception e) {
            String errorMessage = e.getMessage();

            System.err.println("Ocorreu um erro!");

            // Retorna null visto que ocorreu um erro
            return null;
        }
    }

    //endregion
}