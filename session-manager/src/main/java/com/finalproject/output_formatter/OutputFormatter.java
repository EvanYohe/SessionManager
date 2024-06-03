package com.finalproject.output_formatter;

public class OutputFormatter {

    // TODO: Implement the printSingleSession method
    // format and print a single session
    public static void printSingleSession(){

    };

    // TODO: Implement the formatList method
    // format and print a list of sessions
    public static void printSessionList(){

    };

    // displays the help menu
    public static void help() {

        String[][] tableData = {

                { "create", "Create a new session", "Date Time Duration Keyword(s) Topic(s)" },
                { "delete", "Delete a session by ID", "sessionID" },
                { "list", "Display a list sessions", "Range/Keyword will be prompted for filtering." },
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

    // I wanted a banner
    public static void banner() {

        System.out.println("  ___            _          __  __                             ");
        System.out.println(" / __| ___ _____(_)___ _ _ |  \\/  |__ _ _ _  __ _ __ _ ___ _ _ ");
        System.out.println(" \\__ \\/ -_|_-<_-< / _ \\ ' \\| |\\/| / _` | ' \\/ _` / _` / -_) '_|");
        System.out.println(" |___/\\___/__/__/_\\___/_||_|_|  |_\\__,_|_||_\\__,_\\__, \\___|_|  ");
        System.out.println("                                                 |___/         ");
        System.out.println("You can type 'help' for a list of commands or 'exit' to quit.");
        System.out.println("Otherwise, enter a command:");
    }

    // simple prompt for the program
    public static void prompt() {

        System.out.print("session-manager> ");
    }
}
