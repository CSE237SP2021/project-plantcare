package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.reminders.WaterReminders;

class WaterRemindersTest {

	@Test
	void testReadReminderList() {
		String testCSVPath = "./src/main/reminders/Reminders.csv";
		File testCSV = new File(testCSVPath);
		int reminderCount = 0;
		try {
			Scanner testScanner = new Scanner(testCSV);
			testScanner.useDelimiter("\n");
			testScanner.next();
			while(testScanner.hasNext()) {
				testScanner.next();
				reminderCount++;
			}
			testScanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		WaterReminders testWaterReminders = new WaterReminders();
		testWaterReminders.setListPath(testCSVPath);
		testWaterReminders.setReminderList(testWaterReminders.readReminderList());
		assertEquals(reminderCount, testWaterReminders.getNumReminders());
	}

}
