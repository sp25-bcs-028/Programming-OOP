import java.util.Scanner;

public class userController{
	String name;
	int registrationNumber;
	int age; 
	public userController(){
		name = "";
		registrationNumber = 0;
		age = 0;	
	}
	public void displayUser(){
		System.out.printf("Enter your name: %s \n", name);
		System.out.printf("Enter your Regitraion Number: %d \n" , registrationNumber);
		System.out.printf("Enter your Age: %d \n" , age);
	}
	
	public void setUser(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		name = scanner.nextLine();
		System.out.print("Enter your Regitraion Number: ");
		registrationNumber = scanner.nextInt();
		System.out.print("Enter your Age: ");
		age = scanner.nextInt();
	}
 
}
