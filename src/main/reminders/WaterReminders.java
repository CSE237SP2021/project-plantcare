package main.reminders;
import main.Feature;
import main.Menu;
import main.Plant;

import java.util.HashMap;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class WaterReminders implements Feature{
	/*
	 * Acts as tracker for reminder information, read in from Reminders.csv
	 * stores, displays, creates and deletes reminders to water your plants
	 */
	
	private ArrayList<Reminder> reminderList;
	private String listPath = "./src/main/reminders/Reminders.csv";
	
	
	public WaterReminders(){
		reminderList = new ArrayList<Reminder>();
		File list = new File(listPath);
		try {
			if(list.createNewFile()) {
				FileWriter writer = new FileWriter(list);
				writer.append("Plant Name, Start Date, Next Watering Date, Watering Interval\n");
				writer.close();
			}
			else
				reminderList = readReminderList();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getLabel() {
		return "Watering Schedule";
	}
	
	@Override
	public void run() {
		Menu waterMenu = new Menu();
		
		waterMenu.addFeature(new AddReminder(this));
		//waterMenu.addFeature(new DeleteReminder(this));
		//waterMenu.addFeature(new ShowReminders(this)); //show next watering reminder
		
		
		
		waterMenu.makeSelectionLoop();
	}
	
	public ArrayList<Reminder> readReminderList() {
		ArrayList<Reminder> reminderList = new ArrayList<Reminder>();
		try 
		{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(listPath));
			String line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				String[] splitInfo = line.split(",");
				Reminder newReminder = new Reminder(
						splitInfo[0], 
						Integer.parseInt(splitInfo[3]), 
						splitInfo[1]);
				reminderList.add(newReminder);
			} }
			catch (IOException e) {
				e.printStackTrace();
			}
			return reminderList;
		}
	
	private void updateCSV() {
		File list = new File(listPath);
		try {
			FileWriter writer = new FileWriter(list);
			writer.append("Plant Name, Start Date, Next Watering Date, Watering Interval\n");
			for(Reminder reminder: reminderList) {
				writer.append(
						String.format(
								"%s,%s,%s,%d\n",
								reminder.getPlantName(),
								reminder.getStartDate(),
								reminder.getNextDate(),
								reminder.getWateringInterval()));
			}
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getNumReminders() {
		return reminderList.size();
	}
	
	public void setReminderList(ArrayList<Reminder> list) {
		reminderList = list;
	}
	
	public void addReminder(Reminder newReminder) {
		reminderList.add(newReminder);
		updateCSV();
	}
	
	public void setListPath(String path) {
		listPath = path;
	}
}

