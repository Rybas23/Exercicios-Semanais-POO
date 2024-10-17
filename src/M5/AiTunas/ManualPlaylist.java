package src.M5.AiTunas;

import java.util.ArrayList;
import java.util.List;

public class ManualPlaylist implements Playlist {
    //region Atributos

    private List<Album.Song> songs;
    private String name;

    //endregion

    //region Construtores

    public ManualPlaylist(String name, List<Album.Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    //endregion

    //region Metodos

    public void addSong(Album.Song song) {
        this.songs.add(song);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Time getDuration() {
        Time totalTime = new Time(0,0);

        for(Album.Song song : songs) {
            totalTime = totalTime.add(song.getDuration());
        }

        return totalTime;
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();

        for(Album.Song song : songs) {
            // TO DO
        }

        return artists;
    }

    @Override
    public List<Album.Song> getSongs() {
        return songs;
    }

    //endregion
}
