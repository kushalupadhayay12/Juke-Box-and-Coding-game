package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.SongService;

public class AddSongCommand implements ICommand {

    private final SongService songService;

    public AddSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String Song_1 = tokens.get(1);
        String Artist_1 = tokens.get(2);
        String Album_1 = tokens.get(3);
        String Genre_1 = tokens.get(4);
        Song song = songService.addSong(Song_1, Artist_1, Album_1, Genre_1);
        System.out.println(song);
    }
    
}
