package main.userInfo;

import java.util.ArrayList;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;
import main.userInfo.*;


public class DeleteUser implements Feature{
	
	private UserInfo uinfo;;
	
	public DeleteUser(UserInfo uinfo) {
		this.uinfo = uinfo;
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Stop tracking a user";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tell us the name of the user you want to stop tracking");
		String nameInput = scanner.nextLine();
		//TODO: check if the name exist
		if(uinfo.getNumUsers()==0) {
			System.out.println("No user exists");
			return;
		}
		while(!uinfo.getAllUsers().contains(nameInput)) {
			//TODO: loop find index through name;			
			System.out.println("This username does not exist in the datatbase! Please try again!");
			nameInput = scanner.nextLine();
		}
		
		uinfo.DeleteUser(nameInput);
	
	}

}
