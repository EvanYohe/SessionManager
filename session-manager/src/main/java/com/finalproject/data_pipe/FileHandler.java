package com.finalproject.data_pipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.finalproject.Global;

public class FileHandler {

    // create a scanner object
    // call checkDataDirectory()
    // if checkDataDirectory() returns false, create directory and file
    // create and return a scanner object if file exists and can be read
    public static Scanner loadFile() {

        // if the data directory does not exist, create it and a data file
        if (!checkDataDirectory()) {
            createDataDirectory();
            createDataFile();
        }
        try {
            // Create a scanner object
            // This is the fileWriter Scanner object that is referenced in Global.java
            Scanner scanner = new Scanner(Global.filePath);
            return scanner;
        } catch (IOException e) {
            System.err.format("IO Exception (most likely permissions): %s%n", e);
        }
        // TODO: Check before submitting
        return null;
    }

    // if data storage directory exists, return true
    public static boolean checkDataDirectory() {

        if (Files.exists(getDataDirectory()) && Files.isDirectory(getDataDirectory())) {
            return true;
        }
        return false;
    }

    // return the data file as a path object
    public static Path getDataFile() {

        // Grab the path of the data file from the path of the data directory
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

    // create a new data file in the data storage directory
    public static void createDataFile() {

        // get the path of the data file
        Path file = getDataFile();

        // create the file or catch an exception
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {
            System.err.format("file named %s" + " already exists%n", file);
        } catch (IOException e) {
            System.err.format("Create File error: %s%n", e);
        }
    }

    // nagivate to user home directory on operating system
    // create a directory called (User Home Directory)/SessionManager/Data
    public static void createDataDirectory() {

        // get the path of the data directory
        Path path = getDataDirectory();

        // create the directory or catch an exception
        try {
            Files.createDirectories(path);
        } catch (FileAlreadyExistsException e) {
            System.err.format("directory named %s" + " already exists%n", path);
        } catch (IOException e) {
            System.err.format("Create Directory error: %s%n", e);
        }
    }
}