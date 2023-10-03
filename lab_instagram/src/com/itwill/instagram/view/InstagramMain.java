package com.itwill.instagram.view;
import java.util.Scanner;
import com.itwill.instagram.controller.InstaMemberDaoImpl;
import com.itwill.instagram.model.InstaMember;

public class InstagramMain {

	public static void main(String[] args) {
		InstaMemberDaoImpl instaMemberDaoImpl = new InstaMemberDaoImpl();
		instaMemberDaoImpl.run();
	}
	
	
//	private Scanner scanner = new Scanner(System.in);
//	private InstaMemberDaoImpl dao = InstaMemberDaoImpl.getInstance();
//
//	public static void main(String[] args) {
//		System.out.println("*****INSTAGRAM*****");
//		InstagramMain app = new InstagramMain();
//
//		boolean run = true;
//
//		while(run) {
//			int choice = app.firstWindow();
//
//			switch(choice) {
//			case 0: //exit instagram...
//				run = false;
//				System.out.println("EXIT INSTAGRAM :)");
//				break;
//			case 1: //log in instagram....
//				app.signInMethod();
//				break;
//			case 2: //sign up instagram....
//				app.signUpMethod();
//				break;
//			case 3: //find Id or Password...
//				app.findIdPwd();
//				break;
//			case 100:
//				app.showAllMember();
//				break;
//			default:
//				System.out.println("Choose Wrong Menu Number");
//				System.out.println("Please Choice Correct Number...");
//				System.out.println();
//				break;
//			}
//
//		}//end of while...
//
//	}//end of main...
//
//	private void showAllMember() {
//		if(dao.getCount()==0) {
//			System.out.println(" >> No Account...");
//		} else if(dao.getCount()!=0) {
//			System.out.println("Account List....");
//			
//			InstaMember[] members = dao.read();
//			for(int i = 0; i<members.length; i++) {
//				System.out.printf("%d) %s",i,members[i]);
//			}
//		}
//		System.out.println();
//	}//end showAllMember...
//
//	private void findIdPwd() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private void signUpMethod() {
//		System.out.println(" >> Create Instagram Account...!");
//		System.out.print("Type ID...>> ");
//		String id = scanner.nextLine();
//		System.out.print("Type Password...>> ");
//		String password = scanner.nextLine();
//		System.out.print("Type E-Mail...>> ");
//		String email = scanner.nextLine();
//		System.out.print("Type Name...>> ");
//		String name = scanner.nextLine();
//		System.out.print("Type Phone Number...>> ");
//		String phone = scanner.nextLine();
//		
//		InstaMember instaPerson = new InstaMember(id, password, email, name, phone);
//		int result = dao.create(instaPerson);
//		
//		if(result==1) {
//			System.out.println(" >> WELCOME INSTAGRAM...:)");
//		} else {
//			System.out.println(" >> SORRY TRY AGAIN....");
//		}
//	} // end of signUpMethod...
//
//	private void signInMethod() {
//		System.out.println("Sign-In.....");
//		System.out.print("Type Id.... >> ");
//		String id = scanner.nextLine();
//		System.out.print("Type Password....>> ");
//		String password = scanner.nextLine();
//		
//		InstaMember instaMember = dao.read(id, password);
//		
//		if(instaMember != null) {
//			System.out.println("Hello "+id);
//		} else {
//			System.out.println("Wrong Sign-In Info Please Type Again...");
//		}
//		
//	}//end of signInMethod
//
//	private int firstWindow() {
//		System.out.println("Welcome to Instagram Console App");
//		System.out.println("1. Sign In");
//		System.out.println("2. Sign Up");
//		System.out.println("3. Find Id or Password");
//		System.out.println("0. Exit");
//		System.out.print("Enter your choice >> ");
//		int choice = Integer.parseInt(scanner.nextLine());
//
//		return choice;
//	}//end of firstWindow()...
//
	
}//end of class InstagramMain...
