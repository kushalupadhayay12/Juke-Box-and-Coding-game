package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class SongService {
    private final ISongRepository songRepository;
    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }
    public Song addSong(String songName, String artist, String album, String genre) {
        Song song = new Song(songName, album, genre, artist);
        return songRepository.save(song);
    }
    public List<Song> listSongs() {
        return songRepository.findAll();
    }
}
