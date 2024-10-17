package src.M5;

import src.M5.AiTunas.AiTunas;
import src.M5.AiTunas.Album;
import src.M5.AiTunas.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainM5 {
    public static void main(String[] args) {
        //region 5.1
        System.out.println("5.1\n");

        Matrix m1 = new Matrix(5);
        Matrix m2 = new Matrix(5);

        //System.out.println("M1. Linhas: " + m1.getLinhas() + " Colunas: " + m1.getColunas() + "\n" + m1);
        //System.out.println("M2. Linhas: " + m2.getLinhas() + " Colunas: " + m2.getColunas() + "\n" + m2);

        // Preenche com valores aleatorios as 2 matrizes, em que o nº max é 5
        m1.randomize(5);
        m2.randomize(5);
        System.out.println(m1);
        System.out.println(m2);

        // Faz e imprime a soma das matrizes e aplica o respetivo escalar
        System.out.println(sumAndScale(m1,m2,2));

        //endregion

        //region 5.2
        System.out.println("\n5.1\n");

        Time time1 = new Time(25, 40);
        Time time2 = new Time("50:40");
        Time time3 = new Time(10, 5);
        Time time4 = new Time(5, 5);

        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);

        Time timeSoma = time1.add(time3);
        Time timeSub = time3.sub(time4);

        System.out.println("TimeSoma: " + timeSoma);
        System.out.println("TimeSub: " + timeSub);

        System.out.println("Is Greater than: " + time3.isGreaterThan(time4));
        System.out.println("Is Less than: " + time3.isLessThan(time4));
        System.out.println("Total Seconds: " + time3.getTotalSeconds());

        //endregion

        //region 5.3
        System.out.println("\n5.3\n");

        ArrayList<Aluno> alunos = new ArrayList<>();

        Aluno a1 = new Aluno(1, "Ana", 2020, 1990);
        Aluno a2 = new Aluno(10, "João", 2020, 1990);
        Aluno a3 = new Aluno(230, "Nuno", 2030, 2003);
        Aluno a4 = new Aluno(120, "Daniel", 2025, 1995);
        Aluno a5 = new Aluno(15, "Jorge", 2031, 2003);
        Aluno a6 = new Aluno(800, "Pedro", 2024, 1995);
        Aluno a7 = new Aluno(10, "Zaza", 2023, 1995);
        Aluno a8 = new Aluno(1000, "Xispo", 2020, 1990);

        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);
        alunos.add(a6);
        alunos.add(a7);
        alunos.add(a8);

        System.out.println("\n Lista Desordenada:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        alunos.sort((aluno1, aluno2) -> {
            // Verifica se o numero do primeiro aluno é maior do que o do segundo
            if (aluno1.getNumero() > aluno2.getNumero()) {
                // Retorna 1 caso o a1 seja maior que o a2
                return 1;
            } else if (aluno1.getNumero() < aluno2.getNumero()) {
                // Retorna -1 caso o a2 seja maior que o a1
                return -1;
            }

            // Retorna 0 caso sejam iguais
            return 0;
        });

        System.out.println("\nLista Ordenada por Número:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        alunos.sort((aluno1, aluno2) -> {
            // Compara os nomes dos dois alunos
            return String.CASE_INSENSITIVE_ORDER.compare(aluno1.getNome(), aluno2.getNome());
        });

        System.out.println("\nLista Ordenada por Nome:");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        //endregion

        //region 5.4
        System.out.println("\n5.4\n");

        List<String> strings = new ArrayList<>();
        strings.add("Ana");
        strings.add("Jorge");
        strings.add("Nuno");
        strings.add("Armando");
        strings.add("Daniel");
        strings.add("Pedro");
        strings.add("Zaza");
        strings.add("Xispo");

        System.out.println("\nDesornada:");
        for(String palavra : strings) {
            System.out.println(palavra);
        }

        List<String> stringsFiltradas = Filter.filterWords(strings, (elemento -> {
            // Verifica se o elemento começa com o prefixo "A" e retorna o resultado
            return elemento.toString().startsWith("A");
        }));

        System.out.println("\nFiltrada Prefixo:");
        for(String palavra : stringsFiltradas) {
            System.out.println(palavra);
        }

        List<String> strings2 = new ArrayList<>();
        strings.add("Ana");
        strings.add("Jorge");
        strings.add("Nuno");
        strings.add("Armando");
        strings.add("Daniel");
        strings.add("Pedro");
        strings.add("Zaza");
        strings.add("Za");
        strings.add("B");
        strings.add("Xispo");

        List<String> stringsFiltradas2 = Filter.filterWords(strings, (elemento -> {
            // Verifica se o elemento tem menos de 3 caracteres e retorna o resultado
            return elemento.toString().length() < 3;
        }));

        System.out.println("\nFiltrada menor que 3:");
        for(String palavra : stringsFiltradas2) {
            System.out.println(palavra);
        }

        //endregion

        //region 5.5

        System.out.println("\n5.5\n");

        /*try {
            Album album = Album.load(new File("albums/album.txt"));

            System.out.println(album);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //endregion

        //region 5.6

        System.out.println("\n5.6\n");

        AiTunas aiTunas = AiTunas.load(new File("albums"));

        aiTunas.sortAlbumsByYear();
        aiTunas.sortAlbumsByYear();

        for(Album album : aiTunas.getAllAlbuns()) {
            album.orderSongsByTrack();
        }

        System.out.println(aiTunas);

        //endregion
    }

    static Matrix sumAndScale(Matrix a, Matrix b, int scalar) {
        if (!a.isSameSize(b)) {
            throw new IllegalArgumentException("Não se pode somar estas matrizes");
        }

        Matrix result = new Matrix(a.getLinhas(),a.getColunas());

        for (int i = 0; i < a.getLinhas(); i++) {
            for (int j = 0; j < a.getColunas(); j++) {
                int sum = a.getNumber(i,j) + b.getNumber(i,j);

                result.setNumber(i,j,sum * scalar);
            }
        }

        return result;
    }
}