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
	public HashMap<String, Integer> careLevel;
	public HashMap<String, Integer> lightLevel;
	public HashMap<String, String> location;
	
	public UserInfo() {
		userName = new ArrayList<String>();
		careLevel = new HashMap<String, Integer>();
		lightLevel = new HashMap<String, Integer>();
		location = new HashMap<String, String>();
		
		// TODO ESTABLISH STORAGE FORMAT FOR USER INFO
		File list = new File(infoPath);

		try {
			if(list.createNewFile()) {
				FileWriter writer = new FileWriter(list);
				writer.append("Username, Carelevel, Lightlevel, Location (Days)\n");
				writer.close();
			}
			else 
				userName = readPlantList(infoPath);
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
	
	public Integer getCare(int i) {
		String user =  getUser(i);
		int care =  careLevel.get(user);
		return care;
	}
	
	public Integer getLight(int i) {
		String user =  getUser(i);
		int light = lightLevel.get(user);
		return light;
	}
	public String getLoc(int i) {
		String user =  getUser(i);
		String loc = location.get(user);
		return loc;
	}
	
	public ArrayList<String> readPlantList(String infoPath) {
		ArrayList<String> userList = new ArrayList<String>();
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(infoPath));  
			String line = br.readLine(); // skip label row  
			while ((line = br.readLine()) != null) {  	
				String[] splitInfo = line.split(",");    // use comma as separator  
				userList.add(splitInfo[0]);
				int care = Integer.parseInt(splitInfo[1]);
				AddCare(splitInfo[0], care);
				int light = Integer.parseInt(splitInfo[2]);
				AddLight(splitInfo[0], light);
				String loc = splitInfo[3];
				AddLoc(splitInfo[0], loc);
			}
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}
		return userList;   
	}	
	
	public void AddUser(String name) {
		userName.add(name);
	}
	
	public void AddCare(String name, int care) {
		careLevel.put(name, care);
	}
	public void AddLight(String name, int light) {
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

		//menu.addFeature(new DisplayUser(this));
		// TODO Fix displayUser for proper constructor

		menu.makeSelectionLoop();
		// TODO Auto-generated method stub
		
	}
	
}
