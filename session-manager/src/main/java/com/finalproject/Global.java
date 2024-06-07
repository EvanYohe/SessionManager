package com.finalproject;

import com.finalproject.data_pipe.FileHandler;
import com.finalproject.session_manager.Session;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// These are the global variables that are used throughout the program
// Originally I had scanners and filereaders being created and passed all over the place
// So I took all the important variables and build them from here

// As long as the program is running, all of these variables should be necessary

// Because the first call the program makes is to load sessions from the file,
// a strong reference to Global.java should keep all of these object from being cleaned
// during garbage collection
public class Global {

    public static Gson jsonWriter = new GsonBuilder().setPrettyPrinting().create();
    public static Scanner userInput = new Scanner(System.in);
    public static File filePath = FileHandler.getDataFile().toFile();
    public static Scanner fileReader = FileHandler.loadFile();
    public static ArrayList<Session> sessionList = new ArrayList<>();
    public static PrintWriter fileWriter;
}