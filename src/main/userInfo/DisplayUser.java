package main.userInfo;

import java.util.Scanner;

import main.Feature;
import main.Menu;

public class DisplayUser implements Feature{
	private Menu menu;
	public DisplayUser(Menu menu) {
		this.menu = menu;
	}
	
	public DisplayUser(UserInfo uinfo) {
		// TODO implement this constructor as replacement
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Display the information of a user";
	}
		
	// Complete desired action
	public void run() {
		Scanner scanner = menu.getScanner();
		System.out.println("Tell us the name of the user you want to view");
		String nameInput = scanner.nextLine();
		//TODO: check if the name exist
		if(nameInput == "") {
			//TODO: loop find index through name;
			System.out.println(menu.getMyUsers().getUser(0));
			System.out.println(menu.getMyUsers().getCare(0));
			System.out.println(menu.getMyUsers().getLight(0));
			System.out.println(menu.getMyUsers().getLoc(0));
		}else {
			System.out.println("You don't have a user with this name.");
		}
	}
}
