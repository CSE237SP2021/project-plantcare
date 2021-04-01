package main.plantInfo;
import java.util.ArrayList;

import main.Feature;

public class ShowAllInfo implements Feature{

	private ArrayList<Plant> plants;
	
	public ShowAllInfo(ArrayList<Plant> plantList) {
		plants = plantList;
	}
	
	public String getLabel() {
		return "Show all information";
	}

	public void run() {
		// TODO Auto-generated method stub
		for(Plant p: plants) {
			System.out.println(p.toString());
		}
		
	}
	
}