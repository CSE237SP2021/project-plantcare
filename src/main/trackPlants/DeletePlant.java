package main.trackPlants;

import java.util.ArrayList;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;


public class DeletePlant implements Feature{
	private TrackPlants tracker;
	public DeletePlant(TrackPlants trackPlants) {
		tracker = trackPlants;
	}
	
	// Get label to appear in menu 
	public String getLabel() {
		return "Stop tracking an owned plant";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Below is the plants you owned:");
		System.out.println();
		for (int i = 0; i < tracker.getNumPlants(); i++) {
			System.out.println(tracker.getPlant(i).getPlantName());
		}
		System.out.println();
		System.out.println("Type the name of the plant you want to stop tracking (type ALL if you want to stop tracking all of them)");
		String nameInput = scanner.nextLine();
		boolean validName = false;
		while(!validName) {
			if(nameInput.toLowerCase().equals("all")) {
				for (int i = 0; i < tracker.getNumPlants(); i++) {
					tracker.deletePlant(i);
				}
				validName = true;
				System.out.println("Successfully delete all plants.");
			} 
			for (int i = 0; i < tracker.getNumPlants(); i++) {
				if (nameInput.equals(tracker.getPlant(i).getPlantName())) {
					tracker.deletePlant(i);
					validName = true;
					System.out.println("Successfully delete plant.");
					break;
				}
			}
			if(validName = false){
				System.out.println("You don't have a plant with this name.");
			}
		}
	}

}
