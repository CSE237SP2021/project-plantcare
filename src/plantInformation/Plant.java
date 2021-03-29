package plantInformation;
import main.Feature;
import main.Menu;

//This class define a special plant object. The plantSpecies might change to other type to better interact with other classes and help determined the features of the owned plant.

public class Plant {
	public String plantName;
	private String plantSpecies;
	private int plantAge;
	private int waterTrack;
	private int waterPeriod;
	private String owner;		
	
	public Plant(String name, String species, String owner, int age) {
		plantName = name;
		plantAge = age;
		plantSpecies = species;
		waterTrack = 0;
		waterPeriod = findPeriod(species);
		this.owner = owner;
	}
	
	public Plant(String name, String species, int age, int water) {
		plantName = name;
		plantAge = age;
		plantSpecies = species;
		waterTrack = water;
		waterPeriod = findPeriod(species);
		this.owner = owner;
	}
	
	
	public String getLabel() {
		return "Owned Plant";
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
	
	public String getPlantName() {
		return plantName;
	}
	
	
	public int getPlantAge() {
		return plantAge;
	}
	
	public String getPlantSpecies() {
		return plantSpecies;
	}
	
	
	public int getWaterTrack() {
		return waterTrack;
	}
	
	public int getWaterPeriod() {
		return waterPeriod;
	}
	
	public int getReverseWaterTrack() {
		return waterPeriod - waterTrack;
	}
	
	public String getOwner() {
		return owner;
	}
	
	//return desired water period based on the species
	public int findPeriod(String species) {
		return 0;
	}
	
	
	public void setPlantName(String newName) {
		plantName = newName;
	}
	
	public void setWaterTrack(int newWaterTrack) {
		plantAge = newWaterTrack;
	}
	
	public boolean equals(Plant otherPlant) {
		return this.plantName == otherPlant.plantName;
	}
	
	
	//display information of the plant
	public String toString() {
		return plantName + ": " + plantAge + "months old " + plantSpecies;
	}
}
