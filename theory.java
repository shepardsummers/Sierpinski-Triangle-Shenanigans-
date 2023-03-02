package sierpinskiTriangle;

public class theory {

	public static double kTheory (double theta) {
		
		//all this does is plug theta into equation we derived to get k value
		
		double fin;
		
		double a = (Math.sin(theta/2));
		
		fin = (1 + a)/(1 - a);
				
		return fin;
		
	}
	
	public static double degTheory (double k) {
		
		double theta = 2 * Math.asin((k-1)/(k+1));
		
		return theta;
		
	}
	
}
