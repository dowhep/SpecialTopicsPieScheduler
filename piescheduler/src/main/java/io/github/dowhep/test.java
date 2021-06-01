package io.github.dowhep;

import io.github.dowhep.HelperClasses.TimeAlgs;

public class test {
    public static void main(String[] args) {
        String test = "12::::::12342134";
        test = TimeAlgs.validateTimeForm(test);
        // System.out.println(Integer.parseInt(test));
        // System.out.println(test.matches("[0-9:]{1,5}"));
        System.out.println(test);
    }
}
