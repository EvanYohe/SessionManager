package com.finalproject.output_formatter;

public class DateTimeParser {

    // TODO: Implement the checkDateFormat method
    public static boolean checkDateFormat(String date) {

        String[] dateArray = date.split("-");
        String month = dateArray[0];
        String day = dateArray[1];
        String year = dateArray[2];

        if (month.length() != 2 || day.length() != 2 || year.length() != 4) {
            return false;
        }

        return true;
    }

    // TODO: Implement the checkTimeFormat method
    public static boolean checkTimeFormat(String time) {

        String[] timeArray = time.split(":");
        String hour = timeArray[0];
        String minute = timeArray[1];
        String second = timeArray[2];

        if (hour.length() != 2 || minute.length() != 2 || second.length() != 2) {
            return false;
        }

        return true;
    }

    // TODO: Implement the serializeDate method
    public static String serializeDate(String date) {

        String[] dateArray = date.split("-");
        String month = dateArray[0];
        String day = dateArray[1];
        String year = dateArray[2];

        return year + "-" + month + "-" + day;
    }

    // TODO: Implement the deserializeDate method
    public static String deserializeDate(String date) {

        String[] dateArray = date.split("-");
        String month = dateArray[0];
        String day = dateArray[1];
        String year = dateArray[2];

        return year + "-" + month + "-" + day;
    }

    // TODO: Implement the serializeTime method
    public static String serializeTime(String time) {

        String[] timeArray = time.split(":");
        String hour = timeArray[0];
        String minute = timeArray[1];
        String second = timeArray[2];

        return hour + ":" + minute + ":" + second;
    }

    // TODO: Implement the deserializeTime method
    public static String deserializeTime(String time) {

        String[] timeArray = time.split(":");
        String hour = timeArray[0];
        String minute = timeArray[1];
        String second = timeArray[2];

        return hour + ":" + minute + ":" + second;
    }
}
