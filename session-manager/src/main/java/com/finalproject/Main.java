package com.finalproject;

import com.finalproject.command_handler.Command;
import com.finalproject.command_handler.CommandParser;
import com.finalproject.data_pipe.ReadWriteData;
import com.finalproject.output_formatter.OutputFormatter;
import com.finalproject.session_manager.SessionListBuilder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {

            // read the session list from the file
            Global.sessionList = ReadWriteData.readJsonArray();
        } catch (Exception e) {
            // The exception needs to be caught but no message needs to be shown to the user
            // If the file is empty, it means the user is running the program for the first time
            // or they have no stored sessions
        }

        // on init, make sure the list is sorted by date
        SessionListBuilder.sortSessionList();

        OutputFormatter.banner();

        // main program loop
        for (OutputFormatter.prompt(); Global.userInput.hasNextLine(); OutputFormatter.prompt()) { 

            ArrayList<String> argumentList = new ArrayList<>();
            
            // build the command object
            Command command = new Command( 
                    Global.userInput.nextLine().replaceAll("\n", " "),
                    argumentList,
                    false,
                    false
                    );

            // keeps the loop running until finished processing the command
            while (command.isCommandProcessed() == false) { 
                
                CommandParser.parseCommand(command);
            }

            // after command is processed, prompt for a new command
            System.out.println(); 
            System.out.println("Command processed. Enter a new command or type 'exit' to quit.");
        }
    }
}