package com.finalproject.data_pipe;

import com.finalproject.Global;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {

    // called at the start of the program to load the file into the scanner
    public static Scanner loadFile() {

        if (!checkDataDirectory()) {

            createDataDirectory();
            createDataFile();
        }
        try {

            Scanner scanner = new Scanner(Global.filePath);
            return scanner;
        } catch (IOException e) {

            System.err.format("IO Exception (most likely permissions reading from file denied): %s%n", e);
        }
        // TODO: Check before submitting
        return null;
    }

    // verifies data storage directory exists and is a directory
    public static boolean checkDataDirectory() {

        if (Files.exists(getDataDirectory()) && Files.isDirectory(getDataDirectory())) {

            return true;
        }
        return false;
    }

    // returns the path to the data file
    public static Path getDataFile() {

        Path path = Paths.get(getDataDirectory() + "/sessions.json");
        return path;
    }

    // get the data storage directory
    // return the directory as a path object
    // no matter what, this should always be the path of the storage directory
    // (User Home Directory)/SessionManager/Data
    public static Path getDataDirectory() {

        Path path = Paths.get(System.getProperty("user.home") + "/SessionManager/Data");
        return path;
    }

    // called when no data file is found
    // creates the data file
    public static void createDataFile() {

        Path file = getDataFile();

        try {

            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {

            System.err.format("file named %s" + " already exists%n", file);
        } catch (IOException e) {

            System.err.format("Create File error: %s%n", e);
        }
    }

    // called when no storage directory is found
    // creates the storage directory
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