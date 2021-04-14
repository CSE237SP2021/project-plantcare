package main.plantInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.Feature;
import main.Plant;

public class InfoByCareLevel implements Feature {

	private Map<Integer,ArrayList<Plant>> sortedPlants;
	
	public InfoByCareLevel(ArrayList<Plant> plantList) {
		sortedPlants = sortByCareLevel(plantList);
	}
	
	@Override
	public String getLabel() {
		return "Show by level of care";
	}

	@Override
	public void run() {
		System.out.println("Desired care level ?/10 (0 to exit): ");
		Scanner careReader = new Scanner(System.in);
		int level = careReader.nextInt();
		while(!sortedPlants.containsKey(level) && level != 0) {
			System.out.println("Invaild level. Try again.");
			level = careReader.nextInt();
		}
		System.out.println();
		if (level == 0)
			return;
		for(Plant p: sortedPlants.get(level)) {
			System.out.println(p.toString());
		}
		
	}

	public Map<Integer,ArrayList<Plant>> getSortedPlants() {
		return sortedPlants;
	}

	
	/*
	 * Sorts plant list into map of plants by using care level as key
	 */
	private Map<Integer,ArrayList<Plant>> sortByCareLevel(ArrayList<Plant> plantList) {
		Map<Integer,ArrayList<Plant>> sortedPlants = new HashMap<Integer, ArrayList<Plant>>();
		for(Plant p: plantList) {
			int careLevel = p.getCareDifficulty();
			if(!sortedPlants.containsKey(careLevel)) {
				sortedPlants.put(careLevel, new ArrayList<Plant>());
			}
			sortedPlants.get(careLevel).add(p);
		}
		return sortedPlants;
		// TODO Auto-generated method stub
		
	}

}
