package src.M4;

import src.M2.Aluno;

import java.io.File;

public class LineStudentReader extends LineObjectReader<Aluno>{
    //region Construtores

    public LineStudentReader(File file) {
        super(file);
    }

    //endregion

    //region Métodos

    //Não diz no enunciado qual é o formato do file, vou assumir que é separado por espaços
    @Override
    public Aluno lineToObject(String line) {
        // Divide a linha em varios items, para termos uma string com o numero e outra com o nome
        String[] parts = line.split(" ", 2);

        //O construtor do Aluno é {numero (int), nome (string)}
        return new Aluno(Integer.parseInt(parts[0]), parts[1]);
    }

    //endregion
}
