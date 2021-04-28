package main.reminders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import main.Feature;
import main.Plant;
import main.trackPlants.TrackPlants;
import main.Menu;


public class AddReminder implements Feature {

	private WaterReminders WaterReminders;
	public AddReminder(WaterReminders WaterReminders) {
		this.WaterReminders = WaterReminders;
	}

	@Override
	public String getLabel() {
		return "Create a Reminder";
	}

	@Override
	public void run() {
		TrackPlants plantTracker = new TrackPlants();
		if (plantTracker.getNumPlants() != 0) {
			for (int i = 0; i < plantTracker.getNumPlants(); i++) {
				System.out.println(i + ": "+ plantTracker.getPlant(i).getPlantName());
			}
			Scanner scanner = new Scanner(System.in);
			// TODO Fix for unexpected inputs (non-integer and out of bounds)
			System.out.println("Which of these plants would you like to create a reminder for? Please type the number of the plant to proceed");
			int plantNumber = scanner.nextInt();
			
			int waterPeriod = plantTracker.getPlant(plantNumber).getWaterPeriod();
			System.out.println("Would you like to set a custom watering period for this plant? (Y/n)");
			String autoChoice = scanner.nextLine();
			if(autoChoice.toLowerCase().equals("y")){
				System.out.println("How often would you like to water this plant? (Number of days)");
				while(!scanner.hasNextInt()) {
					System.out.println("Invalid watering period. Try again");
				}
				waterPeriod = scanner.nextInt();
			}
			Reminder newReminder = new Reminder(plantTracker.getPlant(plantNumber).getPlantName(), waterPeriod, LocalDate.now().toString());
			WaterReminders.addReminder(newReminder);
		}
		else {
			System.out.println("I'm sorry, but you don't seem to have any plants registered. In order to create a reminder please return to the main menu and register a plant.");
		}
	}

}
