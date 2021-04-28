package main.userInfo;

import java.util.ArrayList;

import main.Feature;
import main.Plant;
import main.Menu;
import java.util.Scanner;
import main.plantInfo.PlantInformation;


public class AddUser implements Feature {

	private UserInfo uinfo;
	public AddUser(UserInfo uinfo) {
		this.uinfo = uinfo;
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Add a new user";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please name your new user");
		String userInput = scanner.nextLine();
		boolean isValid = false;

		//TODO: add the user
		while(!isValid) {
			if(userInput == "") {
				System.out.println("The username should not be empty");
				userInput= scanner.nextLine();
			}
			else if(uinfo.getAllUsers().contains(userInput))
			{
				System.out.println("User name already exists");
				userInput= scanner.nextLine();
				
			}	
			else {
				isValid = true;
			}
			
		}
		uinfo.AddUser(userInput);
		
		System.out.println("User added! Now enter the desired care level from 1 to 10");
		int careInput= scanner.nextInt();
		
		while(careInput<1 || careInput>10) {
			System.out.println("Out of range, please enter an integer between 1 and 10");
			careInput= scanner.nextInt();
		}
		
	
	}
}
