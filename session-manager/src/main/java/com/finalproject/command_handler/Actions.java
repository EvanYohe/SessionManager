package com.finalproject.command_handler;

import com.finalproject.Global;
import com.finalproject.data_pipe.ReadWriteData;
import com.finalproject.output_formatter.OutputFormatter;
import com.finalproject.session_manager.Session;
import com.finalproject.session_manager.SessionListBuilder;

import java.util.ArrayList;

public class Actions {

    public static void create(Command command) {

        CommandParser.parseArguments(command);

        try {

            // this code seems redundant but when parseArguments saves 'exit' as an argument
            // it will return from the method call and run this try catch block
            // where the program will abort before a session is created
            for (int i = 0; i < 4; i++) {
                if (command.getArguments().get(i).equals("exit")) {

                    System.out.println("Command aborted");
                    return;
                }
            }

            // Save the values for the session object from the arguments
            String sessionID = "session-" + command.getArguments().get(0);
            String sessionDate = command.getArguments().get(0);
            String sessionTime = command.getArguments().get(1);
            String sessionDuration = command.getArguments().get(2);
            ArrayList<String> sessionKeywords = new ArrayList<String>();

            for (String keyword : command.getArguments().get(3).split(" ")) {

                sessionKeywords.add(keyword);
            }

            // create the session object, add to global list, write to file
            Session session = new Session(sessionDate, sessionTime, sessionDuration, sessionKeywords, sessionID);
            Global.sessionList.add(session);
            ReadWriteData.writeJsonArray(Global.sessionList, Global.fileWriter);

        } catch (Exception e) {

            System.err.format("IO Exception (most likely permissions or invalid arguments): %s%n", e);
            System.out.println("Command aborted");
        }
    }

    public static void delete(Command command) {

        CommandParser.parseArguments(command);

        // This is the same codeblock used in the edit method to specify
        // which session should be deleted in the case of two or more
        // matching session IDs

        // fetch an array list of all sessions with the matching ID
        ArrayList<Session> sessions = SessionListBuilder.getSessionsByID(command.getArguments().get(0));
        Session session = null; // This is filled with a reference later

        int selector = 0; // integer selector when picking from list
        boolean validated = false; // keeps the loop running until a valid selection is made

        // runs when more than one session is found
        if (sessions.size() > 1){

            OutputFormatter.printSelectSessionList(sessions);
            System.out.println("Multiple sessions found with that ID. Select the session you want to enter");

            while (!validated) {

                OutputFormatter.prompt();
                String input = Global.userInput.nextLine().trim().toLowerCase();
    
                // input must be a positive non-zero integer
                // smaller than the size of the sessions array
                if (input.equals("exit")) {
                    
                    // break if the user enters 'exit'
                    // effectively cancels the delete
                    return; 
                }
                try {
                    
                    selector = Integer.parseInt(input);
                } catch (NumberFormatException e) {
    
                    System.out.println("Invalid selection. Enter a number between 1 and " + sessions.size() + " or 'exit' to cancel");
                }
                if (selector < 1 || selector > sessions.size()) {
    
                    System.out.println("Invalid selection. Enter a number between 1 and " + sessions.size() + " or 'exit' to cancel");
                }
                if (selector > 0 && selector <= sessions.size()) {
    
                    session = sessions.get(selector - 1);
                    validated = true;
                }
            }
        // if only one sessions is found with the matching ID, it will be at zero index
        } else {
                
                session = sessions.get(0);
        }

        // prompt the user for confirmation
        OutputFormatter.printSingleSession(session);
        System.out.println("Are you sure you want to delete this session? (Y/N)");
        String confirmation = Global.userInput.nextLine().trim().toLowerCase();

        // if the user types 'y' or 'yes', the session is deleted
        switch (confirmation) {
            case "y":
            case "yes":
       
                Global.sessionList.remove(session);
                ReadWriteData.writeJsonArray(Global.sessionList, Global.fileWriter);
                break;
            default: // anything other than a 'y' or 'yes' will effectively cancel the delete
                System.out.println("Command aborted");
                break;
        }
    }

