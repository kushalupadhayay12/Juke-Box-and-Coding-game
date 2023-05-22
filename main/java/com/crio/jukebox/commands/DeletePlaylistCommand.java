package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.PlayListService;

public class DeletePlaylistCommand implements ICommand {

    private final PlayListService playlistService;
    
    public DeletePlaylistCommand(PlayListService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        String deletePlaylist = playlistService.deletePlaylist(playlistName);
        System.out.println(deletePlaylist);
    }
    
}