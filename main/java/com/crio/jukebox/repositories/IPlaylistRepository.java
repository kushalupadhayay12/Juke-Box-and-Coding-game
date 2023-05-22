package com.crio.jukebox.repositories;

import java.util.List;
import java.util.Optional;
import com.crio.jukebox.entities.Playlist;

public interface IPlaylistRepository{
    Playlist save(Playlist playlist);
    boolean existsById(Long id);
    Optional<Playlist> findById(Long id);
    List<Playlist> findAll();
    void deleteById(Long id);
    long count();
}