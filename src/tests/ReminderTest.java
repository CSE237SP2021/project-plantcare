package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.reminders.Reminder;

class ReminderTest {
	Reminder reminder = new Reminder(4, "2021-10-01");
	Reminder reminderPast = new Reminder(20, "2021-02-01");
	Reminder reminderPastSmall = new Reminder(3, "2021-03-01");
	@Test
	void testChangeWateringIntervalSmaller() {
		int newWateringInterval = 3;
		reminder.changeWateringInterval(newWateringInterval);
		assertEquals(3, reminder.getWateringInterval());
		assertEquals("2021-10-04", reminder.getNextDate());
	}
	@Test
	void testChangeWateringIntervalLarger() {
		int newWateringInterval = 5;
		reminder.changeWateringInterval(newWateringInterval);
		assertEquals(5, reminder.getWateringInterval());
		assertEquals("2021-10-06", reminder.getNextDate());
	}
	@Test
	void testGetNextDateWithPastStartDate() {
		assertEquals("2021-04-22", reminderPast.getNextDate());
	}
	@Test
	//this one needs to be updated often for it to pass
	void testGetNextDateWithPastStartDateAndSmallInterval() {
		assertEquals("2021-04-15", reminderPastSmall.getNextDate());
	}
}
