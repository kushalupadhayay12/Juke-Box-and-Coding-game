package com.crio.jukebox.stateOfSongs;

public interface PlayerState {
    public void play();
    public void stop();
    public void next();
    public void previous();
}
