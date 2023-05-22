package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.PlayListService;

public class NextSongCommand implements ICommand {

    private final PlayListService playlistService;

    public NextSongCommand(PlayListService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.nextSong();
    }
    
}
