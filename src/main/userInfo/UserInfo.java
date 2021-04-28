package main.userInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;
import main.plantInfo.InfoByCareLevel;
import main.plantInfo.ShowAllInfo;
import main.trackPlants.AddPlant;
import main.trackPlants.DeletePlant;
import main.trackPlants.DisplayPlant;

//TODO Implement Feature interface and integrate iteraction with other classes as well as GUI.

public class UserInfo implements Feature {
//	Option to collect and store information about user: desired plant care level, light level, location, etc
	
	
	static String infoPath = "./src/main/plantInfo/userinformation.csv";
	public ArrayList<String> userName;
	
	
	public HashMap<String, String> careLevel;
	public HashMap<String, String> lightLevel;
	public HashMap<String, String> location;
	
	public UserInfo() {
		userName = new ArrayList<String>();
		careLevel = new HashMap<String, String>();
		lightLevel = new HashMap<String, String>();
		location = new HashMap<String, String>();
		
	
		File list = new File(infoPath);
		try {
			if(list.createNewFile()) {
				FileWriter writer = new FileWriter(list);
				writer.append("Name,Species,Start Date,Watering Period (Days)\n");
				writer.close();
			}
			else 
				plantList = readPlantList(infoPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getUser(int i) {
		return userName.get(i);
	}
	
	public ArrayList<String> getAllUsers() {
		return userName;
	}
	
	public Integer getNumUsers() {
		return userName.size();
	}
	
	
	public String getCare(int i) {
		String user =  getUser(i);
		String care =  careLevel.get(user);
		return care;
	}
	
	public String getLight(int i) {
		String user =  getUser(i);
		String light = lightLevel.get(user);
		return light;
	}
	public String getLoc(int i) {
		String user =  getUser(i);
		String loc = location.get(user);
		return loc;
	}
	
	/*
	public String toString(String u) {
		
		return
		
	}
	
	public ArrayList<Plant> readPlantList(String infoPath) {
		ArrayList<Plant> plantList = new ArrayList<Plant>();
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(listPath));  
			String line = br.readLine(); // skip label row  
			while ((line = br.readLine()) != null) {  
				String[] splitInfo = line.split(",");    // use comma as separator  
				/*Plant newPlant = new Plant(
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
	
	*/
	
	public void AddUser(String name) {
		userName.add(name);
	}
	
	public void AddCare(String name, String care) {
		careLevel.put(name, care);
	}
	public void AddLight(String name, String light) {
		lightLevel.put(name, light);
	}
	
	public void AddLoc(String name, String loc) {
		location.put(name, loc);
	}
	
	public void DeleteUser(String name) {
		userName.remove(name);
		careLevel.remove(name);
		lightLevel.remove(name);
		location.remove(name);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "User Information";
	}

	@Override
	public void run() {
		System.out.println("(" + getNumUsers() + " known plants)");
		
		Menu menu = new Menu();
		
		menu.addFeature(new AddUser(this));
		menu.addFeature(new DeleteUser(this));
		menu.addFeature(new DisplayUser(this));
		
		menu.makeSelectionLoop();
		// TODO Auto-generated method stub
		
	}
	
}
