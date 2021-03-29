package reminders;

import java.util.HashMap;

import main.Feature;

import java.util.*;

public class WaterReminders implements Feature {
//stores, displays, creates and deletes reminders to water your plants
	public HashMap<String, Reminder> reminders;
	
	public void addReminder() {
		System.out.print("What date will you start watering this plant? (Please use the format YYYY-MM-DD)");
		Scanner scannerStartDate = new Scanner(System.in);
		String startDate = scannerStartDate.nextLine();
		scannerStartDate.close();
		System.out.print("How often (in # of days) will you need to water the plant?");
		Scanner scannerWateringInterval = new Scanner(System.in);
		int wateringInterval = scannerWateringInterval.nextInt();
		scannerWateringInterval.close();
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
		return "Reminders";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
