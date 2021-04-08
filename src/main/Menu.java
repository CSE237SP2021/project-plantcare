package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private boolean exit;
	private List<Feature> features;
	private Scanner inputScanner = new Scanner(System.in);
	private ArrayList<Plant> myPlants;
	
	public Menu() {
		features = new ArrayList<Feature>();
		exit = false;
	}
	
	public void addFeature(Feature f) {
		features.add(f);
	}
	
	public boolean deleteFeature(Feature f) {
		return features.remove(f);
	}
	
	/*
	 * Shows available features and asks for selection. Selected feature is run.
	 * Continues to show selections and ask for input until exit is set.
	 */
	public void makeSelectionLoop() {
		while(!exit) {
			System.out.println("0. Exit");
			for(int i = 0; i < features.size(); i++) {
				System.out.print(i+1);
				System.out.println(". " + features.get(i).getLabel());
			}
			System.out.println();
			
			System.out.println("What would you like to do? (Type menu number)");
			
			String userInput = inputScanner.next();
			while (!isNumeric(userInput) || Integer.parseInt(userInput) < 0 || Integer.parseInt(userInput) > features.size()) {
				System.out.println("Invalid menu number. Try again (Type menu number)");
				userInput = inputScanner.next();
			}
			
			int menuChoice = Integer.parseInt(userInput);
			if(menuChoice == 0)
				exit = true;
			else if(menuChoice >= 1 && menuChoice <= features.size())
				features.get(menuChoice-1).run();
			
		}
		
	}
	
	public Scanner getScanner() {
		return this.inputScanner;
	}
	
	public ArrayList<Plant> getMyPlants(){
		return myPlants;
	}
	
	private boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
}
