package com.finalproject.output_formatter;

import com.finalproject.session_manager.Session;

import java.util.ArrayList;

// these methods are all fairly straight forward and don't require many comments
// string regex is used heavily to format the output of sessions into organized lists
public class OutputFormatter {

        public static void printSingleSession(Session session) {

                String format = "| %-18s | %-12s | %-8s | %-11s | %-70s |%n";

                System.out.format(
                                "+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
                System.out.format(
                                "| Session ID         | Date         | Time     | Duration    | Keywords                                                               |%n");
                System.out.format(
                                "+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
                System.out.format(format,
                                session.getSessionID(),
                                DateTimeParser.deserializeDate(session.getDate()),
                                DateTimeParser.deserializeTime(session.getTime()),
                                DateTimeParser.deserializeDuration(session.getDuration()),
                                session.getKeywords());
                System.out.format(
                                "+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
        };

        public static void printSessionList(ArrayList<Session> sessionList) {

                String format = "| %-18s | %-12s | %-8s | %-11s | %-70s |%n";

                System.out.format(
                                "+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
                System.out.format(
                                "| Session ID         | Date         | Time     | Duration    | Keywords                                                               |%n");
                System.out.format(
                                "+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
                for (Session session : sessionList) {
                        System.out.format(format,
                                        session.getSessionID(),
                                        DateTimeParser.deserializeDate(session.getDate()),
                                        DateTimeParser.deserializeTime(session.getTime()),
                                        DateTimeParser.deserializeDuration(session.getDuration()),
                                        session.getKeywords());
                }
                System.out.format(
                                "+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
        };

        public static void printSelectSessionList(ArrayList<Session> sessionList) {

                String format = "| %-2s | %-18s | %-12s | %-8s | %-11s | %-70s |%n";

                System.out.format(
                                "+----+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
                System.out.format(
                                "| #  | Session ID         | Date         | Time     | Duration    | Keywords                                                               |%n");
                System.out.format(
                                "+----+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
                for (int i = 1; i <= sessionList.size(); i++) {
                        System.out.format(format, i,
                                        sessionList.get(i - 1).getSessionID(),
                                        DateTimeParser.deserializeDate(sessionList.get(i - 1).getDate()),
                                        DateTimeParser.deserializeTime(sessionList.get(i - 1).getTime()),
                                        DateTimeParser.deserializeDuration(sessionList.get(i - 1).getDuration()),
                                        sessionList.get(i - 1).getKeywords());
                }
                System.out.format(
                                "+----+--------------------+--------------+----------+-------------+------------------------------------------------------------------------+%n");
        };

        public static void help() {

                String[][] tableData = {
                                { "create", "Create a new session", "Date Time Duration Keyword(s) Topic(s)" },
                                { "delete", "Delete a session by ID", "sessionID" },
                                { "list", "Display a list sessions", "Range/Keyword will be prompted for filtering." },
                                { "edit", "Edit a session by ID", "sessionID" },
                                { "help", "Display this help message", "" },
                                { "exit", "Exit the program", "" }
                };

                String format = "| %-8s | %-26s | %-51s |%n";

                System.out.format(
                                "+----------+----------------------------+-----------------------------------------------------|%n");
                System.out.format(
                                "| Command  | Description                | Argument(s)                                         |%n");
                System.out.format(
                                "+----------+----------------------------+-----------------------------------------------------|%n");
                for (int i = 0; i < 6; i++) {
                        System.out.format(format, tableData[i][0], tableData[i][1], tableData[i][2]);
                }
                System.out.format(
                                "+----------+----------------------------+-----------------------------------------------------|%n");
        }

        public static void banner() {

                System.out.println("  ___            _          __  __                             ");
                System.out.println(" / __| ___ _____(_)___ _ _ |  \\/  |__ _ _ _  __ _ __ _ ___ _ _ ");
                System.out.println(" \\__ \\/ -_|_-<_-< / _ \\ ' \\| |\\/| / _` | ' \\/ _` / _` / -_) '_|");
                System.out.println(" |___/\\___/__/__/_\\___/_||_|_|  |_\\__,_|_||_\\__,_\\__, \\___|_|  ");
                System.out.println("                                                 |___/         ");
                System.out.println("You can type 'help' for a list of commands or 'exit' to quit.");
                System.out.println("Otherwise, enter a command:");
        }

        public static void prompt() {
                
                System.out.print("session-manager> ");
        }
}
