package main.trackPlants;

import java.time.LocalDate;
import java.util.ArrayList;

import main.Feature;
import main.Plant;
import java.util.Scanner;
import main.plantInfo.PlantInformation;


public class AddPlant implements Feature {

	private TrackPlants tracker;
	public AddPlant(TrackPlants tracker) {
		this.tracker = tracker;
	}
	
	// Get label to appear in menu 
	public String getLabel() {
		return "Add an new plant";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tell us the species of your new plant");
		String speciesInput = scanner.nextLine();
		PlantInformation plantInfo = new PlantInformation();
		ArrayList<Plant> plantDictionary = plantInfo.getPlantList();
		//match the input with available species
		int invalidSpeciesCount = 0;
		for(int i = 0; i < plantDictionary.size(); i++) {
			if (plantDictionary.get(i).getPlantSpecies() == speciesInput) {
				System.out.println("Please name your plant");
				String nameInput = scanner.nextLine();
				// The word ¡°all¡± used in if condition of delete plant/display plant, prevent user use name like this 
				boolean repeatName = true;
				while(nameInput.toLowerCase() == "all" || repeatName) {
					if(nameInput.toLowerCase() == "all") {
						System.out.println("Sorry, this word is a sensitive term for our program. Please try another name.");
						nameInput = scanner.nextLine();
					}
					for (int j = 0; j < tracker.getNumPlants(); j++) {
						if (nameInput == tracker.getPlant(j).plantName) {
							System.out.println("You already have a plant with this name, please try an new name.");
							nameInput = scanner.nextLine();
							break;
						}
						if(j == tracker.getNumPlants()-1)
							repeatName = false;
					}	
				}
				
				Plant newPlant = new Plant(nameInput, speciesInput, LocalDate.now().toString(), plantDictionary.get(i).findPeriod());
				tracker.addPlant(newPlant);
			}else {
				invalidSpeciesCount++;			
			}
		}
		
		if(invalidSpeciesCount == plantDictionary.size()) {
			System.out.println("Invalid species. Please check plant information for available species.");
		}
		
		
	}

		
}

