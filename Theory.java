package sierpinskiTriangle;

public class theory {

	public static double kTheory (double theta) {
		
		//all this does is plug theta into equation we derived to get k value
		
		double fin;
		
		double a = (Math.tan(theta/2));
		
		fin = (1 + a)/(1 - a);
				
		return fin;
		
	}
	
}
