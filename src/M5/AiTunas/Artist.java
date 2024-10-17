package src.M5.AiTunas;

import java.util.List;

public class Artist {
    //region Atributos

    private String name;
    private List<Album> albums;

    //endregion

    //region Construtores

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    //endregion

    //region Getters

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    //region Métodos


    @Override
    public String toString() {
        return "\nArtist{" +
                "name='" + name + '\'' +
                '}';
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    //endregion

    //endregion
}
