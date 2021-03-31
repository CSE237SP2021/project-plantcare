package main.plantInfo;
import main.Feature;
import main.Menu;

public class PlantInformation implements Feature {
	
	public PlantInformation() {}
	
	public String getLabel() {
		return "Plant Information";
	}
	
	public void run() {
		// LINK TO Plant information https://www.plantssparkjoy.com/common-house-plants/
		
		System.out.println("Showing plant information...");
		
		Menu menu = new Menu();
		menu.addFeature(new ShowAllInfo());
		menu.addFeature(new SearchByName());
		menu.addFeature(new SearchByCareLevel());
		
		menu.makeSelectionLoop();
	}

}

