package io.github.dowhep.AbstractClasses;

import java.util.*;
import io.github.dowhep.HelperClasses.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pie {
	// Varriables:
	private final StringProperty pieName;
	private final StringProperty color;
	private final BooleanProperty timeFormat;
	private final ObservableList<PieSlice> sliceStorage;

	// Constructors:
	public Pie() {
		this("New Pie", "#FFFFFF", true);
	}

	public Pie(String userPieName, String userColor, Boolean userTimeFormat) {
		pieName = new SimpleStringProperty(userPieName);
		sliceStorage = FXCollections.observableList(new ArrayList<PieSlice>());
		color = new SimpleStringProperty(userColor);
		timeFormat = new SimpleBooleanProperty(userTimeFormat);
	}

	// "Get" Methods: 
	public void rename(String name) {
		pieName.set(name);
	}

	public final StringProperty pieNameProperty() {
		return pieName;
	}

	public final StringProperty colorProperty() {
		return color;
	}

	public final BooleanProperty timeFormatProperty() {
		return timeFormat;
	}

	public final ObservableList<PieSlice> getSliceStorage() {
		return sliceStorage;
	}

	// true is 24hr, false is 12hr

	/* Methods
	 * Constructors:
	 * 		- From Scratch (With no information, the user creates everything)
	 * 		- From presets / templates
	 * 			Presets would be full pies. They would contain detailed slices.
	 * 			Templates would be similar to presets. However, they would not have detailed slices
	 * 			Should be able to create this from a compact downloadable file (.txt perhaps?)
	 * Quality of Life:
	 * 		- Rename
	 * 			Pies should be able to be easily renamed (string file)
	 * 		- Edit
	 * 			Pies (and contents) should be able to be easily editable (access editing methods
	 * 			of objects)
	 * 		- Export
	 * 			Pies should be able to be exported into a shareable file (.txt) as a template/preset
	 * 			(export info regarding slices via method, same with pie)
	 * 		- Import
	 * 			Pies should be able to be imported (both full pies and slices) [reads .txt file]
	 * 				a.) Important Note: Should make sure the importing slices doesn't accidentally
	 * 					wipe existing slices, especially if pie is reaching full capacity
	 * 		- Delete
	 * 			Pies should be able to be easily deleteable (set to null)
	 * 		- Save
	 * 			Pies should be able to be saved to device. This should happen both automatically
	 * 			and manually. (Similar to export but is to the dedicated storage app installed in)
	 * 				a.) Important Note: Check if storage in device is adequate
	 * 				b.) Consider reserving part of the device's storage on installation
	 * 		- Time Style
	 * 			Should be able to switch between AM/PM and army time (24:00)
	 * 			(Implement via a boolean. Store in army, convert to AM/PM depending on boolean)
	 */
}