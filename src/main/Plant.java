package main;

import java.time.temporal.*;
import java.time.LocalDate;

//This class define a special plant object. The plantSpecies might change to other type to better interact with other classes and help determined the features of the owned plant. 

public class Plant {
	public String plantName;
	private String plantSpecies;
	private LocalDate startDate;
	private int waterPeriod;
	private	String matureSize;
	private int careDifficulty;
	private String soilType;
	private String bloomTime;
	private String sunLevel;
	
	
	public Plant(String name) {
		
	}
	
	
	// Constructor for use in trackPlants
	public Plant(String name, String species, String startDate, int waterPeriod) {
		plantName = name;
		plantSpecies = species;
		this.startDate = LocalDate.parse(startDate);
		this.waterPeriod = waterPeriod;
	}
	
	// Constructor for use in plantInfo
	public Plant(String name, String species, String matureSize, int difficulty, String sunLevel, String soilType, String bloomTime) {
		plantName = name;
		plantSpecies = species;
		this.matureSize = matureSize;
		careDifficulty = difficulty;
		this.sunLevel = sunLevel;
		this.soilType = soilType;
		this.bloomTime = bloomTime;
		waterPeriod = findPeriod();
	}
	
	// copy the Characteristics of another plant except name
	public void makeCopy(Plant otherPlant) {
		plantSpecies = otherPlant.getPlantSpecies();
		this.matureSize = otherPlant.getMatureSize();
		careDifficulty = otherPlant.getCareDifficulty();
		this.sunLevel = otherPlant.getSunLevel();
		this.soilType = otherPlant.getSoilType();
		this.bloomTime = otherPlant.getBloomTime();
	}
	
	
	public String getPlantName() {
		return plantName;
	}
	
	
	public int getPlantAge() {
		long longAge = startDate.until(LocalDate.now(), ChronoUnit.DAYS);
		return (int) longAge;
	}
	
	public String getPlantSpecies() {
		return plantSpecies;
	}
	
	
	public int getWaterPeriod() {
		return waterPeriod;
	}
	
	public String getStartDate() {
		return startDate.toString();
	}
	
	
	//return desired water period based on the species
	public int findPeriod() {
		//TODO Create system for determining desired watering period
		return 7;
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
	
	public void setName(String newName) {
		plantName = newName;
	}
}
