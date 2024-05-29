package com.finalproject.data_pipe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {

    //FINISHED
    // create a scanner object
    // call checkDataDirectory()
    // if checkDataDirectory() returns false, create directory and file
    // create and return a scanner object if file exists and can be read
    public static Scanner loadFile() {

        File filePath = getDataFile().toFile();

        if (!checkDataDirectory()) {
            createDataDirectory();
            createDataFile();
        }

        try {
            Scanner scanner = new Scanner(filePath);
            return scanner;
        } catch (IOException e) {
            System.err.format("IO Exception (most likely permissions): %s%n", e);
        }
        // this feels wrong, address later
        return null;
    }

    // TODO
    // save file and close scanner
    public static void unloadFile() {

        // save the file
        // close the scanner object
    }

    // TODO
    // check if file is closed
    public static boolean isFileUnloaded() {

        return false;
    }

    // FINISHED
    // if data storage directory exists, return true
    public static boolean checkDataDirectory() {

        if (Files.exists(getDataDirectory()) && Files.isDirectory(getDataDirectory())) {
            return true;
        }
        return false;
    }

    // FINISHED
    // return the data file as a path object
    public static Path getDataFile() {

        Path path = Paths.get(getDataDirectory() + "/sessions.json");

        return path;
    }

    // FINISHED
    // get the data storage directory
    // return the directory as a path object
    // No matter what, this should always be the format of the storage directory
    // (User Home Directory)/SessionManager/Data
    public static Path getDataDirectory() {

        String dataDir = System.getProperty("user.home") + "/SessionManager/Data";
        Path path = Paths.get(dataDir);

        return path;
    }

    // FINISHED
    // create a new file in the data storage directory
    public static void createDataFile() {

        Path file = Paths.get(getDataDirectory() + "/sessions.json");

        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {
            System.err.format("file named %s" + " already exists%n", file);
        } catch (IOException e) {
            System.err.format("Create File error: %s%n", e);
        }
    }

    //FINISHED
    // nagivate to user home directory on operating system
    // create a directory called (User Home Directory)/SessionManager/Data
    public static void createDataDirectory() {

        Path path = getDataDirectory();

        try {
            Files.createDirectories(path);
        } catch (FileAlreadyExistsException e) {
            System.err.format("directory named %s" + " already exists%n", path);
        } catch (IOException e) {
            System.err.format("Create Directory error: %s%n", e);
        }
        
    }
}