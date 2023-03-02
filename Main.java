package sierpinskiTriangle;

import java.util.Scanner;

public class main {
	
	/*
	 * Sierpinski Triangle Common-Ratio Code
	 * Written by Shepard Summers
	 * 
	 * A Sierpinski Triangle when you draw the largest circle you can withing a triangle, then repeat the process
	 * 
	 * Basically this program prompts for an interior angle then calculates the ratio that the circles radius/diameter decreases by
	 * as the circles approace the angle
	 * 
	 */

	public static double diff = 0;
	
	public static void main(String[] args) {
		
		//User inputs an angle and gets a common ratio in return
		
		angleToK();
		
		//Checks whether theoretical calculations are accurate to true values
		
		//check();
		
		
	}
	
	public static void angleToK () {
		
		//GETS USER INPUT
		Scanner scanner = new Scanner(System.in); //creates scanner
		System.out.println("Please input angle in degrees");
		double degrees =  Double.parseDouble(scanner.nextLine()); //converts user input to a decimal number
		scanner.close(); //closes scanner to save resources
		
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
		
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		System.out.println("Number of Descrepencies is " + fCount);
		System.out.println("Avg Descrepency is " + diffStorage/fCount);
			
		}
		
	}
}
