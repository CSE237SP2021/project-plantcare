package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

import java.util.ArrayList;

import main.Feature;
import main.Plant;
import main.Menu;
import java.util.Scanner;
import main.plantInfo.PlantInformation;
import main.trackPlants.*;



/*test upgrading
We are currently unsatisfied for the interaction performance of plant tracker and upgrading it at the branch trackPlants.
Our Solution is to switch the tracking list from an arraylist in menu into a csv file.
Check the branch trackPlants for progress.
*/

class PlantTrackerTest {
	
	private Menu testMenu;
	
	@BeforeEach
	void setUpTestMenu() {

		Menu testMenu = new Menu();
		testMenu.addFeature(new AddPlants(testMenu));
		testMenu.addFeature(new DeletePlant(testMenu));
		testMenu.addFeature(new DisplayPlant(testMenu));
		
		
	}

	@Test
	void addPlantTest() {

		final InputStream consoleInput = System.in;
	    final PrintStream consoleOutput = System.out;
	    try {
	        final PipedOutputStream testInput = new PipedOutputStream();
	        final PipedOutputStream out = new PipedOutputStream();
	        final PipedInputStream testOutput = new PipedInputStream(out);
	        System.setIn(new PipedInputStream(testInput));
	        System.setOut(new PrintStream(out));
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    PrintStream testPrint = new PrintStream(testInput);
	                    BufferedReader testReader = new BufferedReader(
	                            new InputStreamReader(testOutput));
	                    assertEquals("Tell us the species of your new plant", testReader.readLine());
	                    ArrayList<Plant> testPlants = new ArrayList<Plant>();
	            		testPlants.add(new Plant("testPothos", "Epipremnum aureum","20-40' tall; 3-6' wide", 2,"Full sun; partial shade","Moist; well-drained","N/A"));
	                   
	                    for(int i =0; i< testPlants.size();i++) {	                    
	                        testPrint.println(testPlants.get(i).getPlantSpecies());
	                        testPrint.flush();
	                        System.err.println(testPlants.get(i).getPlantSpecies());
	                        String speciesFeedback = testReader.readLine();
	                        if (speciesFeedback.equals("Please name your plant")) {
	                        	testPrint.println(testPlants.get(i).plantName);
		                        testPrint.flush();
		                        System.err.println(testPlants.get(i).plantName);
		                        String nameFeedback = testReader.readLine();
	                        	if (nameFeedback.equals("Successfully add plant."))
		                            break;
		                        else
		                            fail("Unrecognized feedback: " + nameFeedback);
	                        }

	                        
	                    }
	                } catch (IOException e) {
	                    e.printStackTrace(consoleOutput);
	                } 
	            }
	        }).start();
	        testMenu.makeSelectionLoop();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	        fail(e.getMessage());
	    }
	    System.setIn(consoleInput);
	    System.setOut(consoleOutput);
	}

	
// following test only point for goals but not functional yet.
	@Test
	void deletePlantTest() {
		assertTrue(true);
	}
	
	@Test
	void displayPlantTest() {
		assertTrue(true);
	}
	
	@Test
	void addMultiplePlantTest() {
		assertTrue(true);
	}
	
	@Test
	void displayAllPlantTest() {
		assertTrue(true);
	}
	@Test
	void InvalidUserInputTest() {
		assertTrue(true);
	}
}
