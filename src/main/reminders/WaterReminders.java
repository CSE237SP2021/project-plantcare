package main.reminders;
import main.Feature;
import main.Menu;
import main.Plant;

import java.util.HashMap;
import java.util.*;
import java.time.LocalDate;

public class WaterReminders implements Feature{
	/*
	 * Acts as tracker for reminder information, read in from Reminders.csv
	 * stores, displays, creates and deletes reminders to water your plants
	 */
	
	public HashMap<Plant, Reminder> reminders;
	
	public WaterReminders(){
		reminders = new HashMap<Plant, Reminder>();
	}

	@Override
	public String getLabel() {
		return "Watering Schedule";
	}
	
	@Override
	public void run() {
		Menu waterMenu = new Menu();
		
		/*
		 * Features of waterMenu should have WaterReminders class (this) passed as arguments to act as tracker
		 * Look at trackPlants classes for format
		 */
		
		waterMenu.addFeature(new AddReminder());
		//waterMenu.addFeature(new DeleteReminder());
		//waterMenu.addFeature(new ShowReminders()); //show next watering reminder
		
		
		
		waterMenu.makeSelectionLoop();
	}
	
	
}
