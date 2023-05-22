package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.PlayListService;

public class LoadPlaylistCommand implements ICommand {

    private final PlayListService playlistService; 

    public LoadPlaylistCommand(PlayListService playlistService) {
        this.playlistService = playlistService;
    }
    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        System.out.println(playlistService.loadPlaylist(playlistName));
    }
    
}
