package main.reminders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import main.Feature;
import main.Plant;
import main.Menu;


public class AddReminder implements Feature {
	private String remindersPath = "./src/main/reminders/Reminders.csv";
	public AddReminder() {
	}

	@Override
	public String getLabel() {
		return "Create a Reminder";
	}

	@Override
	public void run() {
		Menu menu = new Menu();
		System.out.println("Which of these plants would you like to create a reminder for? Please type the number of the plant to proceed");
		if (menu.getMyPlants() != null) {
		for (int i = 0; i < menu.getMyPlants().size(); i++) {
			System.out.println(menu.getMyPlants().get(i).toString());
		}
		Scanner scanner = menu.getScanner();
		int plantNumber = scanner.nextInt();
		Reminder newReminder = new Reminder(menu.getMyPlants().get(plantNumber).getWaterPeriod(), LocalDate.now().toString());
		File reminders = new File(remindersPath);
		try {
			FileWriter writer = new FileWriter(reminders);
			writer = new FileWriter(reminders, true);
			String newLine = String.format(menu.getMyPlants().get(plantNumber).getPlantName(), LocalDate.now().toString(), newReminder.getNextDate(), newReminder.getWateringInterval());
			writer.append(newLine);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		}
		else {
			System.out.println("I'm sorry, but you don't seem to have any plants registered. In order to create a reminder please return to the main menu and register a plant.");
		}
	}

}
