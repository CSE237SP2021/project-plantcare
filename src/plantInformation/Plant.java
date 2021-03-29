package plantInformation;

public class Plant {
	public String plantName;
	private String plantSpecies;
	private int plantAge;
	private int waterTrack;
	private int waterPeriod;
	
	
	
	public Plant(String name, String species, int age) {
		plantName = name;
		plantAge = age;
		plantSpecies = species;
		waterTrack = 0;
		waterPeriod = findPeriod(species);
	}
	
	public Plant(String name, String species, int age, int water) {
		plantName = name;
		plantAge = age;
		plantSpecies = species;
		waterTrack = water;
		waterPeriod = findPeriod(species);
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
	
	public int findPeriod(String species) {
		return 0;
	}
	
	public int findPhase(String species, int age) {
		return 0;
	}
	
	public int findAge(String species, int phase) {
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
	
	
	
	public String toString() {
		return plantName + ": " + plantAge + "months old " + plantSpecies;
	}
}
