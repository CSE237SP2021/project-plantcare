package main;
import plantInformation.PlantInformation;

public class PlantCare {

	/*
	 * 
	 * Application Entry Point
	*/
	public static void main(String[] args) {
		// Show welcome message
		System.out.println("Welcome to Plant Care! The app for all of your house plant needs!");
		
		// Initialize menu
		Menu mainMenu = new Menu();
		
		// Add available features
		mainMenu.addFeature(new PlantInformation());
		
		
		
		
		
		// Show menu
		mainMenu.makeSelectionLoop();

	}

}
