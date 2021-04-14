package main.trackPlants;

import java.util.Scanner;

import main.Feature;
import main.Menu;

public class DisplayPlant implements Feature{
	
	// TODO: INTEGRATE WITH TRACK PLANTS 
	
	private TrackPlants tracker;
	public DisplayPlant(TrackPlants trackPlants) {
		tracker = trackPlants;
	}
	
	// Get label to appear in menu 
	public String getLabel() {
		return "Display the information of owned plants";
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
		System.out.println("Type the name of the plant you want to view (type ALL if you want to view all of them)");
		String nameInput = scanner.nextLine();
		boolean validName = false;
		while(!validName) {
			if(nameInput.toLowerCase().equals("all")) {
				for (int i = 0; i < tracker.getNumPlants(); i++) {
					tracker.displayPlant(i);
				}
				validName = true;
				System.out.println("Aboved are all plants you own.");
			} 
			for (int i = 0; i < tracker.getNumPlants(); i++) {
				if (nameInput.equals(tracker.getPlant(i).getPlantName())) {
					tracker.displayPlant(i);
					validName = true;
					break;
				}
			}
			if(validName = false){
				System.out.println("You don't have a plant with this name.");
			}
		}
		
		
	}	
}
