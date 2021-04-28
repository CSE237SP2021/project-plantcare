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
	

	
	//The plant tracker stores user's owned plant information in a csv file.
	public TrackPlants(){
		plantList = new ArrayList<Plant>();
		
		File list = new File(listPath);
		try {
			if(list.createNewFile()) {
				FileWriter writer = new FileWriter(list);
				writer.append("Name,Species,Start Date,Watering Period (Days)\n");
				writer.close();
			}
			else 
				plantList = readPlantList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getLabel() {
		return "My Plants";
	}

	@Override
	public void run() {
		Menu trackingMenu = new Menu();
		plantList = readPlantList();
    
		// Restructure plant tracking features for easier tracking
		trackingMenu.addFeature(new DisplayPlant(this));
		trackingMenu.addFeature(new AddPlant(this));
		trackingMenu.addFeature(new DeletePlant(this));
		
		trackingMenu.makeSelectionLoop();
		
	}
	
	public ArrayList<Plant> readPlantList() {
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

	// Rewrites values of the csv file at listPath to the corresponding vales in plantList
	// Reverse action of readPlantList
	private void updateCSV() {
		File list = new File(listPath);
		try {
			FileWriter writer = new FileWriter(list);
			writer.append("Name,Species,Start Date,Watering Period (Days)\n");
			for(Plant plant: plantList) {
				writer.append(
						String.format(
								"%s,%s,%s,%d\n",
								plant.getPlantName(),
								plant.getPlantSpecies(),
								plant.getStartDate(),
								plant.getWaterPeriod()));
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
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

	//
	// Functions for other classes
  //
 
	// Add plant to both arraylist and csv
	public void addPlant(Plant newPlant) {
		if(isRepeat(newPlant))
			return;
		
		plantList.add(newPlant);
		updateCSV();
		
	}
	
	// Removes plant from plantList and values stored in the csv file
	public void deletePlant(int index) {
		plantList.remove(index);
	
		// rewrite csv
		updateCSV();
	}



	public void displayPlant(int index) {
		System.out.println(plantList.get(index).toString());
		
	}

	private boolean isRepeat(Plant newPlant) {
		for(Plant p: plantList) {
			if(p.getPlantName().equals(newPlant.getPlantName()))
				return true;
		}
		return false;
	}
	
	public void setListPath(String path) {
		listPath = path;
	}

}
