package main.reminders;
import java.time.LocalDate;

public class Reminder {

	private int wateringInterval;
	private String startDate;
	private LocalDate nextDate;

	public Reminder(int wateringInterval, String startDate) {
		this.wateringInterval = wateringInterval;
		this.startDate = startDate;
		this.nextDate = LocalDate.parse(startDate).plusDays(wateringInterval);
	}

	public void changeWateringInterval(int newWateringInterval) {
		int difference = 0;
		if (this.wateringInterval < newWateringInterval) {
			difference = newWateringInterval - this.wateringInterval;
			this.wateringInterval = newWateringInterval;
			this.nextDate = this.nextDate.plusDays(difference);
		}
		if (this.wateringInterval > newWateringInterval){
			difference = this.wateringInterval - newWateringInterval;
			this.wateringInterval = newWateringInterval;
			this.nextDate = this.nextDate.minusDays(difference);
		}
		else {
			return;
		}

	}
	public int getWateringInterval() {
		return this.wateringInterval;
	}
	
	public String getNextDate() {
		while (this.nextDate.isBefore(LocalDate.now())) {
			this.nextDate = this.nextDate.plusDays(wateringInterval);
		}
		return this.nextDate.toString();
	}

}
