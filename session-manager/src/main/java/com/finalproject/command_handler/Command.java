package com.finalproject.command_handler;

import java.util.ArrayList;

// Command Object Data Structure
// this code doesn't need many comments, it's just a data structure
// with getters and setters
public class Command {
    
    private String command;
    private ArrayList<String> arguments;
    private boolean isCommandProcessed = false;
    private boolean isArgumentsProcessed = false;

    public Command(String command, ArrayList<String> arguments, boolean isCommandProcessed,
            boolean isArgumentsProcessed) {
        this.command = command.trim().toLowerCase();
        this.arguments = arguments;
        this.isCommandProcessed = isCommandProcessed;
        this.isArgumentsProcessed = isArgumentsProcessed;
    }

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public boolean isCommandProcessed() {
        return isCommandProcessed;
    }

    public boolean setCommandProcessed(boolean isCommandProcessed) {
        this.isCommandProcessed = isCommandProcessed;
        return isCommandProcessed;
    }

    public boolean isArgumentsProcessed() {
        return isArgumentsProcessed;
    }

    public boolean setArgumentsProcessed(boolean isArgumentsProcessed) {
        this.isArgumentsProcessed = isArgumentsProcessed;
        return isArgumentsProcessed;
    }
}