package src.M5.AiTunas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AiTunas {
    //region Atributos

    List<Artist> artistList;
    List<Album> albumList;

    //endregion

    //region Construtores

    public AiTunas(List<Artist> artistList, List<Album> albumList) {
        this.artistList = artistList;
        this.albumList = albumList;
    }

    //endregion

    //region Getters

    public List<Artist> getAllArtists() {
        return artistList;
    }

    public List<Album> getAllAlbuns() {
        return albumList;
    }

    //endregion

    //region Métodos


    @Override
    public String toString() {
        return "AiTunas{" +
                "\nartistList=" + artistList +
                ", \nalbumList=" + albumList +
                '}';
    }

    /**
     * Coleta os ficheiros de cada pasta recursivamente
     * @param dir
     * @param aiTunas
     */
    private static void collectFilesRec(File dir, AiTunas aiTunas) {
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
                        collectFilesRec(file, aiTunas);
                    } else {
                        // Adiciona o ficheiro à lista de ficheiros
                        aiTunas.albumList.add(Album.load(file, aiTunas));
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
    public static AiTunas load(File dir) {
        AiTunas aiTunas = new AiTunas(new ArrayList<>(), new ArrayList<>());

        try {
            collectFilesRec(dir, aiTunas);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro!");
        }

        return aiTunas;
    }

    public void addArtist(Artist artist) {
        artistList.add(artist);
    }

    public Artist findArtist(String artistName) {
        for(Artist artist : artistList) {
            if(artist.getName().equals(artistName)) {
                return artist;
            }
        }

        return null;
    }

    public boolean hasArtist(String artistName) {
        for(Artist artist : artistList) {
            if(artist.getName().equals(artistName)) {
                return true;
            }
        }

        return false;
    }

    public void sortAlbumsByYear() {
        albumList.sort((album1, album2) -> {
            if (album1.getYear() > album2.getYear()) {
                return 1;
            } else if (album1.getYear() < album2.getYear()) {
                return -1;
            }

            return 0;
        });
    }

    public void sortArtistsByName() {
        artistList.sort((artist1, artist2) -> String.CASE_INSENSITIVE_ORDER.compare(artist1.getName(), artist2.getName()));
    }

    //endregion
}
