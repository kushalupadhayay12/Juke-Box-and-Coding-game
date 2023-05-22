package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.PlayListService;

public class AddSongToPlaylistCommand implements ICommand {

    private final PlayListService playlistService;
    
    public AddSongToPlaylistCommand(PlayListService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        String addSongToPlaylist = playlistService.addSongToPlaylist(playlistName, songId);
        System.out.println(addSongToPlaylist);
    }
    
}
