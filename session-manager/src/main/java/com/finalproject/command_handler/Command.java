package com.finalproject.command_handler;

import java.util.ArrayList;

// command object data structure
public class Command{

    private String command;
    private boolean isCommandProcessed = false;
    private boolean isArgumentsProcessed = false;
    private ArrayList<String> arguments;

    public Command(String command, boolean isCommandProcessed, boolean isArgumentsProcessed){

        this.command = command;
        this.isCommandProcessed = isCommandProcessed;
        this.isArgumentsProcessed = isArgumentsProcessed;

    }

    public Command(String command, ArrayList<String> arguments, boolean isCommandProcessed, boolean isArgumentsProcessed){

        this.command = command;
        this.arguments = arguments;
        this.isCommandProcessed = isCommandProcessed;
        this.isArgumentsProcessed = isArgumentsProcessed;

    }

    public String getCommand(){
        
        return command;
    }

    public ArrayList<String> getArguments(){
        
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments){
        
        this.arguments = arguments;
    }

    public boolean isCommandProcessed(){
        
        return isCommandProcessed;
    }

    public boolean setCommandProcessed(boolean isCommandProcessed){
        
        this.isCommandProcessed = isCommandProcessed;
        return isCommandProcessed;
    }

    public boolean isArgumentsProcessed(){
        
        return isArgumentsProcessed;
    }

    public boolean setArgumentsProcessed(boolean isArgumentsProcessed){
        
        this.isArgumentsProcessed = isArgumentsProcessed;
        return isArgumentsProcessed;
    }
}
