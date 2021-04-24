package io.github.dowhep.AbstractClasses;
import java.util.*;
public class PieSlice 
{
    private String task;
    private int time;
    private boolean complete;
    private String sliceName;
    private String sliceColor;

    public PieSlice() {
        task = "default";
        time = 0;
        complete = false;
        sliceName = "default";
        sliceColor = "#FFFFFF";
    }
    public String getTask() {
        return task;
    }
    public void setTask(String input) {
        task = input;
    }
    public int getTime() {
        return time;
    }
    // if you're calling this you'll probably want
    // to run a method to change the pie visual
    // at the same time
    public void setTime(int input) {
        time = input;
    }
    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean input) {
        complete = input;
    }
    public String name() {
        return sliceName;
    }
    public void setName(String input) {
        sliceName = input;
    }
    public String color() {
        return sliceColor;
    }
    // takes in hex values
    public void setColor(String input) {
        sliceColor = input;
    }
    
}
    /*
	 * Variables:
	 * 		Tasks List(Object or String Array/Heap/Tree)
	 * 			- Depending on the complexity of the programming, the slices could contain not only
	 * 			a list of tasks, but also additional more comprehensive objects such as lists (for
	 * 			shopping lists).
	 * 		Time/Length (Integer)
	 * 			- All slice's time/length must add up to 24 hours. Storing this integer is important
	 * 			because it'll be added with the other slice's lengths to check that the pie
	 * 			Scheduler is complete.
	 * 				a.) Important Note: Have unscheduled time automatically be filled up by
	 * 					(empty) slices.
	 * 		Complete (Boolean)
	 * 			- An optional boolean for the user to check mark or mark a slice as complete.
	 * 			- Note, this should be easily reverted back and when exported, this boolean is
	 * 			turned false on import or false on the exported file.
	 * 		Main Title (String)
	 * 			- A limited digit string that shows as a preview for the slice
	 * 		Color
	 * Quality of Life:
	 * 		Change Color Method
	 * 			- Allows the user to change the color of the slice to whatever they prefer
	 * 		Re-size / Easy editing
	 */
