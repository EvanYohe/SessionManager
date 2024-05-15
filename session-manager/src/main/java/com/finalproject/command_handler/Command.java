package com.finalproject.command_handler;

public class Command{

    public String command;
    public Argument arguments;

    Command(String command, Argument arg){

        this.command = command;
        this.arguments = arg;
    }

    public String getCommand(){
        
        return command;
    }
}
