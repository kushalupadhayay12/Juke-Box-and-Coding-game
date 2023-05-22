package com.crio.jukebox.appConfig;

import com.crio.jukebox.commands.AddSongCommand;
import com.crio.jukebox.commands.AddSongToPlaylistCommand;
import com.crio.jukebox.commands.CommandKeyword;
import com.crio.jukebox.commands.CommandRegistry;
import com.crio.jukebox.commands.CreateGreetingCommand;
import com.crio.jukebox.commands.CreatePlaylistCommand;
import com.crio.jukebox.commands.DeletePlaylistCommand;
import com.crio.jukebox.commands.DeleteSongFromPlaylistCommand;
import com.crio.jukebox.commands.GetGreetingCommand;
import com.crio.jukebox.commands.JukeboxCommandKeyword;
import com.crio.jukebox.commands.JukeboxCommandRegistry;
import com.crio.jukebox.commands.ListGreetingCommand;
import com.crio.jukebox.commands.ListSongsCommand;
import com.crio.jukebox.commands.LoadPlaylistCommand;
import com.crio.jukebox.commands.NextSongCommand;
import com.crio.jukebox.commands.PlaySongCommand;
import com.crio.jukebox.commands.PreviousSongCommand;
import com.crio.jukebox.commands.StopSongCommand;
import com.crio.jukebox.repositories.ArtistRepository;
import com.crio.jukebox.repositories.GreetingRepository;
import com.crio.jukebox.repositories.IArtistRepository;
import com.crio.jukebox.repositories.IGreetingRepository;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.PlaylistRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.services.GreetingService;
import com.crio.jukebox.services.PlayListService;
import com.crio.jukebox.services.SongService;

public class AppConfig {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static AppConfig instance = new AppConfig();

            //make the constructor private so that this class cannot be
            //instantiated
            private AppConfig(){}

            //Get the only object available
            public static AppConfig getInstance(){
                return instance;
            }

    		// Initialize repositories
            // private final IGreetingRepository greetingRepository = new GreetingRepository();
            
            private final IPlaylistRepository playlistRepository = new PlaylistRepository();

            private final ISongRepository songRepository = new SongRepository();

            private final IArtistRepository artistRepository = new ArtistRepository();

            //private final Player player = new Player();
            //private final PlaylistService playlistService = new PlaylistService();

            // private final PlayerState playerState = new Player();

            

            // Initialize services
            // private final GreetingService greetingService = new GreetingService(greetingRepository);

            private final PlayListService playlistService = new PlayListService(playlistRepository, songRepository);

            private final SongService songService = new SongService(songRepository);


            private final AddSongCommand addSongCommand = new AddSongCommand(songService);
            private final AddSongToPlaylistCommand addSongToPlaylistCommand = new AddSongToPlaylistCommand(playlistService);
            private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
            private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
            private final DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand = new DeleteSongFromPlaylistCommand(playlistService);
            private final ListSongsCommand listSongsCommand = new ListSongsCommand(songService);
            private final LoadPlaylistCommand LoadPlaylistCommand = new LoadPlaylistCommand(playlistService);
            private final NextSongCommand nextSongCommand = new NextSongCommand(playlistService);
            private final PlaySongCommand playSongCommand = new PlaySongCommand(playlistService);
            private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(playlistService);
            private final StopSongCommand stopSongCommand = new StopSongCommand(playlistService);

            // Initialize commands
            // private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            // private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            // private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);

            // Initialize commandRegistery
            // private final CommandRegistry commandRegistry = new CommandRegistry();

            private final JukeboxCommandRegistry jukeboxCommandRegistry = new JukeboxCommandRegistry();

            // Register commands 
            private void registerCommands(){
                // commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                // commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                // commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);

                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.ADD_SONG_COMMAND.getName(),addSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(),addSongToPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.CREATE_PLAYLIST_COMMAND.getName(),createPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.DELETE_PLAYLIST_COMMAND.getName(),deletePlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(),deleteSongFromPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.LIST_SONGS_COMMAND.getName(),listSongsCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.LOAD_PLAYLIST_COMMAND.getName(),LoadPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.PLAY_SONG_COMMAND.getName(),playSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.PREVIOUS_SONG_COMMAND.getName(),previousSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.NEXT_SONG_COMMAND.getName(),nextSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.STOP_SONG_COMMAND.getName(),stopSongCommand);
            }
            
            // public CommandRegistry getCommandRegistry(){
            //     registerCommands();
            //     return commandRegistry;
            // }

            public JukeboxCommandRegistry getJukeboxCommandRegistry(){
                registerCommands();
                return jukeboxCommandRegistry;
            }
}