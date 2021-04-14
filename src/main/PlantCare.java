package main;
import main.plantInfo.*;
import main.reminders.*;
import main.trackPlants.TrackPlants;


/* TODO Possibly use this to restructure such that tracking abilities of the corresponding classes can be shared in a clearer way;
 * Remove need to create new instances of PlantInformation, WaterReminders, TrackPlants, etc. in order to access saved data more effectively
 * 
 * In doing above:
 * Change file modification protocols to read in data (csv --> datastructures) during setup, 
 * only make modifications to structures during runtime,
 * then rewrite runtime data on close/failure (datastructures --> csv)
 */

public class PlantCare {
	/* Application Entry Point
	 * Acts as main menu for GUI
	*/
	public static void main(String[] args) {
		// Show welcome message
		System.out.println("Welcome to Plant Care! The app for all of your house plant needs!");
		
		// Initialize menu
		Menu mainMenu = new Menu();
		
		// Add available features
		mainMenu.addFeature(new PlantInformation());
		mainMenu.addFeature(new WaterReminders());
		mainMenu.addFeature(new TrackPlants());
		
		
		
		
		// Show menu
		mainMenu.makeSelectionLoop();

	}

}
