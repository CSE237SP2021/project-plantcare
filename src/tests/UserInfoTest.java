package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Menu;
import main.trackPlants.AddPlant;
import main.trackPlants.DeletePlant;
import main.trackPlants.DisplayPlant;
import main.trackPlants.TrackPlants;
import main.userInfo.UserInfo;


class UserInfoTest {

	
	
	private Menu testMenu;
	
	@BeforeEach
	void setUpTestMenu() {
		
		testMenu = new Menu();
		
		TrackPlants testTracker = new TrackPlants();
		
		
		testMenu.addFeature(new AddPlant(testTracker));
		testMenu.addFeature(new DeletePlant(testTracker));
		testMenu.addFeature(new DisplayPlant(testTracker));
		
		
	}
	void setUp() throws Exception {

	}

	@Test
	void sortByCareLevelTest() {

			}
	
	
	
	@Test
	void testReadUserList() {
		String testCSVPath = "./src/main/userInfo/userinformation.csv";
		File testCSV = new File(testCSVPath);
		int userCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSV);
			testScanner.useDelimiter("\n");
			//skip label row
			testScanner.next();
			while(testScanner.hasNext()) {
				testScanner.next();
				userCount++;
			}
			testScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		UserInfo testTracker = new UserInfo();
		//testTracker.setPlantList(testTracker.readPlantList("./src/main/userInfo/userinformation.csv"));
		//assertEquals(userCount, testTracker.getNumPlants());
	}
	
	
		
	}