    // this method follows the same structure in all cases of the switch block
    // prompt for user ID and check if it's 'exit' (to abort the command)
    // or invalid. If it's valid, print the list of sessions
    public static void list(Command command) {

        CommandParser.parseArguments(command);
        boolean validated = false;

        switch (command.getArguments().get(0)) {
            case "all":

                // print the global list of all sessions
                OutputFormatter.printSessionList(Global.sessionList);
                break;
            case "sessionid":
                while (!validated) {

                    
                    System.out.println("Enter the sessionID you want to list (session-yyyy-MM-dd)");
                    OutputFormatter.prompt();

                    String arg = Global.userInput.nextLine().trim().toLowerCase();

                    if (arg.equals("exit")) {

                        break;
                    }
                    if (CommandParser.validateSessionID(arg)) {

                        OutputFormatter.printSessionList(SessionListBuilder.getSessionsByID(arg));
                        validated = true;
                    }
                }
                break;
            case "keyword":
                while (!validated) {

                    System.out.println("Enter the keyword you want to list");
                    OutputFormatter.prompt();

                    String arg = Global.userInput.nextLine().trim().toLowerCase();

                    if (arg.equals("exit")) {

                        break;
                    }
                    if (CommandParser.validateKeyword(arg)) {

                        OutputFormatter.printSessionList(SessionListBuilder.listByKeyword(arg));
                        validated = true;
                    }
                }
                break;

            // this one was a pain in the ass
            // I had to implement a sorting method, and a date comparison 
            // method just to accomodate this
            case "date range":
                while (!validated) {

                    System.out.println("Enter the date range you want to list (yyyy-MM-dd  yyyy-MM-dd)");
                    OutputFormatter.prompt();

                    String arg = Global.userInput.nextLine().trim().toLowerCase();

                    if (arg.equals("exit")) {

                        break;
                    }
                    if (CommandParser.validateDateRange(arg)) {

                        String[] dateRange = arg.split(" ");
                        OutputFormatter
                                .printSessionList(SessionListBuilder.listByDateRange(dateRange[0], dateRange[1]));
                        validated = true;
                    }
                }
                break;
            default:

                System.out.println("Invalid argument. Enter 'help' for a list of commands");
                break;
        }
    }

    // first checks for duplicate session IDs and prompts the user for selection
    // then prompt for the field to edit, and set the new value
    public static void edit(Command command) {

        CommandParser.parseArguments(command);

        ArrayList<Session> sessions = SessionListBuilder.getSessionsByID(command.getArguments().get(0));
        Session session = null;

        int selector = 0;
        boolean validated = false;

        if (sessions.size() > 1){

            OutputFormatter.printSelectSessionList(sessions);
            System.out.println("Multiple sessions found with that ID. Select the session you want to enter");

            while (!validated) {

                OutputFormatter.prompt();
                String input = Global.userInput.nextLine().trim().toLowerCase();
    
                if (input.equals("exit")) {
                    
                    // break if the user enters 'exit' instead of an integer
                    return; 
                }
                try {
    
                    selector = Integer.parseInt(input);
                } catch (NumberFormatException e) {
    
                    System.out.println("Invalid selection. Enter a number between 1 and " + sessions.size() + " or 'exit' to cancel");
                }
                if (selector < 1 || selector > sessions.size()) {
    
                    System.out.println("Invalid selection. Enter a number between 1 and " + sessions.size() + " or 'exit' to cancel");
                }
                if (selector > 0 && selector <= sessions.size()) {
    
                    session = sessions.get(selector - 1);
                    validated = true;
                }
            }
        } else {
                
                session = sessions.get(0);
        }
        
        validated = false;

        while (!validated) {

            System.out.println("Enter 'sessionID', 'date', 'time', 'duration', or 'keywords' to select what you want to edit");
            OutputFormatter.prompt();
            String editArgument = Global.userInput.nextLine().trim().toLowerCase();

            switch (editArgument) {
                case "sessionid":

                    System.out.println("Enter the new session ID");
                    OutputFormatter.prompt();
                    String newID = Global.userInput.nextLine().trim().toLowerCase();

                    if (CommandParser.validateSessionID(newID)) {

                        session.setSessionID(newID);
                        validated = true;
                    }
                    break;
                case "date":

                    System.out.println("Enter the new date (yyyy-MM-dd)");
                    OutputFormatter.prompt();
                    String newDate = Global.userInput.nextLine().trim().toLowerCase();

                    if (CommandParser.validateDate(newDate)) {

                        session.setDate(newDate);
                        validated = true;
                    }
                    break;
                case "time":

                    System.out.println("Enter the new time (HH:mm)");
                    OutputFormatter.prompt();
                    String newTime = Global.userInput.nextLine().trim().toLowerCase();

                    if (CommandParser.validateTime(newTime)) {

                        session.setTime(newTime);
                        validated = true;
                    }
                    break;
                case "duration":

                    System.out.println("Enter the new duration (HH:mm)");
                    OutputFormatter.prompt();
                    String newDuration = Global.userInput.nextLine().trim().toLowerCase();

                    if (CommandParser.validateTime(newDuration)) {

                        session.setDuration(newDuration);
                        validated = true;
                    }
                    break;
                case "keywords":

                    System.out.println("Enter the new keywords (separated by spaces)");
                    OutputFormatter.prompt();
                    ArrayList<String> newKeywords = new ArrayList<String>();

                    for (String keyword : Global.userInput.nextLine().trim().toLowerCase().split(" ")) {

                        newKeywords.add(keyword);
                    }

                    session.setKeywords(newKeywords);
                    validated = true;
                    break;
                case "exit":

                    validated = true;
                    break;
                default:

                    System.out.println("Invalid argument");
                    break;
            }
        }
        
        ReadWriteData.writeJsonArray(Global.sessionList, Global.fileWriter);
    }

    public static void exit() {
        
        System.out.println("Exiting...");
        System.exit(0);
    }
}