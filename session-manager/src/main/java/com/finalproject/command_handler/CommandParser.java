package com.finalproject.command_handler;

import com.finalproject.Main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CommandParser {

    private Command command;

    public CommandParser() {}

    public CommandParser(Command command) {

        this.command = command;
    }

    // WIP
    public void parse(Command command, Scanner scanner) {

        switch (command.getCommand()) {

            case "create":

                System.out.println("Create a new session with the following arguments:");
                System.out.println("| Date | Time | Duration | Keyword(s) | Topic(s) |");
                System.out.println("Example: create 2021-12-31 12:00:00 01:00:00 Java OOP");
                parseArguments(command, scanner);
                command.setCommandProcessed(true);
                break;

            case "delete":

                parseArguments(command, scanner);
                command.setCommandProcessed(true);
                break;

            case "list":

                Actions.list();
                command.setCommandProcessed(true);
                break;

            case "edit":

                Actions.edit();
                command.setCommandProcessed(true);
                break;

            case "help":

                Actions.help();
                command.setCommandProcessed(true);
                break;

            case "exit":

                Actions.exit();
                break;

            default:

                System.out.println("Invalid command.");
                break;
        }
    }

    // WIP
    public void parseArguments(Command command, Scanner scanner) {

        System.out.println("Enter command argument(s) separated by spaces:");
        Main.prompt();

        String arguments = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(arguments);

        while (tokenizer.hasMoreTokens()) {

            command.getArguments().add(tokenizer.nextToken());
        }

        if (tokenizer.countTokens() == 0) {

            command.setArgumentsProcessed(true);
        }
    }
}