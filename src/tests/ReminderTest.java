package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.reminders.Reminder;

class ReminderTest {
	Reminder reminder = new Reminder(4, "2021-10-01");
	@Test
	void testChangeWateringInterval() {
		int newWateringInterval = 3;
		reminder.changeWateringInterval(newWateringInterval);
		assertEquals(3, reminder.getWateringInterval());
		assertEquals("2021-10-04", reminder.getNextDate());
	}
}
