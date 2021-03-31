package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private boolean exit;
	private List<Feature> features;
	private Scanner inputScanner = new Scanner(System.in);
	
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
			int userInput = inputScanner.nextInt();
			while (userInput < 0 || userInput > features.size()) {
				System.out.println("Invalid menu number. Try again (Type menu number)");
				userInput = inputScanner.nextInt();
			}
			
			if(userInput == 0)
				exit = true;
			else if(userInput >= 1 && userInput <= features.size())
				features.get(userInput-1).run();
			
		}
		
	}
	
	public Scanner getScanner() {
		return this.inputScanner;
	}
}
