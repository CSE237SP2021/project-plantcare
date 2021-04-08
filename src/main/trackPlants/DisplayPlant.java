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
		return "Display the information of an owned plant";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = menu.getScanner();
		System.out.println("Tell us the name of the plant you want to view");
		String nameInput = scanner.nextLine();
		//TODO: check if the name exist
		if(nameInput == "") {
			//TODO: loop find index through name;
			System.out.println(menu.getMyPlants().get(0).toString());
		}else {
			System.out.println("You don't have a plant with this name.");
		}
	}
}
