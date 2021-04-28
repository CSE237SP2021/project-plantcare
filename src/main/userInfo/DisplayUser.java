package main.userInfo;

import java.util.Scanner;

import main.Feature;
import main.Menu;

public class DisplayUser implements Feature{
	
	private UserInfo uinfo;
	
	
	public DisplayUser(UserInfo uinfo) {
		this.uinfo = uinfo;
	}
	
	// Get label to appear in menu
	public String getLabel() {
		return "Display the information of a user";
	}
		
	// Complete desired action
	public void run() {
		
		if(uinfo.getNumUsers()==0) {
			System.out.println("No user exists");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tell us the name of the user you want to view");
		String nameInput = scanner.nextLine();
		
		//TODO: check if the name exist

		while(!uinfo.getAllUsers().contains(nameInput)) {
			//TODO: loop find index through name;			
			System.out.println("This username does not exist in the datatbase! Please try again!");
			nameInput = scanner.nextLine();
		}
		
		int index = uinfo.getAllUsers().indexOf(nameInput);
		System.out.println(uinfo.getUser(index));
		System.out.println(uinfo.getCare(index));
		System.out.println(uinfo.getLight(index));
		System.out.println(uinfo.getLoc(index));

	}
}
