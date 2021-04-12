package main.userInfo;

import java.util.ArrayList;
import java.util.Scanner;

import main.Feature;
import main.Menu;
import main.Plant;
import main.UserInfo;
import main.userInfo.*;


public class DeleteUser implements Feature{
	private Menu menu;
	public DeleteUser(Menu menu) {
		this.menu = menu;
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Stop tracking a user";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = menu.getScanner();
		System.out.println("Tell us the name of the user you want to stop tracking");
		String nameInput = scanner.nextLine();
		//TODO: check if the name exist
		if(nameInput == "") {
			//TODO: loop find index through name;
			menu.getMyUsers().DeleteUser(nameInput);
			
			System.out.println("You don't have a user with this name.");
		}
	}

}
