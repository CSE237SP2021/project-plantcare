package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.Menu;

import org.junit.jupiter.api.Test;

import main.Plant;
import main.reminders.AddReminder;

class AddReminderTest {

	/* TODO Delete; AddReminder class should not have tests.
	 * Test modifications to reminders in Reminder test
	 */
	
	@Test
	void testaddReminder() {
		String testRemindersPath = ".src/main/";
		Plant testPlant = new Plant("john", "Asparagus", "2' tall;6' wide", 2, "Indirect", "Well drained", "Summer");
		Menu testMenu = new Menu();
		//testMenu.getMyPlants().add(testPlant);
		
	}

}