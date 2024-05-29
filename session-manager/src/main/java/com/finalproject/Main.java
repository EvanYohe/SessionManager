package com.finalproject;

// Module based imports
import com.finalproject.command_handler.Command;
import com.finalproject.command_handler.CommandParser;
import com.finalproject.data_pipe.FileHandler;
import com.finalproject.output_formatter.OutputFormatter;

// Java based imports
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // main program loop
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Scanner fileReader = FileHandler.loadFile();
        OutputFormatter.banner();

        for (OutputFormatter.prompt(); userInput.hasNextLine(); OutputFormatter.prompt()) {
            
            ArrayList<String> argumentList = new ArrayList<>();
            Command command = new Command(userInput.nextLine().replaceAll("\n", " "), argumentList, false, false);

            while (command.isCommandProcessed() == false) {

                CommandParser.parseCommand(command, userInput, fileReader);

            }
        }
    }

}