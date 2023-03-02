package sierpinskiTriangle;

public class simulation {

	public static boolean kSim (double theta, double theoryRes) {
		
		//TRUE STUFF
		
		int r = 1; //first circle radius of unit length 1
		
		double h = (r / (Math.sin(theta/2))) + r; //gets height of triangle based off of the angle and radius
		
		String trueLength = removeLastChar(Double.toString(h)); //converts to a non-rounded string
		System.out.println("True Length: " + trueLength);
		
		double Sn = 0;
		
		//THEORETICAL STUFF
		
		for (int i = 1; i < 100000; i++ ) {
			
			Sn += Math.pow((1/theoryRes), (i-1));
			
		} //this for loop basically just is a series from 1 to 100,000 and adds up common ratio
		
		Sn = Sn * 2 * r; //multiplies these fractions by diameter 
		
		String theoreticalLength = removeLastChar(Double.toString(Sn)); //converts to a non-rounded string
		System.out.println("Theory Length: " + theoreticalLength);
		
		//CHECKS IF THEORETICAL LENGTH IS EQUAL TO TRUE LENGTH
		if (theoreticalLength.equals(trueLength)) {
			System.out.println("Theory matches Sim");
			return true;
			
		} else {
			main.diff = Sn - h; //updates difference between theoretical and true
			System.out.println("We have an issue: " + main.diff);
			return false;
			
		}
		
		
	}
	
	//FUNCTION TO REMOVE LAST CHARACTER OF A STRING
	public static String removeLastChar (String string) {
		
		string = string.substring(0, string.length() - 1); //removes the last character of a string
		
		return string;
		
	}
	
}
