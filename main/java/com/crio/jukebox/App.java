package com.crio.jukebox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.codingame.appConfig.ApplicationConfig;
import com.crio.jukebox.appConfig.AppConfig;
import com.crio.jukebox.commands.JukeboxCommandRegistry;


public class App {
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
	public static void main(String[] args) {
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        String expectedSequence = "INPUT-FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining("$"));
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
	}

    public static void run(List<String> commandLineArgs) {
    
        AppConfig conf = AppConfig.getInstance();

        // CommandRegistry commandRegistry = conf.getCommandRegistry();

        JukeboxCommandRegistry jukeboxCommandRegistry = conf.getJukeboxCommandRegistry();
        
        String inputFile = commandLineArgs.get(0).split("=")[1];

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                // commandRegistry.invokeCommand(line);
                jukeboxCommandRegistry.invokeCommand(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
