package com.finalproject;

// Module based imports
import com.finalproject.command_handler.Command;
import com.finalproject.command_handler.CommandParser;

// Java based imports
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        banner();
        
        for(prompt(); scanner.hasNextLine(); prompt()){

            ArrayList<String> argumentList = new ArrayList<>();
            Command command = new Command(scanner.nextLine().replaceAll("\n", " "),argumentList, false, false);
            CommandParser commandParser = new CommandParser(command);
            
            while(command.isCommandProcessed() == false){
                
                commandParser.parse(command, scanner);
                
            }
        }
    }

    // FINISHED
    public static void banner(){

        // I wanted a banner
        System.out.println("  ___            _          __  __                             ");
        System.out.println(" / __| ___ _____(_)___ _ _ |  \\/  |__ _ _ _  __ _ __ _ ___ _ _ ");
        System.out.println(" \\__ \\/ -_|_-<_-< / _ \\ ' \\| |\\/| / _` | ' \\/ _` / _` / -_) '_|");
        System.out.println(" |___/\\___/__/__/_\\___/_||_|_|  |_\\__,_|_||_\\__,_\\__, \\___|_|  ");
        System.out.println("                                                 |___/         ");
        System.out.println("You can type 'help' for a list of commands or 'exit' to quit.");
        System.out.println("Otherwise, enter a command:");

    }

    // FINISHED
    public static void prompt(){

        System.out.print("session-manager> ");
    }
}