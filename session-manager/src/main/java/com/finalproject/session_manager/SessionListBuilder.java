package com.finalproject.session_manager;

import com.finalproject.Global;
import com.finalproject.data_pipe.ReadWriteData;
import com.finalproject.output_formatter.DateTimeParser;

import java.util.ArrayList;

public class SessionListBuilder {

    // there can be multiple sessions of a single ID
    // this is not necessarily a bug, if two sessions are created on the same day
    // their content may be different but their date and ID will match
    public static ArrayList<Session> getSessionsByID(String sessionID) {

        ArrayList<Session> sessions = new ArrayList<>();

        for (Session s : Global.sessionList) {
            if (s.getSessionID().equals(sessionID)) {

                sessions.add(s);
            }
        }
        return sessions;
    }

    // linear search for sessions containing the keyword
    // returns an array list of sessions that contain the keyword
    public static ArrayList<Session> listByKeyword(String keyword) {

        ArrayList<Session> sessions = new ArrayList<Session>();

        for (Session s : Global.sessionList) {
            if (s.getKeywords().contains(keyword)) {

                sessions.add(s);
            }
        }
        return sessions;
    }

    // first make sure the dates are in the correct order, oldest to newest
    // then create an array list of sessions by comparing the date of each session
    // to come after the oldest date and before the newest date
    public static ArrayList<Session> listByDateRange(String start, String end) {

        if (!DateTimeParser.compareSessionDate(start, end)) {

            String temp = start;
            start = end;
            end = temp;
        }

        ArrayList<Session> sessions = new ArrayList<Session>();

        for (Session s : Global.sessionList) {
            if ((DateTimeParser.compareSessionDate(start, s.getDate()) || s.getDate().equals(start))
                    && (DateTimeParser.compareSessionDate(s.getDate(), end) || s.getDate().equals(end))) {

                sessions.add(s);
            }
        }
        return sessions;
    }

    // run at the beginning of the program to
    // ensure the session list is sorted by date
    public static void sortSessionList() {

        ArrayList<Session> sortedList = new ArrayList<Session>();
        Session[] unsortedArray = new Session[Global.sessionList.size()];

        for (int i = 0; i < Global.sessionList.size(); i++) {

            unsortedArray[i] = Global.sessionList.get(i);
        }

        mergeSort(unsortedArray, unsortedArray.length);

        for (Session s : unsortedArray) {

            sortedList.add(s);
        }
        ReadWriteData.writeJsonArray(sortedList, Global.fileWriter);
    }

    // merge sort implementation
    // see citations for source
    // I did not write this but I do understand the way merge sort works
    public static void mergeSort(Session[] unsortedArray, int unsortedLength) {

        if (unsortedLength < 2) {

            return;
        }

        int mid = unsortedLength / 2;

        Session[] leftArray = new Session[mid];
        Session[] rightArray = new Session[unsortedLength - mid];

        for (int i = 0; i < mid; i++) {

            leftArray[i] = unsortedArray[i];
        }
        for (int i = mid; i < unsortedLength; i++) {

            rightArray[i - mid] = unsortedArray[i];
        }

        mergeSort(leftArray, mid);
        mergeSort(rightArray, unsortedLength - mid);
        merge(unsortedArray, leftArray, rightArray, mid, unsortedLength - mid);
    }

    public static void merge(Session[] unsortedArray, Session[] leftArray, Session[] rightArray, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (DateTimeParser.compareSessionDate(leftArray[i].getDate(), rightArray[j].getDate())) {

                unsortedArray[k++] = leftArray[i++];
            } else {

                unsortedArray[k++] = rightArray[j++];
            }
        }
        while (i < left) {

            unsortedArray[k++] = leftArray[i++];
        }
        while (j < right) {
            
            unsortedArray[k++] = rightArray[j++];
        }
    }
}
