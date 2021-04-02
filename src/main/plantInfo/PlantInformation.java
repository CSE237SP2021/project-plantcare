package main.plantInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;

public class PlantInformation implements Feature {
	static String infoPath = "./src/main/plantInfo/plantInformation.csv";
	private ArrayList<Plant> plants;
	
	public PlantInformation() {
		plants = new ArrayList<Plant>();
		readPlantInformation(infoPath);
	}
	
	public void addPlant(Plant newPlant) {
		plants.add(newPlant);
	}
	//Parse csv file at infoPath and create plant objects for each
	private void readPlantInformation(String infoPath) {
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(infoPath));  
			String line = br.readLine(); // skip label row  
			while ((line = br.readLine()) != null) {  
				String[] splitInfo = line.split(",");    // use comma as separator  
				Plant newPlant = new Plant(
						splitInfo[0], 
						splitInfo[1],
						splitInfo[2],
						Integer.parseInt(splitInfo[3]),
						splitInfo[4],
						splitInfo[5],
						splitInfo[6]
						);
				addPlant(newPlant);
			}  
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}   
	}

	public String getLabel() {
		return "Plant Information";
	}
	
	public void run() {
		// LINK TO Plant information https://www.plantssparkjoy.com/common-house-plants/
		System.out.println("(" + getNumPlants() + " known plants)");
		
		Menu menu = new Menu();
		menu.addFeature(new ShowAllInfo(plants));
		menu.addFeature(new InfoByCareLevel(plants));
		
		menu.makeSelectionLoop();
	}
	
	public int getNumPlants() {
		return plants.size();
	}
	
	public ArrayList<Plant> getPlantList(){
		return plants;
	}

}

