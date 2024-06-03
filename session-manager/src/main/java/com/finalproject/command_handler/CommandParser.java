package com.finalproject.command_handler;

import com.finalproject.Global;
import com.finalproject.output_formatter.OutputFormatter;

public class CommandParser {

    public static void parseCommand(Command command) {

        // switch case will determine if the command is valid, prompting re-entry if not
        // all commands call their respective action methods then set the commandProcessed flag to true
        // setting the flag to true will break the while loop in the main method
        switch (command.getCommand()) {
            case "create":

                Actions.create(command);
                command.setCommandProcessed(true);
            break;
            case "delete":

                Actions.delete(command);
                command.setCommandProcessed(true);
            break;
            case "list":

                Actions.list(command);
                command.setCommandProcessed(true);
            break;
            case "edit":

                Actions.edit(command);
                command.setCommandProcessed(true);
            break;
            case "help":

                OutputFormatter.help();
                command.setCommandProcessed(true);
            break;
            case "exit":

                Actions.exit();
            break;
            default:

                System.out.println("Invalid command. Enter 'help' for a list of commands");
                command.setCommandProcessed(true);
            break;
        }
    }

    // TODO: Implement the parseArguments method, work in progress
    public static void parseArguments(Command command) {

        // no default case is needed, will only be called if the command is valid
        // each case will prompt the user for the necessary arguments then parse the arguments to the command object
        switch (command.getCommand()) {
            case "create":

                String[] prompts = {
                        "Enter the date of the session (yyyy-MM-dd):",
                        "Enter the time of the session (HH:mm):",
                        "Enter the duration of the session (HH:mm):",
                        "Enter the keyword(s) for the session (separated by spaces):"
                };
                for (int i = 0; i < 4; i++) {
                    System.out.println(prompts[i]);
                    OutputFormatter.prompt();
                    command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                }
                command.setArgumentsProcessed(true);
            break;
            case "delete":

                System.out.println("Enter the sessionID you want to delete (session-yyyy-MM-dd):");
                OutputFormatter.prompt();
                command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                command.setArgumentsProcessed(true);
            break;
            case "list":

                System.out.println("To list all sessions, enter 'all'");
                System.out.println("To list a single session, enter the sessionID (Session-yyyy-MM-dd)");
                System.out.println(
                        "To list sessions by keyword or date range, enter (yyyd-MM-dd yyyy-MM-dd) to filter your search:");
                OutputFormatter.prompt();
                command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                command.setArgumentsProcessed(true);
            break;
            case "edit":

                System.out.println("Enter the sessionID you want to edit (session-yyyy-MM-dd):");
                OutputFormatter.prompt();
                command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                command.setArgumentsProcessed(true);
            break;
            case "exit":
            
                command.setArgumentsProcessed(true);
            break;
        }
    }
}