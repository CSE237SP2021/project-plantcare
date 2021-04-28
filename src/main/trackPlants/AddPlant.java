package main.trackPlants;

import java.time.LocalDate;
import java.util.ArrayList;

import main.Feature;
import main.Menu;
import main.Plant;
import java.util.Scanner;

import main.plantInfo.InfoByCareLevel;
import main.plantInfo.PlantInformation;
import main.plantInfo.ShowAllInfo;
import main.reminders.WaterReminders;


public class AddPlant implements Feature {

	private TrackPlants tracker;
	public AddPlant(TrackPlants tracker) {
		this.tracker = tracker;
	}
	
	// Get label to appear in menu 
	public String getLabel() {
		return "Add an new plant";
	}
		
	// add a trackable plant 
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tell us the species of your new plant (Type ? to show available species):");
		String speciesInput = scanner.nextLine();
		PlantInformation plantInfo = new PlantInformation();
		ArrayList<Plant> plantDictionary = plantInfo.getPlantList();
		boolean speciesValid = false;
		//match the input with available species
		while(!speciesValid) {
			int invalidSpeciesCount = 0;
			if(speciesInput.equals("?")) {
				System.out.println("Available Species:");
				for(Plant p: plantDictionary) {
					System.out.println(p.getPlantSpecies());
				}
				System.out.println();
				System.out.println("Tell us the species of your new plant (Type ? to show available species):");
				speciesInput = scanner.nextLine();
			}
			else {
				/* TODO Make functions in tracker for easier input validation: validSpecies, validName
				 * 		Allow for certain words to be passed in for additional exclusion, to be used for name validation
				*/
				for(int i = 0; i < plantDictionary.size(); i++) {
					// Check if species is valid
					if (plantDictionary.get(i).getPlantSpecies().equals(speciesInput)) {
						speciesValid = true;
						System.out.println("Please name your plant");
						String nameInput = scanner.nextLine();
						// The word all used in if condition of delete plant/display plant, prevent user use name like this 
						boolean repeatName = true;
						while(nameInput.toLowerCase().equals("all") || repeatName) {
							if(nameInput.toLowerCase().equals("all")) {
								System.out.println("Sorry, this word is a sensitive term for our program. Please try another name.");
								nameInput = scanner.nextLine();
							}
							for (int j = 0; j < tracker.getNumPlants(); j++) {
								if (nameInput.equals(tracker.getPlant(j).plantName)) {
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
					System.out.println("Invalid species.");
					System.out.println("Tell us the species of your new plant (Type ? to show available species):");
					speciesInput = scanner.nextLine();
				}
			}
		}
		
	}

		
}

