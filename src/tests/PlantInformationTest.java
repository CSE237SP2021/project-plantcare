package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.plantInfo.Plant;
import main.plantInfo.PlantInformation;

class PlantInformationTest {

	@Test
	void addPlantTest() {
		PlantInformation testPI = new PlantInformation();
		Plant testPlant = new Plant("test");
		testPI.addPlant(testPlant);
		assertEquals(1,testPI.getNumPlants());
	}
	
	
	@Test
	void readPlantInformationTest() {
		//Compare number of lines in information csv to number of plants read into arraylist plants
		
		
		String testCSVPath = "./src/main/plantInfo/plantInformation.csv";
		File testCSV = new File(testCSVPath);
		int plantCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSV);
			testScanner.useDelimiter("\n");
			//skip label row
			testScanner.next();
			while(testScanner.hasNext()) {
				testScanner.next();
				plantCount++;
			}
			testScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		PlantInformation testPI = new PlantInformation();
		assertEquals(plantCount, testPI.getNumPlants());
	}

}
