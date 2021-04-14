package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Plant;
import main.trackPlants.TrackPlants;



class TrackPlantsTest {

	@Test
	void testReadPlantsList() {
		String testCSVPath = "./src/main/trackPlants/myPlants_original.csv";
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
		
		TrackPlants testTracker = new TrackPlants();
		testTracker.setPlantList(testTracker.readPlantList("./src/main/trackPlants/myPlants_original.csv"));
		assertEquals(plantCount, testTracker.getNumPlants());
	}
	
	@Test
	void testAddPlant() {
		String testCSVPath = "./src/main/trackPlants/myPlants.csv";
		File testCSV = new File(testCSVPath);
		int beforePlantCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSV);
			testScanner.useDelimiter("\n");
			//skip label row
			testScanner.next();
			while(testScanner.hasNext()) {
				testScanner.next();
				beforePlantCount++;
			}
			testScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		TrackPlants testTracker = new TrackPlants();
		testTracker.setPlantList(testTracker.readPlantList(testCSVPath));
		Plant testPlant = new Plant("PothosTest", "Pothos", "2021-04-13", 7);
		testTracker.addPlant(testPlant);
		
		File testCSVpost = new File(testCSVPath);
		int plantCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSVpost);
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
		assertEquals(beforePlantCount + 1, plantCount);
		assertEquals(beforePlantCount + 1, testTracker.getNumPlants());
	}
	
	@Test
	void testDeletePlant() {
		String testCSVPath = "./src/main/trackPlants/myPlants.csv";
		File testCSV = new File(testCSVPath);
		int beforePlantCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSV);
			testScanner.useDelimiter("\n");
			//skip label row
			testScanner.next();
			while(testScanner.hasNext()) {
				testScanner.next();
				beforePlantCount++;
			}
			testScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		TrackPlants testTracker = new TrackPlants();
		testTracker.setPlantList(testTracker.readPlantList(testCSVPath));
		Plant testPlant = testTracker.getPlant(2);
		testTracker.deletePlant(2);
		
		File testCSVpost = new File(testCSVPath);
		int plantCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSVpost);
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
		assertEquals(beforePlantCount - 1, plantCount);
		assertEquals(beforePlantCount - 1, testTracker.getNumPlants());
	}


}
