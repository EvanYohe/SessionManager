package com.finalproject.command_handler;

public class Actions {

    // TODO
    // creates a session and adds to stored sessions
    public static void create(Command command) {

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
    // displays the help menu
    public static void help() {

        String[][] tableData = {

            { "create", "Create a new session", "Date Time Duration Keyword(s) Topic(s)" },
            { "delete", "Delete a session by ID", "sessionID" },
            { "list", "Display a list sessions", "Range/Keyword/Topic will be prompted for filtering." },
            { "edit", "Edit a session by ID", "sessionID" },
            { "help", "Display this help message", "" },
            { "exit", "Exit the program", "" }
        };

        String format = "| %-8s | %-26s | %-51s |%n";

        System.out.format(
                "+----------+----------------------------+-----------------------------------------------------|%n");

        System.out.format(
                "| Command  | Description                | Argument(s)                                         |%n");

        System.out.format(
                "+----------+----------------------------+-----------------------------------------------------|%n");

        for (int i = 0; i < 6; i++) {

            System.out.format(format, tableData[i][0], tableData[i][1], tableData[i][2]);
        }

        System.out.format(
                "+----------+----------------------------+-----------------------------------------------------|%n");
    }

    // FINISHED
    // exits the program
    public static void exit() {

        System.out.println("Exiting...");
        System.exit(0);
    }
}