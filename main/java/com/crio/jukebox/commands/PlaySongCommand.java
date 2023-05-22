package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.PlayListService;

public class PlaySongCommand implements ICommand{

    private final PlayListService playlistService;

    public PlaySongCommand(PlayListService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.playSong();
    }
    
}
