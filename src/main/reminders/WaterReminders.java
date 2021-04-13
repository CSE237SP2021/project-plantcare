package main.reminders;
import main.Feature;
import main.Menu;
import main.Plant;
import main.plantInfo.InfoByCareLevel;
import main.plantInfo.ShowAllInfo;

import java.util.HashMap;
import java.util.*;

public class WaterReminders implements Feature{
//stores, displays, creates and deletes reminders to water your plants
	public HashMap<Plant, Reminder> reminders;
	
	public WaterReminders(){
		reminders = new HashMap<Plant, Reminder>();
	}
	
	public void addReminder(HashMap<Plant, Reminder>) {
		System.out.print("What date will you start watering this plant? (Please use the format YYYY-MM-DD)");
		Scanner sc = new Scanner(System.in);
		String startDate = sc.nextLine();
		System.out.println("How often (in # of days) will you need to water the plant?");
		int wateringInterval = sc.nextInt();
		Reminder newReminder = new Reminder(wateringInterval, startDate);
		//TODO add system to track either the plant or the username or both with the reminder
		reminders.put(null, newReminder);
	}
	
	public void deleteReminder() {
		//TODO fix after you add the system to track which user/which plant the reminder is attached to
	}
	
	public String displayReminders() {
		//TODO add way to display all reminders for a specific user
		return "fix later";
	}

	@Override
	public String getLabel() {
		return "Watering Schedule";
	}

	@Override
	public void run() {
		Menu menu = new Menu();
		menu.addFeature(new AddReminder(reminders));
		menu.addFeature();
		
		menu.makeSelectionLoop();
	}
}
