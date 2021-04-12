package main.trackPlants;

import java.util.ArrayList;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;


public class DeletePlant implements Feature{
	private Menu menu;
	public DeletePlant(Menu menu) {
		this.menu = menu;
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Stop tracking an owned plant";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = menu.getScanner();
		System.out.println("Below is the plants you owned:");
		System.out.println();
		for (int i = 0; i < menu.getMyPlants().size(); i++) {
			System.out.println(menu.getMyPlants().get(i).getPlantName());
		}
		System.out.println();
		System.out.println("Type the name of the plant you want to stop tracking (type ALL if you want to stop tracking all of them)");
		String nameInput = scanner.nextLine();
		boolean validName = false;
		//check if the name exist
		for (int i = 0; i < menu.getMyPlants().size(); i++) {
			if (nameInput == menu.getMyPlants().get(i).plantName) {
				menu.getMyPlants().remove(i);
				validName = true;
				System.out.println("Successfully delete plant.");
			}
		}
		if(nameInput == "all" || nameInput == "All" || nameInput == "ALL") {
			for (int i = 0; i < menu.getMyPlants().size(); i++) {
				menu.getMyPlants().remove(i);
			}
			validName = true;
			System.out.println("Successfully delete plant.");
		} 
		if(validName = false){
			System.out.println("You don't have a plant with this name.");
		}
		menu.makeSelectionLoop();
	}

}
