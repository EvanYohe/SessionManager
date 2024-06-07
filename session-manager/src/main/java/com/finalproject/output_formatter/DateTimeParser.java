package com.finalproject.output_formatter;

public class DateTimeParser {

    // compares two dates to determine if the left date is before the right date
    // used in merge sort and listing by date range
    public static boolean compareSessionDate(String left, String right) {

        String[] leftDate = left.split("-");
        String[] rightDate = right.split("-");

        if (Integer.parseInt(leftDate[0]) < Integer.parseInt(rightDate[0])) {

            return true;
        } else if (Integer.parseInt(leftDate[0]) == Integer.parseInt(rightDate[0])) {

            if (Integer.parseInt(leftDate[1]) < Integer.parseInt(rightDate[1])) {

                return true;
            } else if (Integer.parseInt(leftDate[1]) == Integer.parseInt(rightDate[1])) {

                if (Integer.parseInt(leftDate[2]) < Integer.parseInt(rightDate[2])) {

                    return true;
                }
            }
        }
        return false;
    }

    // deserializes date into readable format for listing
    public static String deserializeDate(String date) {

        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec" };

        String[] dateArray = date.split("-");

        String year = dateArray[0];
        String month = dateArray[1];
        String day = dateArray[2];

        if (day.charAt(0) == '0') {

            day = day.substring(1, 2);
        }
        return months[Integer.parseInt(month) - 1] + " " + day + ", " + year;
    }

    // deserializes time into readable format for listing
    public static String deserializeTime(String time) {

        String[] timeArray = time.split(":");

        String minute = timeArray[1];

        int hour = Integer.parseInt(timeArray[0]);

        boolean isPM = false;

        if (hour > 12) {

            hour = hour - 12;
            isPM = true;
        } else if (hour == 12) {

            isPM = true;
        }
        if (isPM) {

            return hour + ":" + minute + " PM";
        }
        return hour + ":" + minute + " AM";
    }

    // deserializes duration into readable format for listing
    public static String deserializeDuration(String duration) {

        String[] durationArray = duration.split(":");

        String minute = durationArray[1];

        int hour = Integer.parseInt(durationArray[0]);

        return hour + " h " + minute + " min";
    }
}
