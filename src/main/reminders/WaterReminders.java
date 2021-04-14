package main.reminders;
import main.Feature;
import main.Menu;
import main.Plant;

import java.util.HashMap;
import java.util.*;
import java.time.LocalDate;

public class WaterReminders implements Feature{
//stores, displays, creates and deletes reminders to water your plants
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
		waterMenu.addFeature(new AddReminder());
		//waterMenu.addFeature(new DeleteReminder());
		
		waterMenu.makeSelectionLoop();
	}
}
