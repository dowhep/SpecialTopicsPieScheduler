package Classes;
import java.util.*;
import HelperClasses.*;
public class Pie
{
	// Varriables:
    private String pieName;
    ArrayList<PieSlice> sliceStorage;
    private String color;

	// Constructors:
    public Pie()
    {
        pieName = "New Pie " + Data.getNumberOfPies();
        sliceStorage = new ArrayList<>();
        color = "#FFFFFF";
    }

	public Pie(String userPieName, String userColor)
	{
		pieName = userPieName;
        sliceStorage = new ArrayList<>();
        color = userColor;
	}

	// "Get" Methods: 
	public String getPieName()
	{
		return pieName;
	}

	public String getColor()
	{
		return color;
	}
    /* Variables:
	 * 	Name (string)
	 * 	Storage of Slices: (Array VS Heap VS Tree)
	 * 		- Must be easily edited
	 * 		- Order must be easily rearranged
	 * 		- Should be able to contain a minimum of 30 pie slices
	 * 		- Pie class should be both save-able, ideally in a compressed format
	 * 		- Should be able to take on "template" files to be created
	 */
		
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