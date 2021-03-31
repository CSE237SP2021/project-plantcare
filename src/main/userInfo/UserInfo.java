package main.userInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class UserInfo {

//	Option to collect and store information about user: desired plant care level, light level, location, etc
	
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
	
	// this is the class to 
}
