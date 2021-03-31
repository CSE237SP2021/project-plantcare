package reminders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReminderTest {
	Reminder reminder = new Reminder(4, "2021-10-01");
	@Test
	void testChangeWateringInterval() {
		int newWateringInterval = 3;
		reminder.changeWateringInterval(newWateringInterval);
		assertEquals(3, reminder.getWateringINterval());
		assertEquals("2021-10-04", reminder.getNextDate());
	}
}
