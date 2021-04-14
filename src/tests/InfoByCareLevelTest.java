package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.plantInfo.InfoByCareLevel;
import main.Plant;
import main.plantInfo.PlantInformation;

class InfoByCareLevelTest {

	ArrayList<Plant> testPlantList;
	
	@BeforeEach
	void setUp() throws Exception {
		PlantInformation testPI = new PlantInformation();
		testPlantList = testPI.getPlantList();
	}

	@Test
	void sortByCareLevelTest() {
		InfoByCareLevel testIBCL = new InfoByCareLevel(testPlantList);
		Map<Integer, ArrayList<Plant>> sortedPlants = testIBCL.getSortedPlants();
		int plantCount = 0;
		for(int level: sortedPlants.keySet()) {
			for(Plant p: sortedPlants.get(level)) {
				plantCount++;
				if(p.getCareDifficulty() != level)
					fail("Incorrect Sort");
			}
				
		}
		assertEquals(testPlantList.size(), plantCount);
	}

}
