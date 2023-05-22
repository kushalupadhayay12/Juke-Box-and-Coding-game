package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.PlayListService;

public class CreatePlaylistCommand implements ICommand {
    private final PlayListService playlistService;

    public CreatePlaylistCommand(PlayListService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        List<Long> ids = new ArrayList<>();
        int n = tokens.size(); 
        for(int i = 2; i < n; i++) {
            ids.add(Long.parseLong(tokens.get(i)));
        }
        Playlist createPlaylist = playlistService.createPlaylist(playlistName, ids);
        System.out.println(createPlaylist);
        // System.out.println();

    }
}
