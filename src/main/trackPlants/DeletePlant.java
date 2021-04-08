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
		System.out.println("Tell us the name of the plant you want to stop tracking");
		String nameInput = scanner.nextLine();
		//TODO: check if the name exist
		if(nameInput == "") {
			//TODO: loop find index through name;
			menu.getMyPlants().remove(0);
		}else {
			System.out.println("You don't have a plant with this name.");
		}
	}

}
