package sierpinskiTriangle;

import java.util.Scanner;

public class main {
	
	/*
	 * Sierpinski Triangle Common-Ratio Code
	 * Written by Shepard Summers
	 * 
	 * A Sierpinski Triangle when you draw the largest circle you can within a triangle, then repeat the process (see read me file)
	 * 
	 * Basically this program prompts for an interior angle then calculates the ratio that the circles radius/diameter decreases by
	 * as the circles approace the angle and vice-versa
	 * 
	 */

	public static double diff = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //creates scanner
		boolean loop = true;
		
		while (loop == true) {
		    System.out.println("Please select:");
		    System.out.println("1 || K Value to Angle");
		    System.out.println("2 || Angle to K Value");
		    System.out.println("3 || Check Program");
		    System.out.println("4 || Exit");
		    
			String response =  scanner.nextLine(); //reads user input
			
			switch (response) {
			
			case "1":
				//User inputs a k value and gets an angle in return
				System.out.println("Please input k");
				double kValue =  Double.parseDouble(scanner.nextLine()); //converts user input to a decimal number
				kToAngle(kValue);
				break;
			case "2":
				//User inputs an angle and gets a common ratio in return
				System.out.println("Please input angle in degrees");
				double degrees =  Double.parseDouble(scanner.nextLine()); //converts user input to a decimal number
				angleToK(degrees);
				break;
			case "3":
				//Checks whether theoretical calculations are accurate to true values
				check();
				break;
			case "4":
				loop = false;
				break;
			default:
				System.out.println("ERROR: Please input either 1, 2, or 3");
				break;
			
			}
		
		}
		
		scanner.close(); //closes scanner to save
		System.out.println("Code has been stopped");

	}
	
	public static void kToAngle(double kValue) {
			
		double theta = theory.degTheory(kValue);
		double degrees = Math.toDegrees(theta); //converts degrees to radians
				
		System.out.println("The angle for common ratio " + kValue + " between circles is " + degrees);
		
	}
	
	public static void angleToK (double degrees) {
		
		double theta = Math.toRadians(degrees); //converts degrees to radians
		
		double kValue = theory.kTheory(theta); //obtains k value
		System.out.println("The common ratio between circles is " + kValue); 
		
	}
	
	public static void check() {
		
		int degrees = 0;
		int fCount = 0; //number of false returns from simulation class
		double diffStorage = 0; //stores the total difference between true and theoretical heights
		
		for (int n = 1; n < 90; n++) {
			
			degrees += 1;
			System.out.println("For: " + degrees + " degrees -------------------------------");
			
			double theta = Math.toRadians(degrees); //converts to radians
			double theoryRes = theory.kTheory(theta); //obtains theoretical k value
			Boolean correct = simulation.kSim(theta, theoryRes); //records true/false whether true and theoretical match
			
			System.out.println("Theoretical Value for K: " + theoryRes);
			
			if (correct == false) {
				
				fCount += 1;
				diffStorage += diff; //stores difference for this increment 
				
			}
			
		}
		
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		System.out.println("Number of Descrepencies is " + fCount);
		System.out.println("Avg Descrepency is " + diffStorage/fCount);
		
	}
}
