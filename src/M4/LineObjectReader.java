package src.M4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class LineObjectReader<T> {

    //region Atributos

    private File file;

    //endregion

    //region Construtores

    public LineObjectReader(File file) {
        this.file = file;
    }

    //endregion

    //region Métodos

    // Cria o leitor e depois adiciona um objeto à lista por cada linha do ficheiro, devolve a lista
    public List<T> read() {
        List<T> list = new ArrayList<>();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                list.add(lineToObject(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        }
        return list;
    }

    @Override
    public String toString() {
        return "LineObjectReader{" +
                "file=" + file +
                '}';
    }

    public abstract T lineToObject(String line);

    //endregion
}
