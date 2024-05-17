package com.finalproject.command_handler;
import java.util.ArrayList;

public class Argument{

    private ArrayList<String> arguments;

    Argument(ArrayList<String> arguments){

        this.arguments = arguments;
    }

    public String getArgument(int index){
        
        return arguments.get(index);
    }
}
