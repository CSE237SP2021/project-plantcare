package reminders;

import main.Feature;

import java.util.*;

public class WaterReminders implements Feature {
//stores, displays, creates and deletes reminders to water your plants
//doesn't work with GUI yet
	public ArrayList<Reminder> reminders = new ArrayList<Reminder>();
	/**
	 * creates a reminder using user input and adds it to the arraylist of reminders
	 */
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
		reminders.add(newReminder);
	}
	
	public void deleteReminder() {
		//TODO fix after you add the system to track which plant the reminder is attached to
	}
	
	public void displayReminders() {
		for (int i = 0; i < reminders.size(); i++) {
			System.out.println(reminders.get(i).getNextDate());
		}
	}
	
	public ArrayList<Reminder> getArrayList() {
		return reminders;
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
