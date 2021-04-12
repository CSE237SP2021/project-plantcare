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
		System.out.println("Tell us the species of your new plant");
		String userInput = scanner.nextLine();
		PlantInformation plantInfo = new PlantInformation();
		ArrayList<Plant> plantDictionary = plantInfo.getPlantList();
		//match the input with available species
		int invalidSpeciesCount = 0;
		for(int i = 0; i < plantDictionary.size(); i++) {
			if (plantDictionary.get(i).getPlantSpecies() == userInput) {
				System.out.println("Please name your plant");
				String nameInput = scanner.nextLine();
				// The word ¡°all¡± used in if condition of delete plant/display plant, prevent user use name like this 
				if(nameInput == "all" || nameInput == "All" || nameInput == "ALL") {
					System.out.println("Sorry, this word is a sensitive term for our program. Please try another name.");
				}
				// check if the name repeat
				for (int j = 0; j < menu.getMyPlants().size(); j++) {
					if (nameInput == menu.getMyPlants().get(j).plantName) {
						System.out.println("You already have a plant with this name, please try an new name.");
						nameInput = scanner.nextLine();
						j = 0;
					}
				}
				Plant newPlant = new Plant(nameInput);
				newPlant.makeCopy(plantDictionary.get(i));
				menu.getMyPlants().add(newPlant);
			}else {
				invalidSpeciesCount++;			
			}
		}
		
		if(invalidSpeciesCount == plantDictionary.size()) {
			System.out.println("Invalid species. Please check plant information for available species.");
		}
		
		System.out.println("Successfully add plant.");
		
		menu.makeSelectionLoop();
		
	}

		
}

