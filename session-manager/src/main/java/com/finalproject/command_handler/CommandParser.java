package com.finalproject.command_handler;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CommandParser{

    private Command command;

    public CommandParser(Command command) {
    
        this.command = command;
    }

    // WIP
    public void parse(Command command, Scanner scanner){
        
        switch(command.getCommand()){

            case "create":
                System.out.println("Create a new session with the following arguments:");
                System.out.println("| Date | Time | Duration | Keyword(s) | Topic(s) |");
                System.out.println("Example: create 2021-12-31 12:00:00 01:00:00 Java OOP");
                parseArguments(command, scanner);
                create(command);
                command.setCommandProcessed(true); 
            break;

            case "delete":
                parseArguments(command, scanner);
                delete(command);
                command.setCommandProcessed(true);
            break;

            case "list":
                System.out.println("Listing sessions...");
            break;

            case "edit":
                System.out.println("Editing session...");
            break;

            case "help":
                help();
                command.setCommandProcessed(true);
            break;

            case "exit":
                System.out.println("Exiting...");
                System.exit(0);
            break;

            default:
                System.out.println("Invalid command.");
            break;
        }
    }

    // WIP
    public void parseArguments(Command command, Scanner scanner){

        System.out.println("Enter command argument(s) separated by spaces:");
        prompt();

        String arguments = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(arguments);

        while(tokenizer.hasMoreTokens()){

            command.getArguments().add(tokenizer.nextToken());

        }

        if(tokenizer.countTokens() == 0){
            
            command.setArgumentsProcessed(true);
        }
    }

    // TODO
    public void create(Command command){
    
        
    }

    // TODO
    public void delete(Command command){
    
        
    }

    // FINISHED
    // Displays the help menu
    public void help(){

        String[][] tableData = {
            {"create", "Create a new session", "Date Time Duration Keyword(s) Topic(s)"},
            {"list", "List all sessions", "Range/Keyword/Topic will be prompted for filtering."},
            {"delete", "Delete a session by ID.", "sessionID"},
            {"edit", "Edit a session by ID.", "sessionID"},
            {"help", "Display this help message.", ""},
            {"exit", "Exit the program.", ""}
        };
        String format = "| %-8s | %-26s | %-51s |%n";
        System.out.format("+----------+----------------------------+-----------------------------------------------------|%n");
        System.out.format("| Command  | Description                | Argument(s)                                         |%n");
        System.out.format("+----------+----------------------------+-----------------------------------------------------|%n");
        
        for(int i = 0; i < 6; i++){
                
                System.out.format(format, tableData[i][0], tableData[i][1], tableData[i][2]);
        }
        System.out.format("+----------+----------------------------+-----------------------------------------------------|%n");
    }

    // FINISHED
    public static void prompt(){

        System.out.print("session-manager> ");
    }
}
