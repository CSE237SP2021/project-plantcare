package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
		testTracker.setListPath(testCSVPath);
		testTracker.setPlantList(testTracker.readPlantList());
		assertEquals(plantCount, testTracker.getNumPlants());
	}
	
	@Test
	void testAddPlant() {
		Path copied = Paths.get("./src/main/trackPlants/myPlants_test.csv");
		Path originalPath = Paths.get("./src/main/trackPlants/myPlants_original.csv");
		try {
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			
		}
		
		File testCSV = copied.toFile();
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
		testTracker.setListPath(copied.toString());
		testTracker.setPlantList(testTracker.readPlantList());
		Plant testPlant = new Plant("PothosTest", "Pothos", "2021-04-13", 7);
		testTracker.addPlant(testPlant);
		
		File testCSVpost = new File(copied.toString());
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
		
		assertEquals(beforePlantCount + 1, testTracker.getNumPlants());
		assertEquals(beforePlantCount + 1, plantCount);
	}
	
	@Test
	void testDeletePlant() {
		Path copied = Paths.get("./src/main/trackPlants/myPlants_test.csv");
		Path originalPath = Paths.get("./src/main/trackPlants/myPlants_original.csv");
		try {
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			System.out.print(e1.getMessage());
			System.out.print(e1.getCause());
			e1.printStackTrace();
		}
		
		File testCSV = copied.toFile();

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
		testTracker.setListPath(copied.toString());
		testTracker.setPlantList(testTracker.readPlantList());
		Plant testPlant = testTracker.getPlant(2);
		testTracker.deletePlant(2);
		
		File testCSVpost = new File(copied.toString());
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
		assertEquals(beforePlantCount - 1, testTracker.getNumPlants());
		assertEquals(beforePlantCount - 1, plantCount);
	}


}
