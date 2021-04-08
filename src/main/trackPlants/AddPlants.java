package main.trackPlants;

import java.util.ArrayList;

import main.Feature;
import main.Plant;
import main.Menu;
import java.util.Scanner;
import main.plantInfo.PlantInformation;


public class AddPlants implements Feature {

	private Menu menu;
	public AddPlants(Menu menu) {
		this.menu = menu;
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Add an new plant";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = menu.getScanner();
		String userInput = scanner.nextLine();
		PlantInformation plantInfo = new PlantInformation();
		ArrayList<Plant> plantDictionary = plantInfo.getPlantList();
		System.out.println("Tell us the species of your new plant");
		//TODO: match the input with available species
		if(userInput == "") {
			System.out.println("Please name your plant");
			String nameInput = scanner.nextLine();
			// if (nameInput == "")
			// TODO : check if the name repeat
			menu.getMyPlants().add(new Plant(nameInput));
		}else {
			System.out.println("Invalid species. Please check plant information for available species.");
		}
	}
}
