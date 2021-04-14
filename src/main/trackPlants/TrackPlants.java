package main.trackPlants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.Feature;
import main.Menu;
import main.Plant;

public class TrackPlants implements Feature {

	private ArrayList<Plant> plantList;
	private String listPath = "./src/main/trackPlants/myPlants.csv"; 
	
	public TrackPlants(){
		File list = new File(listPath);
		try {
			if(list.createNewFile()) {
				FileWriter writer = new FileWriter(list);
				writer.append("Name,Species,Start Date,Watering Period (Days)\n");
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plantList = new ArrayList<Plant>();
		
	}
	
	@Override
	public String getLabel() {
		return "My Plants";
	}

	@Override
	public void run() {
		Menu trackingMenu = new Menu();
		plantList = readPlantList(listPath);
		// Restructure plant tracking features for easier tracking
		trackingMenu.addFeature(new DisplayPlant(this));
		trackingMenu.addFeature(new AddPlant(this));
		trackingMenu.addFeature(new DeletePlant(this));
		
		trackingMenu.makeSelectionLoop();
		
	}
	
	public ArrayList<Plant> readPlantList(String listPath) {
		ArrayList<Plant> plantList = new ArrayList<Plant>();
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(listPath));  
			String line = br.readLine(); // skip label row  
			while ((line = br.readLine()) != null) {  
				String[] splitInfo = line.split(",");    // use comma as separator  
				Plant newPlant = new Plant(
						splitInfo[0], 
						splitInfo[1],
						splitInfo[2],
						Integer.parseInt(splitInfo[3])
						);
				plantList.add(newPlant);
			}
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}
		return plantList;   
	}

	public void setPlantList(ArrayList<Plant> list) {
		plantList = list;
	}

	public int getNumPlants() {
		return plantList.size();
	}

	public Plant getPlant(int index) {
		return plantList.get(index);
	}

	
	// Add plant to both arraylist and csv
	public void addPlant(Plant newPlant) {
		if(isRepeat(newPlant))
			return;
		
		plantList.add(newPlant);
		File list = new File(listPath);
		FileWriter writer;
		try {
			writer = new FileWriter(list, true);
			String newLine = String.format("\n%s,%s,%s,%d", newPlant.getPlantName(), newPlant.getPlantSpecies(), newPlant.getStartDate(), newPlant.getWaterPeriod());
			writer.append(newLine);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletePlant(int index) {
		plantList.remove(index);
		
		// remove line
	}

	private boolean isRepeat(Plant newPlant) {
		for(Plant p: plantList) {
			if(p.getPlantName().equals(newPlant.getPlantName()))
				return true;
		}
		return false;
	}

}
