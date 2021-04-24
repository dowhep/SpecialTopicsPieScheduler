package io.github.dowhep.HelperClasses;
import java.util.ArrayList;

import io.github.dowhep.AbstractClasses.*;

public class Data 
{
    public static ArrayList<Pie> pies;
    public static void main(String[] args) 
    {
        pies = new ArrayList<Pie>();
    }

    public static int getNumberOfPies()
    {
        return pies.size();
    }
}
