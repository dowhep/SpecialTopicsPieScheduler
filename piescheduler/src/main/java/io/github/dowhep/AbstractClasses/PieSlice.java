package io.github.dowhep.AbstractClasses;

import io.github.dowhep.HelperClasses.TimeAlgs;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class PieSlice {
    private final StringProperty sliceName;
    private final StringProperty task;
    private final IntegerProperty startTime; // stores minutes pass 00:00 am, ex: 10:00 am => 600
    private final IntegerProperty duration;
    private final BooleanProperty complete;
    private final ObjectProperty<Color> sliceColor;

    public PieSlice() {
        this("Default", "Default", 0, 0, Color.WHITE);
    }

    public PieSlice(String SliceName, String Task) {
        this(SliceName, Task, 0, 0, Color.WHITE);
    }

    public PieSlice(String SliceName, String Task, int StartTime, int Duration, Color SliceColor) {
        sliceName = new SimpleStringProperty(SliceName);
        task = new SimpleStringProperty(Task);
        startTime = new SimpleIntegerProperty(StartTime);
        duration = new SimpleIntegerProperty(Duration);
        complete = new SimpleBooleanProperty(false);
        sliceColor = new SimpleObjectProperty<Color>(SliceColor);
    }

    public String getTask() {
        return task.get();
    }

    public void setTask(String input) {
        task.set(input);
    }

    public int getDuration() {
        return duration.get();
    }

    public String getStartTimeString() {
        return TimeAlgs.translateTimeIntStr(startTime.get());
    }

    // if you're calling this you'll probably want
    // to run a method to change the pie visual
    // at the same time
    public void setDuration(int input) {
        duration.set(input);
    }

    public boolean isComplete() {
        return complete.get();
    }

    public void setComplete(boolean input) {
        complete.set(input);
    }

    public String getSliceName() {
        return sliceName.get();
    }

    public void setSliceName(String input) {
        sliceName.set(input);
    }

    public Color color() {
        return sliceColor.get();
    }

    // takes in hex values
    public void setColor(Color input) {
        sliceColor.set(input);
    }

    public String getBeginTime() {
        return TimeAlgs.translateTimeIntStr(startTime.get());
    }

    public String getEndTime() {
        return TimeAlgs.translateTimeIntStr(startTime.get() + duration.get());
    }

    public final StringProperty sliceNameProperty() {
        return sliceName;
    }

    public final StringProperty taskProperty() {
        return task;
    }

    public final IntegerProperty durationProperty() {
        return duration;
    }

    public final BooleanProperty completeProperty() {
        return complete;
    }

    public final ObjectProperty<Color> sliceColorProperty() {
        return sliceColor;
    }

    public final IntegerProperty startTimeProperty() {
        return startTime;
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
