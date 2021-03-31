package reminders;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class WaterRemindersTest {
	@Test
	//need to fix the scanners still in order for this to pass
	//also in theory in order for this test to pass you have to input 2020-03-29 and 4
	void testAddReminder() {
		Reminder reminder = new Reminder(4, "2020-03-29");
		ArrayList<Reminder> testRemindersList = new ArrayList<Reminder>();
		testRemindersList.add(reminder);
		var waterReminder = new WaterReminders();
		waterReminder.addReminder();
		assertEquals(testRemindersList, waterReminder.getArrayList());
	}

}
