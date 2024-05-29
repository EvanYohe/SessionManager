package com.finalproject.command_handler;

import com.finalproject.output_formatter.OutputFormatter;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CommandParser {

    // WIP
    public static void parseCommand(Command command, Scanner userInput, Scanner fileReader) {

        switch (command.getCommand()) {

            case "create":

                Actions.create(command, userInput, fileReader);
                command.setCommandProcessed(true);
                break;

            case "delete":

                parseArguments(command, userInput);
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

                OutputFormatter.help();
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
    public static void parseArguments(Command command, Scanner scanner) {

        System.out.println("Enter command argument(s) separated by spaces:");
        OutputFormatter.prompt();

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