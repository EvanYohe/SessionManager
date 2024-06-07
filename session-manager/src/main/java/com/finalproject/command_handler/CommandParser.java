package com.finalproject.command_handler;

import com.finalproject.Global;
import com.finalproject.output_formatter.OutputFormatter;
import com.finalproject.session_manager.Session;

public class CommandParser {

    public static void parseCommand(Command command) {
        
        // switch case will determine if the command is valid, or break back to 
        // the main program loop in the main method
        // all commands call their respective action methods then set the
        // commandProcessed flag to true after the action is complete
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

    // no default case is needed, will only be called if the command is valid
    // each case will prompt the user for the necessary arguments then parse the
    // arguments to the command object
    public static void parseArguments(Command command) {

        switch (command.getCommand()) {
            case "create":

                String[] argPrompts = {
                        "Enter the date of the session (yyyy-MM-dd)",
                        "Enter the time of the session (HH:mm in 24-hour format)",
                        "Enter the duration of the session (HH:mm)",
                        "Enter the keyword(s) for the session (separated by spaces)"
                };

                for (int i = 0; i < 4; i++) {

                    System.out.println(argPrompts[i]);
                    OutputFormatter.prompt();
                    String arg = Global.userInput.nextLine().trim().toLowerCase();

                    if (arg.equals("exit")) {

                        command.getArguments().add(arg);
                        return;
                    }

                    if (!validateCreateArguments(arg, i)) {

                        i--;
                        continue;
                    }

                    command.getArguments().add(arg);
                }

                command.setArgumentsProcessed(true);
                break;
            case "delete":

                System.out.println("Enter the sessionID you want to delete (session-yyyy-MM-dd)");
                OutputFormatter.prompt();
                command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                command.setArgumentsProcessed(true);
                break;
            case "list":

                System.out.println("To list all sessions, enter 'all'");
                System.out.println("To list a single session, enter 'sessionID'");
                System.out.println("To list sessions by keyword, enter 'keyword'");
                System.out.println("To list sessions by date range, enter 'date range'");
                OutputFormatter.prompt();
                command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                command.setArgumentsProcessed(true);
                break;
            case "edit":

                System.out.println("Enter the sessionID you want to edit (session-yyyy-MM-dd)");
                OutputFormatter.prompt();
                command.getArguments().add(Global.userInput.nextLine().trim().toLowerCase());
                command.setArgumentsProcessed(true);
                break;
        }
    }

    // these are all validation methods for the arguments of the create, list, edit,
    // and delete commands. Each method will return false if the argument is invalid,
    // prompting the user to re-enter the argument
    // the methods use string regex to check if the format of the command entered is
    // correct to the format of the argument expected
    private static boolean validateCreateArguments(String arg, int i) {

        String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
        String timeFormat = "\\d{2}:\\d{2}";

        switch (i) {
            case 0:
                if (!arg.matches(dateFormat)) {

                    System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format");
                    return false;
                }
                break;
            case 1:
                if (!arg.matches(timeFormat)) {

                    System.out.println("Invalid time format. Please enter the time in 24-hour HH:mm format");
                    return false;
                }
                break;
            case 2:
                if (!arg.matches(timeFormat)) {

                    System.out.println("Invalid duration format. Please enter the duration in HH:mm format");
                    return false;
                }
                break;
            case 3:
                if (arg.contains(",")) {

                    System.out.println("Invalid keyword format. Keywords cannot be delimited by commas");
                    return false;
                }
                break;
        }
        return true;
    }

    public static boolean validateDateRange(String arg) {

        String dateRangeFormat = "\\d{4}-\\d{2}-\\d{2} \\d{4}-\\d{2}-\\d{2}";

        if (!arg.matches(dateRangeFormat)) {

            System.out
                    .println("Invalid date range format. Please enter the date range in yyyy-MM-dd yyyy-MM-dd format");
            return false;
        }
        return true;
    }

    public static boolean validateDate(String arg) {

        String dateFormat = "\\d{4}-\\d{2}-\\d{2}";

        if (!arg.matches(dateFormat)) {

            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format");
            return false;
        }
        return true;
    }

    public static boolean validateTime (String arg) {

        String timeFormat = "\\d{2}:\\d{2}";

        if (!arg.matches(timeFormat)) {

            System.out.println("Invalid time format. Please enter the time in 24-hour HH:mm format");
            return false;
        }
        return true;
    }

    public static boolean validateSessionID(String arg) {

        String sessionIDFormat = "session-\\d{4}-\\d{2}-\\d{2}";

        if (!arg.matches(sessionIDFormat)) {

            System.out.println("Invalid sessionID format. Please enter the sessionID in session-yyyy-MM-dd format");
            return false;
        }
        return true;
    }

    public static boolean validateKeyword(String arg) {

        for (Session s : Global.sessionList) {
            if (s.getKeywords().contains(arg)) {
                
                return true;
            }
        }

        System.out.println("No sessions found with the keyword " + arg);
        return false;
    }
}