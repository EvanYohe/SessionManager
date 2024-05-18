package com.finalproject.command_handler;

import java.util.Scanner;

import com.finalproject.data_pipe.FileHandler;

public class Actions {

    // TODO
    // creates a session and adds to stored sessions
    public static void create(Command command, Scanner scanner) {

        System.out.println("Create a new session with the following arguments:");
        System.out.println("| Date | Time | Duration | Keyword(s) | Topic(s) |");
        System.out.println("Example: create 2021-12-31 12:00:00 01:00:00 Java OOP");
        CommandParser.parseArguments(command, scanner);
        System.out.println(command.getArguments());
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