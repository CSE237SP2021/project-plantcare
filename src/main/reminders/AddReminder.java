package main.reminders;

import java.util.HashMap;

import main.Feature;
import main.Plant;
import main.Menu;


public class AddReminder implements Feature {

	public AddReminder(HashMap<Plant, Reminder> reminders) {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		Menu menu = new Menu();
		System.out.println("Which of these plants would you like to create a reminder for?");
		for (int i = 0; i < menu.getMyPlants().size(); i++) {
			System.out.println(menu.getMyPlants().get(i).toString());
		}
		// TODO Auto-generated method stub
		
	}

}
