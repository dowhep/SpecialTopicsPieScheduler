package HelperClasses;
import java.util.ArrayList;

import Classes.*;

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
