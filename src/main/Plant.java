package main;

//This class define a special plant object. The plantSpecies might change to other type to better interact with other classes and help determined the features of the owned plant.

public class Plant {
	public String plantName;
	private String plantSpecies;
	private int plantAge;
	private int waterPeriod;
	private	String matureSize;
	private int careDifficulty;
	private String soilType;
	private String bloomTime;
	private String sunLevel;
	
	
	public Plant(String name) {
		
	}
	
	public Plant(String name, String species, String matureSize, int difficulty, String sunLevel, String soilType, String bloomTime) {
		plantName = name;
		plantSpecies = species;
		this.matureSize = matureSize;
		careDifficulty = difficulty;
		this.sunLevel = sunLevel;
		this.soilType = soilType;
		this.bloomTime = bloomTime;
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
	
	
	public int getWaterPeriod() {
		return waterPeriod;
	}
	
	
	//return desired water period based on the species
	public int findPeriod(String species) {
		//TODO Create system for determining desired watering period
		return 0;
	}
	
	public boolean equals(Plant otherPlant) {
		return this.plantName == otherPlant.plantName;
	}
	
	
	//display information of the plant
	public String toString() {
		return String.format("%s(%s): Difficulty Level %d\nIt grows best in %s lighting with %s soil. \n",
				plantName, plantSpecies, careDifficulty, sunLevel, soilType);
	}

	
	public int getCareDifficulty() {
		return careDifficulty;
	}

	
	public String getMatureSize() {
		return matureSize;
	}


	public String getSoilType() {
		return soilType;
	}


	public String getBloomTime() {
		return bloomTime;
	}


	public String getSunLevel() {
		return sunLevel;
	}
}
