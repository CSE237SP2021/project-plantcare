package main.plantInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.Feature;

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
		// TODO Auto-generated method stub
		for(int level = 0; level<=10; level++) {
			if(sortedPlants.containsKey(level)) {
				System.out.println("Care Level: " + level);
				for(Plant p: sortedPlants.get(level)) {
					System.out.println(p.getPlantName());
				}
				System.out.println();
			}
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
