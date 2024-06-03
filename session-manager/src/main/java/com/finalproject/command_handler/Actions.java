package com.finalproject.command_handler;

import com.finalproject.Global;
import com.finalproject.data_pipe.ReadWriteData;
import com.finalproject.session_manager.Session;
import java.util.ArrayList;

public class Actions {

    // TODO: Implement the create method, work in progress
    // create a session and add to stored sessions
    public static void create(Command command) {

        // parse the arguments
        CommandParser.parseArguments(command);

        try {

            // create a session object from the arguments
            String sessionID = "session-" + command.getArguments().get(0);
            String sessionDate = command.getArguments().get(0); // use DateTimeParser to serialize into format
            String sessionTime = command.getArguments().get(1); // use DateTimeParser to serialize into format
            String sessionDuration = command.getArguments().get(2); // use DateTimeParser to serialize into format
            ArrayList<String> sessionKeywords = new ArrayList<String>();

            // process keywords into an arrayList
            for (String keyword : command.getArguments().get(3).split(" ")) {
                sessionKeywords.add(keyword);
            }

            // build the session object
            Session session = new Session(sessionDate, sessionTime, sessionDuration, sessionKeywords, sessionID);

            // add the session to the global session list
            Global.sessionList.add(session);

            System.out.println(Global.sessionList.size() + " sessions in list");
            System.out.println(Global.sessionList.get(0));
            // write the new session list to the file
            ReadWriteData.writeJsonArray(Global.sessionList, Global.fileWriter);

        } catch (Exception e) {

            System.err.format("IO Exception (most likely permissions or invalid arguments): %s%n", e);
            System.out.println("Command aborted");
        }
    }

    // TODO: Implement the delete method, work in progress
    // delete a session by ID from JSON array of sessions
    public static void delete(Command command) {

        // parse the arguments
        CommandParser.parseArguments(command);

        // prompt for confirmation
        System.out.println("Are you sure you want to delete this session? (Y/N)");

        try {
            // normalize the input of the confirmation
            String confirmation = Global.userInput.nextLine().trim().toLowerCase();

            switch (confirmation) {
                case "y":
                    
                    // grab the array list of sessions from the JSON array in Main.sessionList
                    // find the session with the matching ID
                    // remove the session from the array list
                    // call ReadWriteData.writeJsonArray to write the new array list to the file

                break;

                default: // anything other than a 'y' will effectively cancel the delete, as no action is taken
                break;
            }
        } catch (Exception e) {
            System.err.format("Invalid Argument: %s%n", e);
        }
    }

    // TODO: Implement the list method, work in progress
    // lists session(s) by keyword or date range, or single session by ID
    public static void list(Command command) {

        CommandParser.parseArguments(command);

        // Determine the argument (all, sessionID, keyword, or date range)
        
        // all
        // call SessionListBuilder.listAll()
        // call OutputFormatter.printSessionList() with the list of sessions

        // sessionID
        // call SessionListBuilder.listSingle()
        // call OutputFormatter.printSingleSession() with the session

        // keyword
        // call SessionListBuilder.listByKeyword()
        // call OutputFormatter.printSessionList() with the list of sessions

        // date range
        // call SessionListBuilder.listByDateRange()
        // call OutputFormatter.printSessionList() with the list of sessions

    }

    // TODO: Implement the edit method, work in progress
    // edit a session by session ID
    public static void edit(Command command) {

        CommandParser.parseArguments(command);

        // grab the session list from the JSON array in Main.sessionList
        // find the session with the matching ID
        // grab the session object and update the session object with the new data
        // call ReadWriteData.writeJsonArray to write the new array list to the file
    }

    // exit the program
    public static void exit() {

        // exit the program by calling System.exit(0)
        System.out.println("Exiting...");
        System.exit(0);
    }
}