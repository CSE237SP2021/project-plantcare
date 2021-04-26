package main.userInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;
import main.plantInfo.InfoByCareLevel;
import main.plantInfo.ShowAllInfo;

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
		
	}
	
	public String getUser(int i) {
		return userName.get(i);
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
	
	public String toString(String u) {
		
		return
		
	}
	
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
		System.out.println("(" + getNumPlants() + " known plants)");
		
		Menu menu = new Menu();
		menu.addFeature(new ShowAllInfo(plants));
		menu.addFeature(new InfoByCareLevel(plants));
		
		menu.makeSelectionLoop();
		// TODO Auto-generated method stub
		
	}
	
}
