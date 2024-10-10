package src.M4;

import java.io.File;

public class LineCircleReader extends LineObjectReader<Circle>{
    //region Construtores

    public LineCircleReader(File file) {
        super(file);
    }

    //endregion

    //region Métodos

    //Não diz no enunciado qual é o formato do file, vou assumir que é separado por espaços
    @Override
    public Circle lineToObject(String line) {
        // Transforma a linha num array de strings de limite 3 (x, y, z)
        String[] parts = line.split(" ", 3);

        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int r = Integer.parseInt(parts[2]);

            //O construtor do Circulo é {x (int), y (string), radius (int)}
            return new Circle(x,y,r);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    //endregion
}
