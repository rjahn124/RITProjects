/**
 * 
 */

/**
 * @author jordj
 *
 */
//abstract class function is the paret function that contains evaluate, isConstant, derivative, and toString
//whic are all abstract methods

public abstract class Function {
	
	//evaluates the given function
	abstract double evaluate(double x);
	
	//boolean that checks whether or not function is true or false
	abstract boolean isConstant();
	
	//caculates the integral of a function using the trapezoid rule
	public double integral(double x, int y,int z){
		double diff= this.evaluate(y)+ (2*this.evaluate(z));
		double divi = x/2;
		double answr = diff * divi;
		
		return answr;
	}
	
	public abstract String toString();
	
	//returns a function of the derivative of the given function
	abstract Function derivative();
	
	
	

}
