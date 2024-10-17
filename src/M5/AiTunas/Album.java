package src.M5.AiTunas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Album {
    //region Atributos

    private String name;
    private int year;
    private List<Artist> artists;
    private List<Song> songs;

    //endregion

    //region Construtores

    public Album(String name, int year, List<Artist> artists, List<Song> songs) {
        this.name = name;
        this.year = year;
        this.artists = artists;
        this.songs = songs;
    }

    //endregion

    //region Getters and Setters

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    //endregion

    //region Métodos

    public static Album load(File file, AiTunas aiTunas) throws FileNotFoundException {
        if (file.isFile()) {
            Scanner sc = new Scanner(file);

            // Guarda o indice da linha
            int lineIndex = 0;

            int songIndex = 1;

            Album album = new Album("", 0, new ArrayList<>(), new ArrayList<>());

            boolean isSongs = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                switch (lineIndex) {
                    case 0:
                        album.name = line;
                        lineIndex++;
                    break;
                    case 1:
                        album.year = Integer.valueOf(line);
                        lineIndex++;
                    break;
                    default:
                        if (line.equals("")) {
                            isSongs = true;
                        }

                        if(isSongs && !line.equals("")) {
                            String[] lineArr = line.split(" ", 2);
                            album.songs.add(album.new Song(lineArr[1], new Time(lineArr[0]), songIndex));

                            songIndex++;
                        } else {
                            if(!line.equals("")) {
                                if(aiTunas.hasArtist(line)) {
                                    Artist artist = aiTunas.findArtist(line);
                                    album.artists.add(artist);
                                    artist.addAlbum(album);
                                } else {
                                    List<Album> albumList = new ArrayList<>();
                                    albumList.add(album);

                                    Artist artist = new Artist(line, albumList);

                                    album.artists.add(artist);
                                    aiTunas.addArtist(artist);
                                }
                            }
                        }

                        lineIndex++;

                    break;
                }
            }

            return album;
        } else {
            throw new FileNotFoundException("File does not exist");
        }
    }

    public void orderSongsByTrack() {
        songs.sort((song1, song2) -> {
            if (song1.trackNumber > song2.trackNumber) {
                return 1;
            }

            return -1;
        });
    }

    public void orderSongsByDuration() {
        songs.sort((song1, song2) -> {
            if (song1.duration.getTotalSeconds() > song2.duration.getTotalSeconds()) {
                return 1;
            } else if (song1.duration.getTotalSeconds() < song2.duration.getTotalSeconds()) {
                return -1;
            }

            return 0;
        });
    }

    public void orderSongsAlphabetic() {
        songs.sort((song1, song2) -> String.CASE_INSENSITIVE_ORDER.compare(song1.name, song2.name));
    }

    public int getDuration() {
        Time totalTime = new Time(0,0);

        for(Song song : songs) {
            totalTime = totalTime.add(song.duration);
        }

        return totalTime.getTotalSeconds();
    }

    @Override
    public String toString() {
        return "\nAlbum{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", artists=" + artists +
                ", songs=" + songs +
                '}';
    }

    public List<Artist> findArtistsBySong(Song song) {
        for(Song song1 : songs) {
            if (song1.name.equals(song.getName())) {
                return artists;
            }
        }

        return null;
    }

    //endregion

    //region Classe Song

    public class Song {
        //region Atributos

        private String name;
        private Time duration;
        private int trackNumber;

        //endregion

        //region Construtores

        public Song(String name, Time duration, int trackNumber) {
            this.name = name;
            this.duration = duration;
            this.trackNumber = trackNumber;
        }

        //endregion

        //region Getters and Setters

        public String getName() {
            return name;
        }

        public Time getDuration() {
            return duration;
        }

        public int getTrackNumber() {
            return trackNumber;
        }


        //endregion

        //region Métodos

        @Override
        public String toString() {
            return "Song{" +
                    "name='" + name + '\'' +
                    ", duration=" + duration +
                    ", trackNumber=" + trackNumber +
                    '}';
        }


        //endregion
    }

    //endregion
}
