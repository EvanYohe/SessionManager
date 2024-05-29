package com.finalproject.command_handler;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.finalproject.data_pipe.FileHandler;
import com.finalproject.session_manager.Session;

public class Actions {

    // WIP
    // creates a session and adds to stored sessions
    public static void create(Command command, Scanner userInput, Scanner fileReader) {

        System.out.println("Create a new session with the following arguments:");
        System.out.println("| Date | Time | Duration | Keyword(s) | Topic(s) |");
        System.out.println("Example: create 2021-12-31 12:00:00 01:00:00 Java OOP");
        CommandParser.parseArguments(command, userInput);
        System.out.println(command.getArguments());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Date sessionDate = dateFormatter.parse(command.getArguments().get(0));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }

        // String sessionID = "Session" + command.getArguments().get(0);
        // Session session = new Session(command.getArguments().get(0), command.getArguments().get(1), command.getArguments().get(2), command.getArguments().get(3), command.getArguments().get(4), sessionID);}

    }
    // TODO
    // deletes a session by ID from stored sessions
    public static void delete(Command command) {

    }

    // TODO
    // lists all sessions
    public static void list() {

    }

    // TODO
    // edits a sessions by sessions ID
    public static void edit() {

    }

    // FINISHED
    // exits the program
    public static void exit() {

        if (FileHandler.isFileUnloaded() == false) {

            FileHandler.unloadFile();
        }
        
        System.out.println("Exiting...");
        System.exit(0);
    }
}