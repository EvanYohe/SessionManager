package com.finalproject.data_pipe;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {

    public static void loadFile(String fileName) {
        
        // create a scanner object
        // call checkDataDirectory()
        // if checkDataDirectory() returns true, call getDataFile()
        // if false, call createDataDirectory() and then call createDataFile()
        
    }
    
    public static void unloadFile(){
        
        // save the file
        // close the scanner object
    }

    public static boolean isFileUnloaded() {
            
        // check if the file is closed
        // return true if closed
        // return false if open
        return false;
    }

    public static void checkDataDirectory() {

        System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));

        // if data storage directory exists, return true
        // else return false
    }

    public static void getDataFile() {

        // call getDataDirectory()
        // check if data file exists

    }
    
    public static void getDataDirectory() {
        
        // get the data storage directory
        // return the directory
        
    }
    
    public static void createDataFile() {

        // create a new file in the data storage directory
        // return the file
    }

    public static void createDataDirectory() {

        // nagivate to user directory on operating system 
        // C:\ Users\ username for windows
        // /home/username for linux
        // for mac
        // create a directory called session-manager/data
    }
}