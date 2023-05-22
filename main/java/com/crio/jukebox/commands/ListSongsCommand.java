package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.SongService;

public class ListSongsCommand implements ICommand {
    private final SongService songService;

    public ListSongsCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Song> songs = songService.listSongs();

        String result="[";

        for (int i=0;i<songs.size();i++) {
            if(i==songs.size()-1)
                result+=songs.get(i).toString();
            else
                result+=songs.get(i).toString() + ", ";
        }
        
        result += "]";
      
        System.out.println(result);

    }
}
