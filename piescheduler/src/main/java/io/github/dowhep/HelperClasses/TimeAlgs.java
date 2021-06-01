package io.github.dowhep.HelperClasses;

public class TimeAlgs {
    // time stores minutes past 00:00
    /**
     * return string version of time
     * @param time minute spent passed 00:00 am
     * @return string version
     */
    public static String translateTimeIntStr(int time) {
        return String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
    }

    /**
     * return integer version of time, capped seperately hours and minutes
     * @param str string formated with "\d{0,inf}:\d{0,inf}"
     * @return minute spent passed 00:00 am (capped 00:00 - 23:59)
     */
    public static int translateTimeStrInt(String str) {
        assert (str.matches("\\d*:\\d*"));
        String[] tuplet = str.split(":");
        int hour = tuplet.length < 1 ? 0 : advParseInt(tuplet[0]);
        int minute = tuplet.length < 2 ? 0 : advParseInt(tuplet[1]);
        hour = hour < 0 ? 0 : hour > 23 ? 23 : hour;
        minute = minute < 0 ? 0 : minute > 59 ? 59 : minute;
        return hour * 60 + minute;
    }

    /**
     * return integer version of time uncapped
     * @param str string formated with "\d{0,inf}:\d{0,inf}"
     * @return total minutes
     */
    public static int translateTimeStrIntUncapped(String str) {
        assert (str.matches("\\d*:\\d*"));
        String[] tuplet = str.split(":");
        int hour = tuplet.length < 1 ? 0 : advParseInt(tuplet[0]);
        int minute = tuplet.length < 2 ? 0 : advParseInt(tuplet[1]);
        return hour * 60 + minute;
    }

    /**
     * turns any input in a time form of hh:mm if possible
     * @param input any string
     * @param capped whether the value of time is capped at 23:59
     * @return a time formatted string
     */
    public static String validatedTimeInput(String input, boolean capped) {
        return translateTimeIntStr(capped ? translateTimeStrInt(validateTimeForm(input))
                : translateTimeStrIntUncapped(validateTimeForm(input)));
    }

    /**
     * returns a formated input equal to the closest equivalent time
     * @param input unformated input
     * @return formated input
     */
    public static String validateTimeForm(String input) {
        StringBuilder newInput = new StringBuilder(input.replaceAll("[^0-9:]", ""));
        if (newInput.length() == 0)
            return "00:00"; // check if empty
        int indCol = newInput.indexOf(":");
        if (indCol == -1) {
            if (newInput.length() == 1)
                newInput.insert(0, "0");
            newInput.insert(newInput.length() - 2, ":");
            return newInput.toString();
        } else {
            int secIndCol = newInput.indexOf(":", indCol + 1);
            while (secIndCol == indCol + 1) {
                newInput.deleteCharAt(secIndCol);
                secIndCol = newInput.indexOf(":", indCol + 1);
            }
            if (secIndCol == -1) {
                return newInput.toString();
            } else {
                return newInput.substring(0, secIndCol);
            }
        }
    }

    private static int advParseInt(String str) {
        try {
            return str.isEmpty() ? 0 : Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
