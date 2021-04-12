package main.trackPlants;

import java.util.Scanner;

import main.Feature;
import main.Menu;

public class DisplayPlant implements Feature{
	private Menu menu;
	public DisplayPlant(Menu menu) {
		this.menu = menu;
	}
	
	// Get label to appear in menu 
	public String getLabel() {
		return "Display the information of owned plants";
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
		System.out.println("Type the name of the plant you want to view (type ALL if you want to view all of them)");
		String nameInput = scanner.nextLine();
		boolean validName = false;
		//check if the name exist
		for (int i = 0; i < menu.getMyPlants().size(); i++) {
			if (nameInput == menu.getMyPlants().get(i).plantName) {
				System.out.println(menu.getMyPlants().get(i).toString());
				validName = true;
			}
		}
		if(nameInput == "all" || nameInput == "All" || nameInput == "ALL") {
			for (int i = 0; i < menu.getMyPlants().size(); i++) {
				System.out.println(menu.getMyPlants().get(i).toString());
			}
			validName = true;
		} 
		if(validName = false){
			System.out.println("You don't have a plant with this name.");
		}
		menu.makeSelectionLoop();
	}
}
